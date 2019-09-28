package tn.kdhaya.website.services;

import tn.kdhaya.website.entities.Shore;
import tn.kdhaya.website.entities.Steed;
import tn.kdhaya.website.exceptions.SteedNotFoundException;

import java.util.List;

public interface ISteedService {

    Steed save(Steed steed);

    Steed findById(Long id) throws SteedNotFoundException;

    List<Steed> findAll();

    void deleteById(Long id);

}
