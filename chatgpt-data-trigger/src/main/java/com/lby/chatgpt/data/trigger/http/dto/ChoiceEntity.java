package com.lby.chatgpt.data.trigger.http.dto;

import com.lby.chatgpt.data.domain.openai.model.entity.MessageEntity;
import lombok.Data;

/**
 * @author lby
 */
@Data
public class ChoiceEntity {

    /** stream = true 请求参数里返回的属性是 delta */
    private MessageEntity delta;
    /** stream = false 请求参数里返回的属性是 delta */
    private MessageEntity message;
}
