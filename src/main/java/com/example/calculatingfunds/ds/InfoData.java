package com.example.calculatingfunds.ds;

import com.example.calculatingfunds.entity.PaymentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoData {
    private Integer id;
    private String name;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}
