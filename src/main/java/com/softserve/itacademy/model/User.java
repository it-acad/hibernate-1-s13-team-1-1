package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private long id;

    @NotBlank(message = "The userEmail cannot be empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "The userFirst_name cannot be empty")
    @Column(name = "first_name", nullable = false, unique = true)
    private String first_name;

    @NotBlank(message = "The userLast_name cannot be empty")
    @Column(name = "last_name", nullable = false, unique = true)
    private String last_name;

    @NotBlank(message = "The userPassword cannot be empty")
    @Column(name = "password", nullable = false, unique = true)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_@#$%^&+=])(?=\\S+$).{8,}$", message = "password must contain special characters")
    private String password;

    @NotBlank(message = "The userRole_id cannot be empty")
    @Column(name = "role_id", nullable = false, unique = true)
    private long role_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role roles;

    @OneToMany(mappedBy = "owner_id", cascade = CascadeType.ALL)
    private List<ToDo> toDo;

    @ManyToMany
    @JoinTable(name = "todo_collaborator", joinColumns = @JoinColumn(name = "collaborator_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "todo_id", referencedColumnName = "id")
    )
    private Set<ToDo> todos;

    public User() {
    }

    public User(long id, @NotBlank(message = "The userEmail cannot be empty") String email, @NotBlank(message = "The userFirst_name cannot be empty") String first_name, @NotBlank(message = "The userLast_name cannot be empty") String last_name, @NotBlank(message = "The userPassword cannot be empty") @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_@#$%^&+=])(?=\\S+$).{8,}$", message = "password must contain special characters") String password, @NotBlank(message = "The userRole_id cannot be empty") long role_id, Role roles, List<ToDo> toDo, Set<ToDo> todos) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.role_id = role_id;
        this.roles = roles;
        this.toDo = toDo;
        this.todos = todos;
    }

    public List<ToDo> getToDo() {
        return toDo;
    }

    public void setToDo(List<ToDo> toDo) {
        this.toDo = toDo;
    }

    public Set<ToDo> getTodos() {
        return todos;
    }

    public void setTodos(Set<ToDo> todos) {
        this.todos = todos;
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

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User {" +
                "id = " + id +
                ", email = '" + email +
                ", first_name = '" + first_name +
                ", last_name = '" + last_name +
                ", password = '" + password +
                ", role_id = '" + role_id  +'\'' +
                "} ";
    }
}
