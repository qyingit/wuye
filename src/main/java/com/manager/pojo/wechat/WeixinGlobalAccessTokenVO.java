package com.manager.pojo.wechat;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 类描述：
 *
 * @author weiqiang
 * @Since 2019/05/07 10:28
 */
@Data
public class WeixinGlobalAccessTokenVO {
    @JSONField(name="access_token")
    private String accessToken;
    @JSONField(name="expires_in")
    private Integer expiresIn;
 }
