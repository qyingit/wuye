package com.manager.controller.api;

import com.alibaba.fastjson.JSON;
import com.manager.common.utils.CheckUtil;
import com.manager.util.WechatMessageUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/31 11:15
 */
@Controller
public class FirstController {

    @RequestMapping(value = "/verify_wx_token",method = RequestMethod.GET)
    public void getWechat(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = null;

        try {
            out = response.getWriter();
            if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
                out.write(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }



    @RequestMapping(value = "/verify_wx_token",method = RequestMethod.POST)
    public void getWechatInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        try{
            Map<String, String> requestMap = WechatMessageUtil.parseXml(request);
            System.out.println("============================="+ JSON.toJSONString(requestMap));

            String event = requestMap.get("Event");
            String fromUserName = requestMap.get("FromUserName");
            String toUserName = requestMap.get("ToUserName");
            String key = requestMap.get("EventKey");

            String respStrstart= "<xml>\n" +
                    "  <ToUserName><![CDATA["+fromUserName+"]]></ToUserName>\n" +
                    "  <FromUserName><![CDATA["+toUserName+"]]></FromUserName>\n" +
                    "  <CreateTime>"+System.currentTimeMillis()+"</CreateTime>";
            if ("subscribe".equals(event)) {
                respStrstart +=" <MsgType><![CDATA[text]]></MsgType>" +
                        "<Content><![CDATA[你好]]></Content>";
            }else if("unsubscribe".equals(event)){
                respStrstart +="<MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[你好1111]]></Content>";
            }

            respStrstart += "</xml>";
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(respStrstart);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

