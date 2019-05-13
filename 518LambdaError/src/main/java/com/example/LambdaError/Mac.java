package com.example.LambdaError;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
class Mac {

    @Id
    @GeneratedValue
    public Long id;
    @NotEmpty(message = "name must not empty")
    public String name;
    @NotEmpty(message = "age must not empty")
    public String age;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
