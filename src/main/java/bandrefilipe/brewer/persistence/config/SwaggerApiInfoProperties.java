package bandrefilipe.brewer.persistence.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Binds custom swagger's api info properties.
 */
@Data
@Configuration
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app.swagger.api.info")
class SwaggerApiInfoProperties {

    private String title;
    private String version;
    private String description;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String license;
    private String licenseUrl;
}
