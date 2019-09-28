package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.kdhaya.website.entities.ShoreItems;

@Repository
public interface ShoreItemsRepository extends CrudRepository<ShoreItems, Long> {
}
