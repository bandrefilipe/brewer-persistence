package bandrefilipe.brewer.persistence.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;

@Profile("default | dev")
@Configuration
class SwaggerDefaultRequestHandlerPredicate {

    @Bean
    Predicate<RequestHandler> requestHandlerPredicate() {
        return RequestHandlerSelectors.any();
    }
}
