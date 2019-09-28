package tn.kdhaya.website.services;

import tn.kdhaya.website.entities.Provider;
import tn.kdhaya.website.entities.Shore;
import tn.kdhaya.website.enums.ShoreStatus;
import tn.kdhaya.website.exceptions.ProviderNotFoundException;
import tn.kdhaya.website.exceptions.ShoreNotFoundException;
import tn.kdhaya.website.exceptions.SteedNotFoundException;

import java.util.Date;
import java.util.List;

public interface IShoreService {

    Shore save(Shore shore);

    List<Shore> saveAll(List<Shore> shoreList);

    Shore findById(Long id) throws ShoreNotFoundException;

    boolean existsById(Long id);

    List<Shore> findAll();

    List<Shore> findAllByStatus(ShoreStatus shoreStatus);

    long count();

    void deleteById(Long id);

    void delete(Shore shore);

    void deleteAll(List<Shore> shoreList);

    void deleteAll();

    void cancel(Long id) throws ShoreNotFoundException;

    void takeCharge(Long shoreId, Long steedId) throws ShoreNotFoundException, SteedNotFoundException;

    List<Shore> findByCreationDateBetween(Date startDate, Date endDate);
}
