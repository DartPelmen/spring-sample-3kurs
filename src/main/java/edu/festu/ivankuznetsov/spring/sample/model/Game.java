package edu.festu.ivankuznetsov.spring.sample.model;

import java.util.UUID;

public class Game {
    private UUID id;
    private String name;


    public Game() {
        id = UUID.randomUUID();
        name = "NONAME";
    }

    public Game(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    public Game(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
