package com.turismo.backendturismotec.turismo.resources.client;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientResource {
    private String firstName;

    private String address;

    private String lastName;

    private int phone;

    private String email;

    private String username;

    private String password;
}
