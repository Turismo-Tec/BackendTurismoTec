package com.turismo.backendturismotec.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhanceModelMapperConfiguration")
public class MappingConfiguration {
  @Bean
    public EnhanceModelMapper modelMapper() {
        return new EnhanceModelMapper();
    }
}
