package com.example.rabbitmq.controller;


import com.example.rabbitmq.messagedto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class SampleController {

    private static final String EXCAHGE_NAME = "x.api";

    private final RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/rabbit-mq/send-message")
    public String samplePublish() {
        try {
            MessageDto messageDto = new MessageDto();
            messageDto.setName("hwangminsang");
            messageDto.setRoundKey("111111");
            messageDto.setBirthDate("2022-01-01");
            String json = objectMapper.writeValueAsString(messageDto);
            rabbitTemplate.convertAndSend(EXCAHGE_NAME, "x.routing.#", json);
            return "Message seding!";

        }catch (JsonProcessingException e){
            e.printStackTrace();
        }finally {
            return "Message seding!";
        }
    }
}
