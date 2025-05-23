package com.springbootacademy.batch7.pos.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.ArrayList;


@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class Customer {

    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customer_name;

    @Column(name = "customer_address", length = 200)
    private String customer_address;

    @Column(name = "customer_salary")
    private double customer_salary;

    @Column(name = "customer_nic",length = 15,nullable = false)
    private String customer_nic;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "contact_numbers", columnDefinition = "json")
    private ArrayList<String> contact_number;

    @Column(name ="active_status",columnDefinition = "TINYINT default 0")
    private boolean active_status;




}
