package com.belov.orm.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Contact {
    private String firstName;
    private String lastName;
    private String phone;
}
