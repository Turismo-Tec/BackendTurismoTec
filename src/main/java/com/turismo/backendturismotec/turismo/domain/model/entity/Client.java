package com.turismo.backendturismotec.turismo.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "clients")
public class Client {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    private String phone;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;
  
}
