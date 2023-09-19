package crud.dogShelter.service;

import crud.dogShelter.DTO.*;

import java.util.List;

public interface DogService {

    DogDisplayDTO createDog(DogCreateDTO dog);
    List<DogDisplayDTO> findAllDogs();
    DogDisplayDTO findDogByID(Long ID);
    DogDisplayDTO updateDog(DogUpdateDTO dogUpdateDTO, Long ID);
    void deleteDogByID(Long ID);
}
