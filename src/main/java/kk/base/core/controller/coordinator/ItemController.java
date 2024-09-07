package kk.base.core.controller.coordinator;

import jakarta.transaction.Transactional;
import kk.base.core.dto.ItemDto;
import kk.base.core.entity.WebUser;
import kk.base.core.paging.FiltersDto;
import kk.base.core.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/api/items")
@Transactional
public class ItemController {

    private final ItemService itemService;
    Logger logger = LoggerFactory.getLogger(ItemController.class);

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "/dynamic")
    public ResponseEntity<Page<?>> searchByFilters(@AuthenticationPrincipal WebUser user, @RequestBody FiltersDto filters) {
        return ResponseEntity.ok(itemService.dynamic(filters, true));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@AuthenticationPrincipal WebUser user, @RequestBody ItemDto dto) throws NoSuchFieldException, IllegalAccessException {
        return ResponseEntity.ok(itemService.create(dto));
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getOne(@AuthenticationPrincipal WebUser user, @PathVariable Long id) throws AccessDeniedException {
        return ResponseEntity.ok(itemService.getOne(id));
    }
}
