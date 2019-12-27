package com.haiyu.manager.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haiyu.manager.constant.WeChatErrcodeConstant;
import com.haiyu.manager.constant.WeChatUrlConstant;
import com.haiyu.manager.pojo.wechat.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 15:22
 */
@Slf4j
@Validated
public class WeixinManagerServiceUtil {

    private static final String TAG = "微信第三方信息获取服务类-WeixinManagerServiceImpl";

    public static final String CACHE_WCT_GLOBAL_ACCESS_TOKEN = "wct:globalAccessToken:";
    public static ConcurrentHashMap<String, String> maps = new ConcurrentHashMap();
    public static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

    public static String getGlobalAccessToken(@NotNull String appId, @NotNull String secret) {
        String globalAccessToken = maps.get(CACHE_WCT_GLOBAL_ACCESS_TOKEN + appId);
        if (globalAccessToken == null) {
            String requestGlobalAccessTokenUrl = String.format("%s?grant_type=client_credential&appid=%s&secret=%s",
                    WeChatUrlConstant.WEIXIN_ACCESS_TOKEN_URL, appId, secret);
            String jsonResult = HttpClientUtil.doGet(requestGlobalAccessTokenUrl);
            log.debug("获取jsonResult返回结果response:{},请求参数params:{}", jsonResult, requestGlobalAccessTokenUrl);
            JSONObject jsonObject = JSON.parseObject(jsonResult);
            if (Objects.isNull(jsonObject)) {
                log.error("{}获取accessToken失败jsonObject为空!jsonResult:{},参数params:appId:{},secret:{}",
                        TAG, jsonResult, appId, secret);
            }
            Integer errcode = jsonObject.getInteger("errcode");
            if (Objects.nonNull(errcode) && !Objects.equals(WeChatErrcodeConstant.ERRCODE_SUCCESS, errcode)) {
                String errmsg = jsonObject.getString("errmsg");
                log.error("{}获取accessToken失败!错误码errcode:{},errmsg:{},参数params:appId:{},secret:{}",
                        TAG, errcode, errmsg, appId, secret);
            }
            WeixinGlobalAccessTokenVO weixinGlobalAccessTokenVO = new WeixinGlobalAccessTokenVO();
            weixinGlobalAccessTokenVO.setAccessToken(jsonObject.getString("access_token"));
            weixinGlobalAccessTokenVO.setExpiresIn(jsonObject.getInteger("expires_in"));
            globalAccessToken = weixinGlobalAccessTokenVO.getAccessToken();
            // 提前2分钟过期
            Integer expiresIn = weixinGlobalAccessTokenVO.getExpiresIn() - 120;
            maps.put(CACHE_WCT_GLOBAL_ACCESS_TOKEN + appId, globalAccessToken + expiresIn);
        }
        return globalAccessToken;

    }

    public static WeixinPersonalAccessTokenVO getPersonalAccessToken(String appid, String sec, String code) {
        log.debug("{},微信请求参数:wechatConfigVO:{},code:{}", TAG, appid, code);
        String requestCodeUrl = String.format(WeChatUrlConstant.OAUTH_2_URL, appid, sec, code);
        String jsonResult = HttpClientUtil.doGet(requestCodeUrl);
        log.info("getPersonalAccessToken json: {}", jsonResult);
        return JSON.parseObject(jsonResult, WeixinPersonalAccessTokenVO.class);
    }

    public static WeixinMinProgramSessionVO getPersonalSession(String appid, String sec, String code) {
        log.debug("{},微信请求参数:wechatConfigVO:{},code:{}", TAG, appid, code);
        String requestCodeUrl = String.format(WeChatUrlConstant.CODE_2_SESSION_URL, appid, sec, code);
        String jsonResult = HttpClientUtil.doGet(requestCodeUrl);
        log.info("getPersonalAccessToken json: {}", jsonResult);
        WeixinMinProgramSessionVO weixinMinProgramSessionVO = JSON.parseObject(jsonResult, WeixinMinProgramSessionVO.class);
        if (Objects.isNull(weixinMinProgramSessionVO)) {
            log.error("{},获取微信数据错误,appid：{},secret：{},code：{},errormsg：{}", TAG, appid, sec, code, weixinMinProgramSessionVO.getErrmsg());
        }
        return weixinMinProgramSessionVO;
    }

    public Integer getOpenID(String appid, String sec, String code) {
        log.debug("{},微信请求参数:wechatConfigVO:{},code:{}", TAG, appid, code);
        String requestCodeUrl = String.format(WeChatUrlConstant.OAUTH_2_URL, appid, sec, code);
        ObjectMapper objectMapper = new ObjectMapper();
        String content = HttpClientUtil.doGet(requestCodeUrl);
        try {
            Map map = objectMapper.readValue(content, Map.class);
            String openId = String.valueOf(map.get("openid"));
            return Integer.valueOf(openId);
        } catch (JsonParseException e) {
            log.error("json解析失败：", e);
        } catch (JsonMappingException e) {
            log.error("map转换成json失败：", e);
        } catch (Exception e) {
            log.error("http获取openId请求失败：", e);
        }
        return 0;
    }

    public static WeixinJSSDKConfigVO getWeixinJSSDKConfig(String appid, String sec, String url) {
        log.debug("{},微信请求参数:wechatConfigVO:{},url:{}", TAG, appid, url);
        String accessToken = getGlobalAccessToken(appid, sec);
        String requestJsapiTicketUrl = String.format(JSAPI_TICKET_URL, accessToken);
        String jsonResult = HttpClientUtil.doGet(requestJsapiTicketUrl);
        WeixinJsapiTicketVO jsapiTicketVO = JSON.parseObject(jsonResult, WeixinJsapiTicketVO.class);
        log.info("获取微信WeixinJSSDKConfig失败jsonResult:{}:", jsonResult);
        if (jsapiTicketVO.getErrcode() == 0) {
            String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
            String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
            String data = String.format("jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s", jsapiTicketVO.getTicket(), noncestr, timestamp, url);
            String signature = EncryptUtils.encryptSHA1(data);
            WeixinJSSDKConfigVO weixinJSSDKConfigVO = new WeixinJSSDKConfigVO();
            weixinJSSDKConfigVO.setAppId(appid);
            weixinJSSDKConfigVO.setNonceStr(noncestr);
            weixinJSSDKConfigVO.setTimestamp(timestamp);
            weixinJSSDKConfigVO.setSignature(signature);
            return weixinJSSDKConfigVO;
        }
        log.error("获取微信WeixinJSSDKConfig失败errcode:{}:", jsapiTicketVO.getErrcode());
        return null;
    }
}
