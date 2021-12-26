package com.example.curriculumdesign.entity;

import java.io.Serializable;

public class MessageEntity implements Serializable {
    private Long messageId;

    /**
     * 是否是全局消息 1为全局 0为课内消息
     */
    private Long messageType;

    /**
     * 接受人 *为全局 或者为课id 现在只有两种消息一个是全局另一个是课内消息
     */
    private Long messageReceive;

    /**
     * 标题
     */
    private String messageTitle;

    /**
     * 内容
     */
    private String messageContent;

    public MessageEntity(String messageTitle, String messageContent) {
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getMessageType() {
        return messageType;
    }

    public void setMessageType(Long messageType) {
        this.messageType = messageType;
    }

    public Long getMessageReceive() {
        return messageReceive;
    }

    public void setMessageReceive(Long messageReceive) {
        this.messageReceive = messageReceive;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
