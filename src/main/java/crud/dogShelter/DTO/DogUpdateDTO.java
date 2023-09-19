package crud.dogShelter.DTO;

import crud.dogShelter.model.Adoption;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class DogUpdateDTO implements Serializable {

    @NotNull
    private Long ID;
    @NotBlank(message = "Dog name is mandatory!")
    private String name;

    @NotNull(message = "Dog age is mandatory!")
    private int age;

    @NotBlank(message = "Dog gender is mandatory!")
    private String gender;

    @NotBlank(message = "Dog breed is mandatory!")
    private String breed;

    @NotBlank(message = "Dog color is mandatory!")
    private String color;

    private List<Adoption> adoptions;

}
