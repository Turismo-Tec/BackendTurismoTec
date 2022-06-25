package com.turismo.backendturismotec.turismo.resources.packages;

import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PackageResource {
  private String description;

    private String country;

    private float price;

    //Relationships
    //Client
    //Companies
}
