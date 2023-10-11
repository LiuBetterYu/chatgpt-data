package com.lby.chatgpt.data.domain.openai.service.rule;

import com.lby.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import com.lby.chatgpt.data.domain.openai.model.entity.RuleLogicEntity;

/**
 * 规则过滤接口
 * @author lby
 */
public interface ILogicFilter {

    RuleLogicEntity<ChatProcessAggregate> filter(ChatProcessAggregate chatAggregate) throws Exception;
}
