package com.belov.orm.domain;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private Contact contact;

    private String location;
    private Integer age;
}
