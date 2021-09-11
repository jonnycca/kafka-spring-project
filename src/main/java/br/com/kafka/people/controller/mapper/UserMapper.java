package br.com.kafka.people.controller.mapper;

import br.com.kafka.people.controller.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import br.com.kafka.people.event.UserAvro;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "nome", target = "name")
    @Mapping(source = "sobreNome", target = "lastName")
    UserAvro map(UserRequest source);
}
