package bandrefilipe.brewer.persistence.controller;

import bandrefilipe.brewer.persistence.model.BeverageType;
import bandrefilipe.brewer.persistence.service.BeverageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = API.BEVERAGES_TYPES,
        produces = MediaType.APPLICATION_JSON_VALUE)
class BeverageTypeController {

    private final BeverageTypeService beverageTypeService;

    @Autowired
    BeverageTypeController(final BeverageTypeService beverageTypeService) {
        super();
        this.beverageTypeService = beverageTypeService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<BeverageType>> getAllBeverageTypes() {
        return ResponseEntity.ok(beverageTypeService.listAll());
    }
}
