package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.kdhaya.website.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
