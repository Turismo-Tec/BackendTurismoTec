package com.turismo.backendturismotec.turismo.resources.client;

import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ClientResource {
    private Long id;
    private String firstName;
    private String lastName;
    private int phone;
    private String email;
    private String address;
    private String username;
    private String password;
}
