package com.exam;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevClass {
    public DevClass() {
        System.out.println("DevClass");
    }
}
