package kk.base.core.controller;

import jakarta.transaction.Transactional;
import kk.base.core.entity.WebUser;
import kk.base.core.paging.FiltersDto;
import kk.base.core.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@Transactional
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/dynamic")
    public ResponseEntity<Page<?>> searchByFilters(@AuthenticationPrincipal WebUser user, @RequestBody FiltersDto filters) {
        return ResponseEntity.ok(customerService.dynamic(filters,false));
    }
}
