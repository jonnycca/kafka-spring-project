package br.com.kafka.people.controller.request;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    public String nome;

    public String sobreNome;
}
