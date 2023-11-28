package web.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "firstName")
    private String  firstName;

    @Column(name = "lastName")
    private String  lastName;

    @Column(name = "Salary")
    private int Salary;
}
