package crud.dogShelter.service;

import crud.dogShelter.DTO.CustomerCreateDTO;
import crud.dogShelter.DTO.CustomerDisplayDTO;
import crud.dogShelter.DTO.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    CustomerDisplayDTO createCustomer(CustomerCreateDTO customer);
    List<CustomerDisplayDTO> findAllCustomers();
    CustomerDisplayDTO findCustomerByID(Long ID);
    CustomerDisplayDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO, Long ID);
    void deleteCustomerByID(Long ID);
}
