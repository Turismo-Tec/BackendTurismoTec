package com.turismo.backendturismotec.turismo.resources.company;

import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResource {
    private String Name;

    private String email;

    private String description;
}
