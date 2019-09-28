package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.kdhaya.website.entities.Dispatcher;

@Repository
public interface DipatcherRepository extends CrudRepository<Dispatcher, Long> {
}
