package com.haiyu.manager.pojo.wechat;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 类描述：
 *
 * @author weiqiang
 * @Since 2019/05/07 12:50
 */
@Data
public class WeixinJsapiTicketVO {
    private Integer errcode;
    private String errmsg;
    private String ticket;
    @JSONField(name="expires_in")
    private String expiresIn;
}
