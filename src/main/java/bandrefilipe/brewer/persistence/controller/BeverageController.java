package bandrefilipe.brewer.persistence.controller;

import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationRequest;
import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationResponse;
import bandrefilipe.brewer.persistence.core.model.Beverage;
import bandrefilipe.brewer.persistence.service.BeverageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        path = API.BEVERAGES,
        produces = APPLICATION_JSON_VALUE)
@Api(tags = "Beverages")
class BeverageController {

    private final BeverageService beverageService;

    @Autowired
    BeverageController(final BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    @GetMapping("/beverage/{id}")
    public ResponseEntity<Beverage> getBeverageById(@PathVariable("id") final Long id) {
        return beverageService.findBeverageById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/beverage")
    public ResponseEntity<Beverage> getBeverageBySku(@RequestParam("sku") final String sku) {
        return beverageService.findBeverageBySku(sku)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping("/new")
    public ResponseEntity<BeverageRegistrationResponse> postNewBeverage(
            @Valid @RequestBody final BeverageRegistrationRequest requestBody) {

        final var responseBody = beverageService.registerNewBeverage(requestBody);
        return responseBody
                .map(BeverageRegistrationResponse::getId)
                .map(this::newBeverageURI)
                .map(ResponseEntity::created)
                .map(responseEntity -> responseEntity.body(responseBody
                        .orElseThrow(IllegalStateException::new)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    URI newBeverageURI(final Long id) {
        return URI.create(API.BEVERAGES + "/beverage/" + id);
    }
}
