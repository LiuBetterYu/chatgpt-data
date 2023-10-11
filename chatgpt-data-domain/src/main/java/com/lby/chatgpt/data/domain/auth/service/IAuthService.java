package com.lby.chatgpt.data.domain.auth.service;

import com.lby.chatgpt.data.domain.auth.model.entity.AuthStateEntity;

/**
 * 鉴权验证服务接口
 * @author lby
 */
public interface IAuthService {
    /**
     * 登录验证
     * @param code 验证码
     * @return
     */
    AuthStateEntity doLogin(String code);

    boolean checkToken(String token);

    String openid(String token);
}
