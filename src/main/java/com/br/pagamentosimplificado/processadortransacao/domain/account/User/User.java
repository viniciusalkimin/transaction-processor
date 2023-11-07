package com.br.pagamentosimplificado.processadortransacao.domain.account.User;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String completeName;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String document;

    private String email;

    @Setter
    private String password;

}
