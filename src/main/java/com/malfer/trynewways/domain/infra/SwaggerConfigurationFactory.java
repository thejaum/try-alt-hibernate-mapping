package com.malfer.trynewways.domain.infra;

import com.google.common.collect.Lists;
import com.google.common.net.HttpHeaders;
import io.swagger.models.auth.In;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

public abstract class SwaggerConfigurationFactory {

    private SwaggerConfigurationFactory() {
        //
    }

    private static final String BASE_PACKAGE = "com.malfer.trynewways";
    private static final String REFERENCE = "JWT";

    /**
     * Cria uma configuração para o swagger a partir do package e setando false para defaultResponseMessages
     *
     * @param basePackage package base dos resources que o swagger deve ler
     * @return Docket
     * @deprecated
     */
    @Deprecated
    public static Docket createConfiguration(String basePackage) {
        return SwaggerConfigurationFactory.createConfiguration(basePackage, false);
    }

    /**
     * Cria uma configuração para o swagger a partir do package e setando o defaultResponseMessages
     * como passado no parametro
     *
     * @param basePackage package base dos resources que o swagger deve ler
     * @param defaultResponseMessages seta as mensagens default do swagger ou deixa a opção ao desenvolvedor
     * @return Docket
     * @deprecated
     */
    @Deprecated
    public static Docket createConfiguration(String basePackage, boolean defaultResponseMessages) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(defaultResponseMessages);
    }

    /**
     * Cria uma configuração padrão para o Swagger, protegendo todos os endpoints
     *
     * @return Docket
     */
    public static Docket createConfigurationDefault() {

        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private static List<SecurityReference> securityReference() {

        return Collections.singletonList(SecurityReference.builder()
                .reference(REFERENCE)
                .scopes(new AuthorizationScope[0])
                .build());
    }

    private static ApiKey apiKey() {

        return new ApiKey(REFERENCE, HttpHeaders.AUTHORIZATION, In.HEADER.toValue());
    }

    private static SecurityContext securityContext() {

        return SecurityContext.builder()
                .securityReferences(securityReference())
                .forPaths(PathSelectors.any())
                .build();
    }
}
