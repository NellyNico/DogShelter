package crud.dogShelter.service.impl;

import crud.dogShelter.DTO.DogCreateDTO;
import crud.dogShelter.DTO.DogDisplayDTO;
import crud.dogShelter.DTO.DogUpdateDTO;
import crud.dogShelter.converter.DogConverter;
import crud.dogShelter.exceptions.CustomerNotFoundException;
import crud.dogShelter.exceptions.DogNotFoundException;
import crud.dogShelter.model.Dog;
import crud.dogShelter.repository.DogRepository;
import crud.dogShelter.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Override
    public DogDisplayDTO createDog(DogCreateDTO dogCreateDTO) {

        Dog dog = DogConverter.createDTOToEntity(dogCreateDTO);
        Dog createdDog = dogRepository.save(dog);

        return DogConverter.entityToDisplayDTO(createdDog);
    }

    @Override
    public List<DogDisplayDTO> findAllDogs() {

        List<DogDisplayDTO> dogDisplayDTOS = new ArrayList<>();
        dogRepository.findAll().forEach(entity -> dogDisplayDTOS.add(DogConverter.entityToDisplayDTO(entity)));

        return dogDisplayDTOS;
    }

    @Override
    public DogDisplayDTO findDogByID(Long ID) {

        Dog dog = dogRepository.findById(ID)
                .orElseThrow(() -> new DogNotFoundException("Dog with ID" + ID + " not found! :("));

        return DogConverter.entityToDisplayDTO(dog);
    }

    @Override
    public DogDisplayDTO updateDog(DogUpdateDTO dogUpdateDTO, Long ID) {

        Dog dog = dogRepository.findById(ID)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID" + ID + " not found!"));
        dog.setName(dogUpdateDTO.getName());
        dog.setAge(dogUpdateDTO.getAge());
        dog.setGender(dogUpdateDTO.getGender());
        dog.setBreed(dogUpdateDTO.getBreed());
        dog.setColor(dogUpdateDTO.getColor());

        Dog updatedDog = dogRepository.save(dog);

        return DogConverter.entityToDisplayDTO(updatedDog);
    }

    @Override
    public void deleteDogByID(Long ID) {

        dogRepository.findById(ID)
                .orElseThrow(() -> new DogNotFoundException("Dog with ID" + ID + " not found!"));

        dogRepository.deleteById(ID);
    }
}
