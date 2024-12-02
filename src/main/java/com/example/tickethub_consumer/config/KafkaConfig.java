package com.example.tickethub_consumer.config;

import lombok.Getter;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@Getter
public class KafkaConfig {

    //Kafka 클러스터의 주소
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    // 컨슈머가 listen 할 토픽 이름
    @Value("${kafka.createTicketMessageTopic}")
    private String createTicketMessageTopic;

    //Kafka 컨슈머 그룹 ID
    @Value("${kafka.createTicketMessageGroup}")
    private String createTicketMessageGroup;


    //    Kafka 리스너 컨테이너 팩토리를 설정하는 빈입니다. 이 팩토리를 통해 리스너가 Kafka 메시지를 수신할 때의 설정을 정의합니다.
//    ConcurrentKafkaListenerContainerFactory<Integer, String> 객체를 생성하며, 여러 스레드를 통해 메시지를 동시에 처리하도록 setConcurrency(3)로 설정되어 있습니다.
//    setPollTimeout(3000): 리스너가 Kafka로부터 메시지를 가져올 때 대기하는 최대 시간을 3초로 설정합니다.
//    setAckMode(ContainerProperties.AckMode.MANUAL): 수동 커밋 모드를 설정합니다. 이를 통해 리스너가 메시지를 직접 커밋할 수 있습니다.
    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL); // 수동 커밋 설정

        return factory;
    }

    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, createTicketMessageGroup);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "5");
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, "15000");
        props.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, "1");
        props.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, "1000");
        return props;
    }

}
