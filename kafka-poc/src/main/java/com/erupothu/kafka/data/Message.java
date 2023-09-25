package com.erupothu.kafka.data;
import java.util.Objects;

public class Message {
    
    private String message;
    private String key;
    private String topicName;


    public Message() {
    }

    public Message(String message, String key, String topicName) {
        this.message = message;
        this.key = key;
        this.topicName = topicName;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Message message(String message) {
        setMessage(message);
        return this;
    }

    public Message key(String key) {
        setKey(key);
        return this;
    }

    public Message topicName(String topicName) {
        setTopicName(topicName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Message)) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(message, message.message) && Objects.equals(key, message.key) && Objects.equals(topicName, message.topicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, key, topicName);
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", key='" + getKey() + "'" +
            ", topicName='" + getTopicName() + "'" +
            "}";
    }


}
