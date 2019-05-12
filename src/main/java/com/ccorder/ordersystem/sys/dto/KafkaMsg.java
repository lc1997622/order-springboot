package com.ccorder.ordersystem.sys.dto;

/**
 * Created by zqb on 2018/4/12.
 */
public class KafkaMsg {


    private long offset;

    private int partition;

    private long timestamp;

    private String value;

    private String topic;

    public long getOffset() {
        return offset;
    }

    public KafkaMsg setOffset(long offset) {
        this.offset = offset;
        return this;
    }

    public int getPartition() {
        return partition;
    }

    public KafkaMsg setPartition(int partition) {
        this.partition = partition;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public KafkaMsg setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getValue() {
        return value;
    }

    public KafkaMsg setValue(String value) {
        this.value = value;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "{" +
                "offset:" + offset +
                ", partition:" + partition +
                ", timestamp:" + timestamp +
                ", value:'" + value + '\'' +
                ", topic:'" + topic + '\'' +
                '}';
    }
}
