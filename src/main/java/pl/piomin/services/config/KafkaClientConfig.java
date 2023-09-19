package pl.piomin.services.config;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@io.micronaut.configuration.kafka.annotation.KafkaClient
public interface KafkaClientConfig {
    void sendHeartBeat(@Topic String topic, @KafkaKey String day, String message);
}
