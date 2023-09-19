package crud.dogShelter.service;

import crud.dogShelter.DTO.*;

import java.util.List;

public interface AdoptionService {

    AdoptionDisplayDTO createAdoption(AdoptionCreateDTO adoption);
    List<AdoptionDisplayDTO> findAllAdoptions();
    AdoptionDisplayDTO findAdoptionByID(Long ID);
    AdoptionDisplayDTO updateAdoption(AdoptionUpdateDTO adoptionUpdateDTO, Long ID);
    void deleteAdoptionByID(Long ID);
}
