package io.miguel0afd.vimana.consumer;

import java.util.List;

import kafka.consumer.KafkaStream;

public interface Handler {

    public void consume(List<KafkaStream<byte[],byte[]>> streams);
}
