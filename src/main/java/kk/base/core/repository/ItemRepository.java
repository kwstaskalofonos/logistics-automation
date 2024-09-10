package kk.base.core.repository;

import kk.base.core.entity.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends GenericRepository<Item, Long> {

}
