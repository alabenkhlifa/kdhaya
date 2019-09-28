package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.kdhaya.website.entities.Steed;

@Repository
public interface SteedRepository extends CrudRepository<Steed, Long> {
}
