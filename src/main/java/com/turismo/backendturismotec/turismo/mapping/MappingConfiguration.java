package com.turismo.backendturismotec.turismo.mapping;

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
    public PackageMapper packageMapper() { return new PackageMapper(); }
}
