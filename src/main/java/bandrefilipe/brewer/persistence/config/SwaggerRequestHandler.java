package bandrefilipe.brewer.persistence.config;

import bandrefilipe.brewer.persistence.controller.ControllerPackageMarker;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;


@Configuration
class SwaggerRequestHandler {

    @Bean
    @Profile("default | dev")
    Predicate<RequestHandler> defaultRequestHandler() {
        return RequestHandlerSelectors.any();
    }

    @Bean
    @Profile("prod")
    Predicate<RequestHandler> prodRequestHandler() {
        return RequestHandlerSelectors.basePackage(ControllerPackageMarker.class.getPackageName());
    }
}
