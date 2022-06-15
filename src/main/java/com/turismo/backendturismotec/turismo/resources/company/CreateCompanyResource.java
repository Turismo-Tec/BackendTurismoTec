package com.turismo.backendturismotec.turismo.resources.company;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyResource {
    private String Name;

    private String email;

    private String description;
}
