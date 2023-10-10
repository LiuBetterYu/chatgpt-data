package com.lby.chatgpt.data.domain.weixin.service;

/**
 * 验签接口
 * @author lby
 */
public interface IWeiXinValidateService {

    boolean checkSign(String signature, String timestamp, String nonce);
}
