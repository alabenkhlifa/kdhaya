package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.kdhaya.website.entities.BaseUser;

@Repository
public interface BaseUserRepository extends CrudRepository<BaseUser, Long> {
}
