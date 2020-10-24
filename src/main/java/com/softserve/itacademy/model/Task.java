package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", insertable = false, updatable = false)
    private long id;

    @NotBlank(message = "The taskName cannot be empty")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotBlank(message = "The taskName cannot be empty")
    @Column(name = "priority", nullable = false, unique = true)
    private String priority;

    @NotBlank(message = "The taskState_id cannot be empty")
    @Column(name = "state_id", nullable = false, unique = true)
    private long state_id;

    @NotBlank(message = "The taskTodo_id cannot be empty")
    @Column(name = "todo_id", nullable = false, unique = true)
    private long todo_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private State states;

    @ManyToOne(fetch = FetchType.LAZY)
    private ToDo toDos;

    public Task() {

    }

    public Task(long id, @NotBlank(message = "The taskName cannot be empty") String name, @NotBlank(message = "The taskName cannot be empty") String priority, @NotBlank(message = "The taskState_id cannot be empty") long state_id, @NotBlank(message = "The taskTodo_id cannot be empty") long todo_id, State states, ToDo toDos) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.state_id = state_id;
        this.todo_id = todo_id;
        this.states = states;
        this.toDos = toDos;
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

    public State getStates() {
        return states;
    }

    public void setStates(State states) {
        this.states = states;
    }

    public ToDo getToDos() {
        return toDos;
    }

    public void setToDos(ToDo toDos) {
        this.toDos = toDos;
    }

    @Override
    public String toString() {
        return "Task {" +
                "id = " + id +
                ", name = '" + name +
                ", priority = '" + priority +
                ", state_id = '" + state_id +
                ", todo_id = '" + todo_id + '\'' +
                "} ";
    }
}
