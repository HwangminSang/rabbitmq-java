package com.example.rabbitmq.messagedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {



    private String roundKey;

    private String name;

    private String birthDate;
}

