package kk.base.core.service;

import kk.base.core.dto.ItemDto;
import kk.base.core.entity.Item;
import kk.base.core.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends GenericService<Item, ItemDto>{

    protected ItemService(GenericRepository<Item> genericRepository) {
        super(genericRepository, ItemDto.class);
    }
}
