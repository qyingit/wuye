package com.haiyu.manager.pojo.wechat;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 类描述：
 *
 * @author weiqiang
 * @Since 2019/04/30 15:52
 */
@Data
public class WeixinPersonalAccessTokenVO {
    @JSONField(name="access_token")
    private String accessToken;
    @JSONField(name="expires_in")
    private Integer expiresIn;
    @JSONField(name="refresh_token")
    private String refreshToken;
    private String openid;
    private String scope;
}
