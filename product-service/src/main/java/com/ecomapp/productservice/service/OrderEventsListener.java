package com.ecomapp.productservice.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderEventsListener {
    @KafkaListener(topics = "order-events", groupId = "product-service-group")
    public void readOrderEvents(ConsumerRecord<String, String> record){
        log.info("Message received : {}",record.value());
    }

}
