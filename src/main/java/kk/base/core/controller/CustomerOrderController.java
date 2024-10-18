package kk.base.core.controller;

import jakarta.transaction.Transactional;
import kk.base.core.dto.CustomerOrderDto;
import kk.base.core.entity.WebUser;
import kk.base.core.service.CustomerOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Transactional
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @PostMapping(value = "/create-temp")
    public ResponseEntity<?> create(@AuthenticationPrincipal WebUser user, @RequestBody CustomerOrderDto dto) throws NoSuchFieldException, IllegalAccessException {
        return ResponseEntity.ok(customerOrderService.create(dto, false));
    }
    @GetMapping(value = "/get-current-order")
    public ResponseEntity<?> getCurrentOrder(@AuthenticationPrincipal WebUser user) {
        return ResponseEntity.ok(customerOrderService.getCurrentOrder(user));
    }
}
