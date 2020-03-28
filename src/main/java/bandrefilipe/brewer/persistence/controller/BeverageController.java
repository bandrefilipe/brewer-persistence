package bandrefilipe.brewer.persistence.controller;

import bandrefilipe.brewer.persistence.model.Beverage;
import bandrefilipe.brewer.persistence.service.BeverageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        super();
        this.beverageService = beverageService;
    }

    @GetMapping(path = "/beverage")
    public ResponseEntity<Beverage> getBeverageBySku(@RequestParam(name = "sku") final String sku) {
        final var beverage = beverageService.findBySku(sku);
        return ResponseEntity.noContent().build();
    }
}
