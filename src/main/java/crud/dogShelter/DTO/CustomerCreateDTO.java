package crud.dogShelter.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateDTO implements Serializable {

    @NotBlank(message = "Customer name is mandatory!")
    private String name;

    @NotBlank(message = "CNP is mandatory!")
    private String CNP;

    @NotBlank(message = "Address is mandatory!")
    private String address;

    @NotBlank(message = "Phone number is mandatory!")
    private String phoneNumber;

    @NotBlank(message = "Email is mandatory!")
    @Email(message = "Invalid email!")
    private String email;
}
