package dev.rynwllngtn.agorasocial.infrastructure.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "REST APIs do microsserviço AgoraSocial",
                description = "Documentação detalhada de todos os endpoints do sistema Social do ecossistema Agora"
        )
)
public class OpenAPIConfiguration {
}