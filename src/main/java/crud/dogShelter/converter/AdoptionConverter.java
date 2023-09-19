package crud.dogShelter.converter;

import crud.dogShelter.DTO.*;
import crud.dogShelter.model.Adoption;

public class AdoptionConverter {

    public static Adoption createDTOToEntity(AdoptionCreateDTO adoptionCreateDTO) {

        Adoption adoption = new Adoption();
        adoption.setQuantity(adoptionCreateDTO.getQuantity());
        adoption.setStatus(adoptionCreateDTO.getStatus());
        adoption.setDate(adoptionCreateDTO.getDate());
//        adoption.setDog(adoptionCreateDTO.getDog());
//        adoption.setCustomer(adoptionCreateDTO.getCustomer());

        return adoption;
    }

    public static AdoptionDisplayDTO entityToDisplayDTO(Adoption adoption) {

        AdoptionDisplayDTO adoptionDisplayDTO = new AdoptionDisplayDTO();
        adoptionDisplayDTO.setID(adoption.getId());
        adoptionDisplayDTO.setQuantity(adoption.getQuantity());
        adoptionDisplayDTO.setDate(adoption.getDate());

        return adoptionDisplayDTO;
    }

    public static Adoption updateDTOToEntity(AdoptionUpdateDTO adoptionUpdateDTO) {

        Adoption adoption = new Adoption();
        adoption.setId(adoptionUpdateDTO.getID());
        adoption.setQuantity(adoptionUpdateDTO.getQuantity());
        adoption.setStatus(adoptionUpdateDTO.getStatus());
        adoption.setDate(adoptionUpdateDTO.getDate());
//        adoption.setDog(adoptionUpdateDTO.getDog());
//        adoption.setCustomer(adoptionUpdateDTO.getCustomer());

        return adoption;
    }
}
