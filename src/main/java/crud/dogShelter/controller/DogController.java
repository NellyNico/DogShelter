package crud.dogShelter.controller;

import crud.dogShelter.DTO.*;
import crud.dogShelter.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dogs")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;

    @PostMapping("/createDog")
    public ResponseEntity<DogDisplayDTO> createDog(@Valid @RequestBody DogCreateDTO dogCreateDTO) {
        DogDisplayDTO dogDisplayDTO = dogService.createDog(dogCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Doggo created successfully! :)")
                .build();
    }

    @GetMapping("/findAllDogs")
    public ResponseEntity<List<DogDisplayDTO>> findAllDogs() {

        return ResponseEntity.ok(dogService.findAllDogs());
    }

    @GetMapping("/findByID/{dogID}")
    public ResponseEntity<DogDisplayDTO> findDogByID(@PathVariable("dogID") Long dogID) {
        DogDisplayDTO dogDisplayDTO = dogService.findDogByID(dogID);

        return ResponseEntity.ok(dogDisplayDTO);

    }

    @PutMapping("/update/{dogID}")
    public ResponseEntity<DogDisplayDTO> updateDog(@PathVariable("dogID") Long dogID,
                                                             @Valid @RequestBody DogUpdateDTO dogUpdateDTO) {
        DogDisplayDTO dogDisplayDTO = dogService.updateDog(dogUpdateDTO, dogID);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Doggo updated successfully! :)")
                .build();
    }

    @DeleteMapping("/delete/{dogID}")
    public ResponseEntity<Void> deleteCustomerByID(@PathVariable("dogID") Long dogID) {
        dogService.deleteDogByID(dogID);

        return ResponseEntity.noContent()
                .header("Message", "Doggo deleted successfully! :)")
                .build();
    }
}
