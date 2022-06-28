package com.turismo.backendturismotec.turismo.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "packages")
public class Packages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    private float price;

    @NotNull
    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    @JsonIgnore
    private Companies companyId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    @JsonIgnore
    private Client clientId;

}
