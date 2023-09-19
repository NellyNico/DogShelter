package crud.dogShelter.service.impl;

import crud.dogShelter.DTO.CustomerCreateDTO;
import crud.dogShelter.DTO.CustomerDisplayDTO;
import crud.dogShelter.DTO.CustomerUpdateDTO;
import crud.dogShelter.converter.CustomerConverter;
import crud.dogShelter.exceptions.CustomerNotFoundException;
import crud.dogShelter.model.Customer;
import crud.dogShelter.repository.CustomerRepository;
import crud.dogShelter.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDisplayDTO createCustomer(CustomerCreateDTO customerCreateDTO) {

        Customer customer = CustomerConverter.createDTOToEntity(customerCreateDTO);
        Customer createdCustomer = customerRepository.save(customer);

        return CustomerConverter.entityToDisplayDTO(createdCustomer);
    }

    @Override
    public List<CustomerDisplayDTO> findAllCustomers() {

        List<CustomerDisplayDTO> customerDisplayDTO = new ArrayList<>();
        customerRepository.findAll().forEach(entity -> customerDisplayDTO.add(CustomerConverter.entityToDisplayDTO(entity)));

        return customerDisplayDTO;
    }

    @Override
    public CustomerDisplayDTO findCustomerByID(Long ID) {

        Customer customer = customerRepository.findById(ID)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID" + ID + " not found! :("));

        return CustomerConverter.entityToDisplayDTO(customer);
    }

    @Override
    public CustomerDisplayDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO, Long ID) {
        Customer customer = customerRepository.findById(ID)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID" + ID + " not found!"));
        customer.setName(customerUpdateDTO.getName());
        customer.setCNP(customerUpdateDTO.getCNP());
        customer.setAddress(customerUpdateDTO.getAddress());
        customer.setPhoneNumber(customerUpdateDTO.getPhoneNumber());
        customer.setEmail(customerUpdateDTO.getEmail());

        Customer updatedCustomer = customerRepository.save(customer);

        return CustomerConverter.entityToDisplayDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomerByID(Long ID) {

        customerRepository.findById(ID)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID" + ID + " not found!"));

        customerRepository.deleteById(ID);
    }
}
