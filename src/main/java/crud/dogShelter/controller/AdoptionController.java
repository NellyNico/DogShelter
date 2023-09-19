package crud.dogShelter.controller;

import crud.dogShelter.DTO.*;
import crud.dogShelter.service.AdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/adoptions")
@RequiredArgsConstructor
public class AdoptionController {

    private final AdoptionService adoptionService;

    @PostMapping("/createAdoption")
    public ResponseEntity<AdoptionDisplayDTO> createAdoption(@Valid @RequestBody AdoptionCreateDTO adoptionCreateDTO) {
        AdoptionDisplayDTO adoptionDisplayDTO = adoptionService.createAdoption(adoptionCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message","Adoption created successfully! :)")
                .build();
    }

    @GetMapping("/findAllAdoptions")
    public ResponseEntity<List<AdoptionDisplayDTO>> findAllAdoptions(){

        return ResponseEntity.ok(adoptionService.findAllAdoptions());
    }

    @GetMapping("/{adoptionID}")
    public ResponseEntity<AdoptionDisplayDTO> findAdoptionByID(@PathVariable("adoptionID") Long adoptionID) {
        AdoptionDisplayDTO adoptionDisplayDTO = adoptionService.findAdoptionByID(adoptionID);

        return ResponseEntity.ok(adoptionDisplayDTO);
    }

    @PutMapping("/{adoptionID}")
    public ResponseEntity<AdoptionDisplayDTO> updateAdoption(@PathVariable("adoptionID") Long adoptionID,
                                                             @Valid @RequestBody AdoptionUpdateDTO adoptionUpdateDTO) {
        AdoptionDisplayDTO adoptionDisplayDTO = adoptionService.updateAdoption(adoptionUpdateDTO, adoptionID);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Adoption updated successfully! :)")
                .build();
    }

    @DeleteMapping("/{adoptionID}")
    public ResponseEntity<Void> deleteAdoptionByID(@PathVariable ("adoptionID") Long adoptionID) {
        adoptionService.deleteAdoptionByID(adoptionID);

        return ResponseEntity.noContent()
                .header("Message", "Adoption deleted successfully! :)")
                .build();
    }
}
