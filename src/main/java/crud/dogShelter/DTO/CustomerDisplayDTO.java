package crud.dogShelter.DTO;

import crud.dogShelter.model.Adoption;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerDisplayDTO {

    private Long ID;
    private String name;
    private String CNP;
    private String address;
    private String phoneNumber;
    private String email;
    private List<Adoption> adoptionsDTO;

    public CustomerDisplayDTO(String name, String CNP, String address, String phoneNumber, String email, List<Adoption> adoptionsDTO) {
        this.name = name;
        this.CNP = CNP;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adoptionsDTO = adoptionsDTO;
    }
}
