package com.turismo.turismoapi.turismo.mapping;

import com.turismo.turismoapi.turismo.domain.model.entity.Client;
import com.turismo.turismoapi.turismo.domain.model.entity.Companies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("turismoMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ClientMapper clientMapper() {
        return new ClientMapper();
    }
    @Bean
    public CompanyMapper companyMapper() { return new CompanyMapper(); }
    @Bean
    public PackageMapper packageMapperMapper() { return new PackageMapper(); }
}
