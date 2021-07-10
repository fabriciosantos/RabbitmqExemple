package com.fabricio.rabbitmq.controller;

import com.fabricio.rabbitmq.Util.Rabbitmq;
import com.fabricio.rabbitmq.dto.UserDto;
import com.fabricio.rabbitmq.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RabbitService rabbitService;

    @GetMapping("/1")
    public ResponseEntity queue1(@RequestBody UserDto userDto){
        this.rabbitService.enviaMensage(Rabbitmq.QUEUE1, userDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/2")
    public ResponseEntity queue2(@RequestBody UserDto userDto){
        this.rabbitService.enviaMensage(Rabbitmq.QUEUE2, userDto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
