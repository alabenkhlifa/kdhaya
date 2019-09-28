package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.kdhaya.website.entities.SteedPosition;

@Repository
public interface SteedPositionRepository extends CrudRepository<SteedPosition, Long> {
    SteedPosition findFirstByIdNotNull();
}
