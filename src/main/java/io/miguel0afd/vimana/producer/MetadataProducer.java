package io.miguel0afd.vimana.producer;

import java.util.Properties;

import io.miguel0afd.vimana.common.Message;
import io.miguel0afd.vimana.common.Name;

public class MetadataProducer<MetadataName extends Name, Metadata extends Message> extends MessageProducer {

    public MetadataProducer(Properties properties, String topic) {
        super(properties, topic);
    }
}
