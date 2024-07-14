package kk.base.core.controller.coordinator;

import jakarta.transaction.Transactional;
import kk.base.core.entity.WebUser;
import kk.base.core.paging.FiltersDto;
import kk.base.core.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@Transactional
public class ItemsController {

    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "/dynamic")
    public ResponseEntity<Page<?>> searchByFilters(@AuthenticationPrincipal WebUser user, @RequestBody FiltersDto filters) {
        return ResponseEntity.ok(itemService.dynamic(filters));
    }
}
