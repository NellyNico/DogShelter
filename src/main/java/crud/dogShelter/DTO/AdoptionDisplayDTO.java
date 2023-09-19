package crud.dogShelter.DTO;

import crud.dogShelter.model.Customer;
import crud.dogShelter.model.Dog;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdoptionDisplayDTO {

    private Long ID;
    private int quantity;
    private String status;
    private LocalDateTime date;
    private Dog dogDTO;
    private Customer customerDTO;

    public AdoptionDisplayDTO(int quantity, String status, LocalDateTime date, Dog dogDTO, Customer customerDTO) {
        this.quantity = quantity;
        this.status = status;
        this.date = date;
        this.dogDTO = dogDTO;
        this.customerDTO = customerDTO;
    }
}
