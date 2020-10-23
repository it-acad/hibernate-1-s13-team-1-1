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

    @NotBlank(message = "The taskName cannot be empty")
    @Column(nullable = false, unique = true)
    private String priority;

    @NotBlank(message = "The taskState_id cannot be empty")
    @Column(nullable = false, unique = true)
    private long state_id;

    @NotBlank(message = "The taskTodo_id cannot be empty")
    @Column(nullable = false, unique = true)
    private long todo_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private List<State> states;

    @ManyToOne(fetch = FetchType.LAZY)
    private List<ToDo> toDos;

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

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
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
