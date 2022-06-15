package com.turismo.backendturismotec.turismo.resources.company;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyResource {
    private String Name;

    private String email;

    private String description;
}
