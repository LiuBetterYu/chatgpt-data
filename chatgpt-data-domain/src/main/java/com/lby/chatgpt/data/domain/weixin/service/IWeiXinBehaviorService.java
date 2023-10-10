package com.lby.chatgpt.data.domain.weixin.service;

import com.lby.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;

/**
 * 受理用户行为接口
 * @author lby
 */
public interface IWeiXinBehaviorService {
    String acceptUserBehavior(UserBehaviorMessageEntity userBehaviorMessageEntity);
}
