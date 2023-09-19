package crud.dogShelter.DTO;

import crud.dogShelter.model.Customer;
import crud.dogShelter.model.Dog;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionCreateDTO implements Serializable {

    @NotNull(message = "The adoption quantity is mandatory!")
    private int quantity;

    @NotBlank(message = "The adoption status is mandatory!")
    private String status;

    @NotNull(message = "The adoption date is mandatory!")
    private LocalDateTime date;

    private Dog dog;

    private Customer customer;
}
