package com.exam;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdClass {
    public ProdClass() {
        System.out.println("ProdClass");
    }
}
