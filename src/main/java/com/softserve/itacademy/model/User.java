package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    private long id;

    @NotBlank(message = "The userName cannot be empty")
    @Column(nullable = false, unique = true)

    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private long role_id;

    @OneToMany(mappedBy = "user")
    private List<User> users;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                role_id == user.role_id &&
                email.equals(user.email) &&
                first_name.equals(user.first_name) &&
                last_name.equals(user.last_name) &&
                password.equals(user.password) &&
                users.equals(user.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, first_name, last_name, password, role_id, users);
    }

    @Override
    public String toString() {
        return "Role {" +
                "id = " + id +
                ", email = '" + email +
                ", first_name = '" + first_name +
                ", last_name = '" + last_name +
                ", password = '" + password +
                ", role_id = '" + role_id + '\'' +
                "} ";
    }
}
