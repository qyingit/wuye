package com.haiyu.manager.pojo.wechat;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 类描述：code2session信息
 *
 * @author qying
 * @since 2019/11/19 14:37
 */

@Data
public class WeixinMinProgramSessionVO {

    @JSONField(name="openid")
    private String openId;
    @JSONField(name="session_key")
    private String sessionKey;
    @JSONField(name="unionid")
    private String unionId;
    private Integer errcode;
    private String errmsg;
}
