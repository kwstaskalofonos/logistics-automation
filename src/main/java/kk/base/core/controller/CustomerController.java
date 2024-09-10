package kk.base.core.controller;

import jakarta.transaction.Transactional;
import kk.base.core.dto.CustomerDto;
import kk.base.core.entity.WebUser;
import kk.base.core.paging.FiltersDto;
import kk.base.core.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@Transactional
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@AuthenticationPrincipal WebUser user, @RequestBody CustomerDto dto) throws NoSuchFieldException, IllegalAccessException {
        return ResponseEntity.ok(customerService.create(dto, false));
    }

    @PostMapping(value = "/dynamic")
    public ResponseEntity<Page<?>> searchByFilters(@AuthenticationPrincipal WebUser user, @RequestBody FiltersDto filters) {
        return ResponseEntity.ok(customerService.dynamic(filters,false));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll(@AuthenticationPrincipal WebUser user) {
        return ResponseEntity.ok(customerService.getAll(false));
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getOne(@AuthenticationPrincipal WebUser user, @PathVariable Long id) {
        return ResponseEntity.ok(customerService.getOne(id, false));
    }
}
