package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTo;
import com.springbootacademy.batch7.pos.entity.Customer;
import com.springbootacademy.batch7.pos.repo.CustomerRepo;
import com.springbootacademy.batch7.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public String updateCustomer(CustomerUpdateDTo customerUpdateDTo) {
        if(customerRepo.existsById(customerUpdateDTo.getCustomer_id())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTo.getCustomer_id());
            customer.setCustomer_name(customerUpdateDTo.getCustomer_name());
            customer.setCustomer_address(customerUpdateDTo.getCustomer_address());
            customer.setCustomer_salary(customerUpdateDTo.getCustomer_salary());

            customerRepo.save(customer);
            return customerUpdateDTo.getCustomer_name()+" Updated Successfully ";

        }else{
            throw new RuntimeException("NO DAta FOUND");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerid) {
        if(customerRepo.existsById(customerid)){
            Customer customer = customerRepo.getReferenceById(customerid);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomer_id(),
                    customer.getCustomer_name(),
                    customer.getCustomer_address(),
                    customer.getCustomer_salary(),
                    customer.getCustomer_nic(),
                    customer.getContact_number(),
                    customer.isActive_status()
            );

            return customerDTO;
        }else {
            throw new RuntimeException("NO DAta FOUND");
        }

    }


    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomer_id(),
                    customer.getCustomer_name(),
                    customer.getCustomer_address(),
                    customer.getCustomer_salary(),
                    customer.getCustomer_nic(),
                    customer.getContact_number(),
                    customer.isActive_status()
            );

            customerDTOList.add(customerDTO);

        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "deleted Successfully";
        }else{
            throw new RuntimeException("No Customer found");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomer_id(),
                    customer.getCustomer_name(),
                    customer.getCustomer_address(),
                    customer.getCustomer_salary(),
                    customer.getCustomer_nic(),
                    customer.getContact_number(),
                    customer.isActive_status()
            );

            customerDTOList.add(customerDTO);

        }
        return customerDTOList;
    }

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomer_id(),
                customerDTO.getCustomer_name(),
                customerDTO.getCustomer_address(),
                customerDTO.getCustomer_salary(),
                customerDTO.getCustomer_nic(),
                customerDTO.getContact_number(),
                customerDTO.isActive_status()
        );

        customerRepo.save(customer);

        return customerDTO.getCustomer_name();
    }
}
