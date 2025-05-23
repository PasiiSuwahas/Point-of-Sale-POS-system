package com.springbootacademy.batch7.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerUpdateDTo {

    private int customer_id;
    private String customer_name;
    private String customer_address;
    private double customer_salary;

}