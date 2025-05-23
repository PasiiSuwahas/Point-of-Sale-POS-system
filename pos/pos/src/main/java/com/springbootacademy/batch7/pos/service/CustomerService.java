package com.springbootacademy.batch7.pos.service;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTo;

import java.util.List;

public interface CustomerService {

    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTo customerUpdateDTo);

    CustomerDTO getCustomerById(int customerid);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
