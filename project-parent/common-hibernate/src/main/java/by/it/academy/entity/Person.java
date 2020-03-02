package by.it.academy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Person_Table")
public class Person {
    @Id
    private Long id;
    @Column(length = 3, nullable = true)
    private Integer age;
    @Column(name = "User_NAME" , nullable = false)
    private String name;
    @Column(name = "User_SURNAME" , nullable = false)
    private String surname;
}
