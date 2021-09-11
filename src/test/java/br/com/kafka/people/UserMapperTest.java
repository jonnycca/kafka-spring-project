package br.com.kafka.people;

import br.com.kafka.people.controller.mapper.UserMapper;
import br.com.kafka.people.controller.request.UserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import br.com.kafka.people.event.UserAvro;

public class UserMapperTest {

    @Test
    void mapUserRequestToUserAvroTest(){
        UserRequest userRequest = new UserRequest();
        userRequest.nome = "ze";
        userRequest.sobreNome = "zee";

        UserAvro userAvro = UserMapper.INSTANCE.map(userRequest);

        Assertions.assertAll(
                () -> Assertions.assertEquals(userRequest.nome, userAvro.getName().toString(), "nome"),
                () -> Assertions.assertEquals(userRequest.sobreNome, userAvro.getLastName().toString(), "sobreNome")
        );
    }
}
