package com.tshine.server.apiserver.entities.conversation;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Conversation {
    @Id
    private String conversationId;
    private String title;
    private Timestamp createdTime;
    private Timestamp lastUpdated;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conversation_id")
    private List<Message> messages;

    public String getConversationId() {
        return conversationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
