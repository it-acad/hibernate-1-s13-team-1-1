package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "task_sequence"),
                    @Parameter(name = "initial_value", value = "10"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    private long id;

    @NotBlank(message = "The taskName cannot be empty")
    @Column(nullable = false, unique = true)

    private String name;
    private String priority;
    private long state_id;
    private long todo_id;

    @OneToMany(mappedBy = "task")
    private List<User> users;

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getState_id() {
        return state_id;
    }

    public void setState_id(long state_id) {
        this.state_id = state_id;
    }

    public long getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(long todo_id) {
        this.todo_id = todo_id;
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
        Task task = (Task) o;
        return id == task.id &&
                state_id == task.state_id &&
                todo_id == task.todo_id &&
                name.equals(task.name) &&
                priority.equals(task.priority) &&
                users.equals(task.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priority, state_id, todo_id, users);
    }

    @Override
    public String toString() {
        return "Role {" +
                "id = " + id +
                ", name = '" + name +
                ", priority = '" + priority +
                ", state_id = '" + state_id +
                ", todo_id = '" + todo_id + '\'' +
                "} ";
    }
}

