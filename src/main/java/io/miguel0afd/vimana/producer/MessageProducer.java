package io.miguel0afd.vimana.producer;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public abstract class MessageProducer<Message> {

    private final Producer producer;
    private final String topic;

    public MessageProducer(Properties properties, String topic) {
        this.producer = new Producer<>(new ProducerConfig(properties));
        this.topic = topic;
    }

    public void send(Message message){
        producer.send(new KeyedMessage<>(topic, message));
    }

    public void close(){
        producer.close();
    }
}
