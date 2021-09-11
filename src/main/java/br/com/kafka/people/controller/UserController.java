package br.com.kafka.people.controller;

import br.com.kafka.people.event.producer.UserProducer;
import br.com.kafka.people.controller.mapper.UserMapper;
import br.com.kafka.people.controller.request.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("kafka")
@Validated
public class UserController {

    private final UserProducer userProducer;

    @Autowired
    public UserController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping("/user")
    public String send(@Valid @RequestBody final UserRequest userRequest){
        this.userProducer.send(UserMapper.INSTANCE.map(userRequest));
        return "Sent with success";
    }
}
