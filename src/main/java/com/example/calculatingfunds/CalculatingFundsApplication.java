package com.example.calculatingfunds;

import com.example.calculatingfunds.dao.InfoDao;
import com.example.calculatingfunds.entity.Info;
import com.example.calculatingfunds.entity.PaymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class CalculatingFundsApplication {



    public static void main(String[] args) {
        SpringApplication.run(CalculatingFundsApplication.class, args);
    }

}
