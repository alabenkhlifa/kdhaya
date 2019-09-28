package tn.kdhaya.website.services;

import org.springframework.stereotype.Service;
import tn.kdhaya.website.entities.SteedPosition;

public interface ISteedPositionService {

    SteedPosition get();

    SteedPosition save(SteedPosition steedPosition);

    void deleteAll();
}
