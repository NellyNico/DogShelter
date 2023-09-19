package crud.dogShelter.converter;

import crud.dogShelter.DTO.CustomerCreateDTO;
import crud.dogShelter.DTO.CustomerDisplayDTO;
import crud.dogShelter.DTO.CustomerUpdateDTO;
import crud.dogShelter.model.Customer;

public class CustomerConverter {

    public static Customer createDTOToEntity(CustomerCreateDTO customerCreateDTO) {

        Customer customer = new Customer();
        customer.setName(customerCreateDTO.getName());
        customer.setCNP(customerCreateDTO.getCNP());
        customer.setAddress(customerCreateDTO.getAddress());
        customer.setPhoneNumber(customerCreateDTO.getPhoneNumber());
        customer.setEmail(customerCreateDTO.getEmail());

        return customer;
    }

    public static CustomerDisplayDTO entityToDisplayDTO(Customer customer) {

        CustomerDisplayDTO customerDisplayDTO = new CustomerDisplayDTO();
        customerDisplayDTO.setID(customer.getID());
        customerDisplayDTO.setName(customer.getName());
        customerDisplayDTO.setCNP(customer.getCNP());
        customerDisplayDTO.setAddress(customer.getAddress());
        customerDisplayDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDisplayDTO.setEmail(customer.getEmail());

        return customerDisplayDTO;
    }

    public static Customer updateDTOToEntity(CustomerUpdateDTO customerUpdateDTO) {

        Customer customer = new Customer();
        customer.setID(customerUpdateDTO.getId());
        customer.setName(customerUpdateDTO.getName());
        customer.setCNP(customerUpdateDTO.getCNP());
        customer.setAddress(customerUpdateDTO.getAddress());
        customer.setPhoneNumber(customerUpdateDTO.getPhoneNumber());
        customer.setEmail(customerUpdateDTO.getEmail());

        return customer;
    }
}
