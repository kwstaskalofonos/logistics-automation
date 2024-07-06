package kk.base.core.service;

import kk.base.core.entity.Item;
import kk.base.core.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends GenericService<Item>{

    protected ItemService(GenericRepository<Item> genericRepository) {
        super(genericRepository);
    }
}
