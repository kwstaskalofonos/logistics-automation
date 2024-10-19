package kk.base.core.controller;

import jakarta.transaction.Transactional;
import kk.base.core.dto.ItemCustomerOrderDto;
import kk.base.core.entity.WebUser;
import kk.base.core.service.ItemCustomerOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item-order")
@Transactional
public class ItemCustomerOrderController {

    private final ItemCustomerOrderService itemCustomerOrderService;

    public ItemCustomerOrderController(ItemCustomerOrderService itemCustomerOrderService) {
        this.itemCustomerOrderService = itemCustomerOrderService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@AuthenticationPrincipal WebUser user, @RequestBody ItemCustomerOrderDto dto) throws NoSuchFieldException, IllegalAccessException {
        return ResponseEntity.ok(itemCustomerOrderService.create(dto, false));
    }
}
