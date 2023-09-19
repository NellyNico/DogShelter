package crud.dogShelter.converter;

import crud.dogShelter.DTO.*;
import crud.dogShelter.model.Customer;
import crud.dogShelter.model.Dog;

public class DogConverter {

    public static Dog createDTOToEntity(DogCreateDTO dogCreateDTO) {

        Dog dog = new Dog();
        dog.setName(dogCreateDTO.getName());
        dog.setAge(dogCreateDTO.getAge());
        dog.setGender(dogCreateDTO.getGender());
        dog.setBreed(dogCreateDTO.getBreed());
        dog.setColor(dogCreateDTO.getColor());

        return dog;
    }

    public static DogDisplayDTO entityToDisplayDTO(Dog dog) {

        DogDisplayDTO dogDisplayDTO = new DogDisplayDTO();
        dogDisplayDTO.setID(dog.getID());
        dogDisplayDTO.setName(dog.getName());
        dogDisplayDTO.setAge(dog.getAge());
        dogDisplayDTO.setGender(dog.getGender());
        dogDisplayDTO.setBreed(dog.getBreed());
        dogDisplayDTO.setColor(dog.getColor());

        return dogDisplayDTO;
    }

    public static Dog updateDTOToEntity(DogUpdateDTO dogUpdateDTO) {

        Dog dog = new Dog();
        dog.setID(dogUpdateDTO.getID());
        dog.setName(dogUpdateDTO.getName());
        dog.setAge(dogUpdateDTO.getAge());
        dog.setGender(dogUpdateDTO.getGender());
        dog.setBreed(dogUpdateDTO.getBreed());
        dog.setColor(dogUpdateDTO.getColor());

        return dog;
    }
}
