package com.springbootacademy.batch7.pos.entity;

import com.springbootacademy.batch7.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String item_id;

    @Column(name = "item_name",length = 45,nullable = false)
    private String item_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length =100,nullable = false)
    private MeasuringUnitType measure_type;

    @Column(name = "balance_qty",length = 45,nullable = false)
    private double balance_qty;

    @Column(name = "supplier_price",length =100,nullable = false)
    private double supplier_price;

    @Column(name = "selling_price",length =100,nullable = false)
    private String selling_price;

    @Column(name = "active_status",columnDefinition ="TINYINT default 0")
    private boolean active_status;


}
