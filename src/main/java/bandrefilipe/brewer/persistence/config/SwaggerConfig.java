package bandrefilipe.brewer.persistence.config;

import bandrefilipe.brewer.persistence.controller.ControllerPackageMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configures Swagger 2 documentation.
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {

    private final SwaggerApiInfoProperties properties;

    @Autowired
    SwaggerConfig(final SwaggerApiInfoProperties properties) {
        super();
        this.properties = properties;
    }

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(ControllerPackageMarker.class.getPackageName()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .version(properties.getVersion())
                .description(properties.getDescription())
                .contact(this.contact())
                .license(properties.getLicense())
                .licenseUrl(properties.getLicenseUrl())
                .build();
    }

    private Contact contact() {
        return new Contact(
                properties.getContactName(),
                properties.getContactUrl(),
                properties.getContactEmail());
    }
}
