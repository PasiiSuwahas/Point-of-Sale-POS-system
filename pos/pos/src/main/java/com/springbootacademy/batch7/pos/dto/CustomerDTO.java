package com.springbootacademy.batch7.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private int customer_id;
    private String customer_name;
    private String customer_address;
    private double customer_salary;
    private String customer_nic;
    private ArrayList<String> contact_number;
    private boolean active_status;


    }

