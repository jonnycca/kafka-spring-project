package br.com.kafka.people.controller.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotEmpty
    public String nome;

    @NotEmpty
    public String sobreNome;
}
