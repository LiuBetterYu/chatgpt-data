package com.lby.chatgpt.data.domain.weixin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户行为信息
 * @author lby
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBehaviorMessageEntity {

    private String openId;
    private String fromUserName;
    private String msgType;
    private String content;
    private String event;
    private Date createTime;

}
