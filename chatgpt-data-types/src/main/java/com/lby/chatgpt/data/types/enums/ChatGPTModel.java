package com.lby.chatgpt.data.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lby
 */
@Getter
@AllArgsConstructor
public enum ChatGPTModel {

    /** gpt-3.5-turbo */
    GPT_3_5_TURBO("gpt-3.5-turbo"),

    ;
    private final String code;

}
