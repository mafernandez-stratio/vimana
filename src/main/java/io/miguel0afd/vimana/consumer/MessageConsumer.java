package io.miguel0afd.vimana.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public abstract class MessageConsumer {

    private final ConsumerConnector consumer;
    private final String topic;

    public MessageConsumer(Properties properties, String topic) {
        ConsumerConfig consumerConfig = new ConsumerConfig(properties);
        this.consumer = Consumer.createJavaConsumerConnector(consumerConfig);
        this.topic = topic;
    }

    public void consume(Handler handler){
        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap =
                consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
        handler.consume(streams);
    }

    public void shutdown(){
        consumer.shutdown();
    }

}
