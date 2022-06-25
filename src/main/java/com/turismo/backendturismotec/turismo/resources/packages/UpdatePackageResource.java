package com.turismo.backendturismotec.turismo.resources.packages;

import lombok.*;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePackageResource {
    private String description;

    private String country;

    private float price;
    //Relationships
    //Client
    //Companies
}
