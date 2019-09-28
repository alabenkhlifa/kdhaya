package tn.kdhaya.website.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.kdhaya.website.entities.Shore;
import tn.kdhaya.website.enums.ShoreStatus;

import java.util.Date;
import java.util.List;

@Repository
public interface ShoreRepository extends CrudRepository<Shore, Long> {

    List<Shore> findByStatusEquals(ShoreStatus shoreStatus);

    List<Shore> findAllByCreationDateIsBetween(Date startDate, Date endDate);

}
