package com.fabricio.rabbitmq.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    public String name;
    public String email;

}
