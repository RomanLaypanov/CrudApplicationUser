package web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @Size(min = 2, max = 50, message = "Имя не соответсвует правильной длинне от 2 до 50")
    @NotEmpty(message = "Имя пустое")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 50, message = "Фамилия не соответсвует правильной длинне от 2 до 50")
    @NotEmpty(message = "Фамилия пустое")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0, message = "Возраст указан не верно")
    private int age;

    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}