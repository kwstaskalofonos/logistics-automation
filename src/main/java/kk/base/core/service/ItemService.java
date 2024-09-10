package kk.base.core.service;

import kk.base.core.dto.ItemDto;
import kk.base.core.entity.Item;
import kk.base.core.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends GenericService<Item, ItemDto, Long>{

    private final ItemRepository itemRepository;
    protected ItemService(ItemRepository itemRepository) {
        super(itemRepository, ItemDto.class, Item.class);
        this.itemRepository = itemRepository;
    }
}
