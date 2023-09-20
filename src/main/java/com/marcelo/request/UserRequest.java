package com.marcelo.request;

import lombok.Data;

@Data
public class UserRequest {

    private Long id;
    private String nome;
    private String email;
    private String senha;
}
