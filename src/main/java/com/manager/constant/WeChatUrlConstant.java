package com.manager.constant;

/**
 * @类描述: 微信公众号路径常量配置类
 * @version: 1.0
 * @author guohuixiang
 * @since 2019/11/19
 */
public class WeChatUrlConstant {
    // 获取微信 accessToken url地址
    public static final String WEIXIN_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    public static final String CODE_2_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    // OAuth2.0 版获取
    public static final String OAUTH_2_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    public static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

    // 获取全局AccessToken
    public static final String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";

    // 获取微信临时二维码地址 https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
    public static String WEIXIN_TEMPORARY_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

    // 创建微信菜单
    public static String WECHAT_CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";

    // 获取accessToken
    public static String WECHAT_SHOW_QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
}
