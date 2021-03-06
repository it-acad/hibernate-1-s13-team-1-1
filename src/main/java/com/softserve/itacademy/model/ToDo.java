package com.softserve.itacademy.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "todo_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    private long id;

    @NotBlank(message = "The todoTitle cannot be empty")
    @Column(nullable = false, unique = true)
    private String title;

    @NotBlank(message = "The todoOwner_id cannot be empty")
    @Column(nullable = false, unique = true)
    private long owner_id;

    @OneToMany(mappedBy = "todo")
    private List<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    private User users;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "todos")
    private Set<User> user;

    public ToDo() {
    }

    public ToDo(long id, @NotBlank(message = "The todoTitle cannot be empty") String title, @NotBlank(message = "The todoOwner_id cannot be empty") long owner_id, List<Task> tasks, User users, Set<User> user) {
        this.id = id;
        this.title = title;
        this.owner_id = owner_id;
        this.tasks = tasks;
        this.users = users;
        this.user = user;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ToDo {" +
                "id = " + id +
                ", title = '" + title +
                ", owner_id = '" + owner_id + '\'' +
                "} ";
    }

    public OffsetDateTime getCreated_at() {
        return null;
    }

    public void setOwner_id(User validUser) {
    }
}
