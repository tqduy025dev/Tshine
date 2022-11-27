package com.tshine.server.apiserver.entities.conversation;

import com.tshine.server.apiserver.entities.key.UserConversationKey;
import com.tshine.server.apiserver.entities.user.UserInfo;

import javax.persistence.*;

@Entity
public class UserConversation {
    @EmbeddedId
    private UserConversationKey key;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("conversationId")
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;


    public UserConversationKey getKey() {
        return key;
    }

    public void setKey(UserConversationKey key) {
        this.key = key;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
