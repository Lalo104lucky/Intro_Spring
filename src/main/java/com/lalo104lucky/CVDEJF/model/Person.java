package com.lalo104lucky.CVDEJF.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Person {

    @Value("${person.firstname}")
    private String firstName;

    private String lastName;
    private String profession;
}
