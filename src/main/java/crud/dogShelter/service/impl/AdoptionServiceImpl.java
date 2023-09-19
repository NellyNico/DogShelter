package crud.dogShelter.service.impl;

import crud.dogShelter.DTO.AdoptionCreateDTO;
import crud.dogShelter.DTO.AdoptionDisplayDTO;
import crud.dogShelter.DTO.AdoptionUpdateDTO;
import crud.dogShelter.converter.AdoptionConverter;
import crud.dogShelter.exceptions.AdoptionNotFoundException;
import crud.dogShelter.model.Adoption;
import crud.dogShelter.repository.AdoptionRepository;
import crud.dogShelter.service.AdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {

    private final AdoptionRepository adoptionRepository;

    @Override
    public AdoptionDisplayDTO createAdoption(AdoptionCreateDTO adoptionCreateDTO) {

        Adoption adoption = AdoptionConverter.createDTOToEntity(adoptionCreateDTO);
        Adoption createdAdoption = adoptionRepository.save(adoption);

        return AdoptionConverter.entityToDisplayDTO(createdAdoption);
    }

    @Override
    public List<AdoptionDisplayDTO> findAllAdoptions() {

        List<AdoptionDisplayDTO> adoptionDisplayDTO = new ArrayList<>();
        adoptionRepository.findAll().forEach(entity -> adoptionDisplayDTO.add(AdoptionConverter.entityToDisplayDTO(entity)));

        return adoptionDisplayDTO;
    }

    @Override
    public AdoptionDisplayDTO findAdoptionByID(Long ID) {

        Adoption adoption = adoptionRepository.findById(ID)
                .orElseThrow(() -> new AdoptionNotFoundException("Adoption with ID" + ID + " not found! :("));

        return AdoptionConverter.entityToDisplayDTO(adoption);
    }

    @Override
    public AdoptionDisplayDTO updateAdoption(AdoptionUpdateDTO adoptionUpdateDTO, Long ID) {

        Adoption adoption = adoptionRepository.findById(ID)
                .orElseThrow(() -> new AdoptionNotFoundException("Adoption with ID" + ID + " not found! :("));
        adoption.setQuantity(adoptionUpdateDTO.getQuantity());
        adoption.setStatus(adoptionUpdateDTO.getStatus());

        Adoption updatedAdoption = adoptionRepository.save(adoption);

        return AdoptionConverter.entityToDisplayDTO(updatedAdoption);
    }

    @Override
    public void deleteAdoptionByID(Long ID) {

        adoptionRepository.findById(ID)
                .orElseThrow(() -> new AdoptionNotFoundException("Adoption with ID" + ID + " not found! :("));

        adoptionRepository.deleteById(ID);
    }
}
