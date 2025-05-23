package com.springbootacademy.batch7.pos.controller;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTo;
import com.springbootacademy.batch7.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer1") // unique the controller
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saved")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);

        return customerDTO.getCustomer_name()+" Saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTo customerUpdateDTo){
        String message = customerService.updateCustomer(customerUpdateDTo);
        return message;

    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomer(@RequestParam(value = "id") int customer_id){
        CustomerDTO customerDTO = customerService.getCustomerById(customer_id);
        return customerDTO;
    }

    @GetMapping(
            path = "/get-all-customer"
    )

    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomer = customerService.getAllCustomers();
        return allCustomer;

    }

    @DeleteMapping(
            path = "/delete-customer/{id}"
    )

    public String  deleteCustomer(@PathVariable(value = "id") int customer_id){
        String deleted = customerService.deleteCustomer(customer_id);
        return deleted;
    }


    @GetMapping(
            path = "/get-all-customer-by-active-state/{status}"
    )

    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState){
        List<CustomerDTO> allCustomer = customerService.getAllCustomersByActiveState(activeState);
        return allCustomer;

    }
}
