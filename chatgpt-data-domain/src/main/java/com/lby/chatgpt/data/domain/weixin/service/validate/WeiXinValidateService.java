package com.lby.chatgpt.data.domain.weixin.service.validate;

import com.lby.chatgpt.data.domain.weixin.service.IWeiXinValidateService;
import com.lby.chatgpt.data.types.sdk.weixin.SignatureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author lby
 */
@Service
public class WeiXinValidateService implements IWeiXinValidateService {
    @Value("${wx.config.token}")
    private String token;

    @Override
    public boolean checkSign(String signature, String timestamp, String nonce) {
        return SignatureUtil.check(token, signature, timestamp, nonce);
    }
}
