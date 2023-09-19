package crud.dogShelter.controller;

import crud.dogShelter.DTO.CustomerCreateDTO;
import crud.dogShelter.DTO.CustomerDisplayDTO;
import crud.dogShelter.DTO.CustomerUpdateDTO;
import crud.dogShelter.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerDisplayDTO> createCustomer(@Valid @RequestBody CustomerCreateDTO customerCreateDTO) {
        CustomerDisplayDTO customerDisplayDTO = customerService.createCustomer(customerCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message","Customer created successfully! :)" )
                .build();
    }

    @GetMapping("/findAllCustomers")
    public ResponseEntity<List<CustomerDisplayDTO>> findAllCustomers(){

        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<CustomerDisplayDTO> findCustomerByID(@PathVariable("customerID") Long customerID) {
        CustomerDisplayDTO customerDisplayDTO = customerService.findCustomerByID(customerID);

        return ResponseEntity.ok(customerDisplayDTO);
    }

    @PutMapping("/{customerID}")
    public ResponseEntity<CustomerDisplayDTO> updateCustomer(@PathVariable("customerID") Long customerID,
                                                             @Valid @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        CustomerDisplayDTO customerDisplayDTO = customerService.updateCustomer(customerUpdateDTO, customerID);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Customer updated successfully! :)")
                .build();
    }

    @DeleteMapping("/{customerID}")
    public ResponseEntity<Void> deleteCustomerByID(@PathVariable("customerID") Long customerID) {
        customerService.deleteCustomerByID(customerID);

        return ResponseEntity.noContent()
                .header("Message", "Customer deleted successfully! :)")
                .build();
    }
}
