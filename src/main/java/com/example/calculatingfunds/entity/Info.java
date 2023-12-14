package com.example.calculatingfunds.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    public Info(){

    }

    public Info(String name, double amount, PaymentType paymentType) {
        this.name = name;
        this.amount = amount;
        this.paymentType = paymentType;
    }
}
