package com.manager.pojo.wechat;

import lombok.Data;

/**
 * 类描述：
 *
 * @author weiqiang
 * @Since 2019/05/07 11:59
 */
@Data
public class WeixinJSSDKConfigVO {
    private String appId;
    private String timestamp;
    private String nonceStr;
    private String signature;
}
