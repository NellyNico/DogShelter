package crud.dogShelter.DTO;

import crud.dogShelter.model.Adoption;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DogDisplayDTO {

    private Long ID;
    private String name;
    private int age;
    private String gender;
    private String breed;
    private String color;
    private List<Adoption> adoptionsDTO;

    public DogDisplayDTO(String name, int age, String gender, String breed, String color, List<Adoption> adoptionsDTO) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.adoptionsDTO = adoptionsDTO;
    }
}
