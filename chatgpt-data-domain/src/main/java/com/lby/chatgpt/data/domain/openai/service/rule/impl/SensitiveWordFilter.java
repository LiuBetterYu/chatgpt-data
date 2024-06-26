package com.lby.chatgpt.data.domain.openai.service.rule.impl;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.lby.chatgpt.data.domain.openai.annotation.LogicStrategy;
import com.lby.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import com.lby.chatgpt.data.domain.openai.model.entity.MessageEntity;
import com.lby.chatgpt.data.domain.openai.model.entity.RuleLogicEntity;
import com.lby.chatgpt.data.domain.openai.model.valobj.LogicCheckTypeVO;
import com.lby.chatgpt.data.domain.openai.service.rule.ILogicFilter;
import com.lby.chatgpt.data.domain.openai.service.rule.factory.DefaultLogicFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 敏感词过滤
 * @author lby
 */
@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicMode.SENSITIVE_WORD)
public class SensitiveWordFilter implements ILogicFilter {

    @Resource
    private SensitiveWordBs words;
    @Value("${app.config.white-list}")
    private String whiteListStr;

    @Override
    public RuleLogicEntity<ChatProcessAggregate> filter(ChatProcessAggregate chatProcess) throws Exception {
        // 白名单用户不做敏感词处理
        if (chatProcess.isWhiteList(whiteListStr)) {
            return RuleLogicEntity.<ChatProcessAggregate>builder()
                    .type(LogicCheckTypeVO.SUCCESS).data(chatProcess).build();
        }

        ChatProcessAggregate newChatProcessAggregate = new ChatProcessAggregate();
        newChatProcessAggregate.setOpenid(chatProcess.getOpenid());
        newChatProcessAggregate.setModel(chatProcess.getModel());

        List<MessageEntity> newMessages = chatProcess.getMessages().stream()
                .map(message -> {
                    String content = message.getContent();
                    String replace = words.replace(content);
                    return MessageEntity.builder()
                            .role(message.getRole())
                            .name(message.getName())
                            .content(replace)
                            .build();
                })
                .collect(Collectors.toList());

        newChatProcessAggregate.setMessages(newMessages);
        return RuleLogicEntity.<ChatProcessAggregate>builder()
                .type(LogicCheckTypeVO.SUCCESS)
                .data(newChatProcessAggregate)
                .build();
    }
}
