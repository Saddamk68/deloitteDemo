package com.deloitte.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employee")
public class Employee {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String department;

    private String role;

}
