package com.proyectosgrt.demo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "SGRT",
        version = "1.0",
        description = "Sistema de Gestión de Requerimientos Técnicos"

    )
)
public class SwaggerConfig {

}
