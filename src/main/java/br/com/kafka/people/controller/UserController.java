package br.com.kafka.people.controller;

import br.com.kafka.people.controller.mapper.UserMapper;
import br.com.kafka.people.controller.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("kafka")
@Validated
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/user")
    public String send(@Valid @RequestBody final UserRequest userRequest){
        return UserMapper.INSTANCE.map(userRequest).toString();
    }
}
