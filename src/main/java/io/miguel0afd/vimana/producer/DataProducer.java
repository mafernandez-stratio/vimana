package io.miguel0afd.vimana.producer;

import java.util.Properties;

import io.miguel0afd.vimana.common.Message;
import io.miguel0afd.vimana.common.Name;

public class DataProducer<DataName extends Name, Data extends Message> extends MessageProducer {

    public DataProducer(Properties properties, String topic) {
        super(properties, topic);
    }
}
