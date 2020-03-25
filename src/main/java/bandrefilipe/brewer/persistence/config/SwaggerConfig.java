package bandrefilipe.brewer.persistence.config;

import bandrefilipe.brewer.persistence.controller.ControllerPackageMarker;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${swagger.api.info.title}")
    private String title;

    @Value("${swagger.api.info.version}")
    private String version;

    @Value("${swagger.api.info.description:}")
    private String description;

    @Value("${swagger.api.info.contact.name:}")
    private String contactName;

    @Value("${swagger.api.info.contact.url:}")
    private String contactUrl;

    @Value("${swagger.api.info.contact.email:}")
    private String contactEmail;

    @Value("${swagger.api.info.license:}")
    private String license;

    @Value("${swagger.api.info.license-url:}")
    private String licenseUrl;

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
                .title(title)
                .version(version)
                .description(description)
                .contact(this.contact())
                .license(license)
                .licenseUrl(licenseUrl)
                .build();
    }

    private Contact contact() {
        return new Contact(contactName, contactUrl, contactEmail);
    }
}
