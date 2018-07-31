package com.siseth.dw.helloworld.api;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(schema = "public", name="Actor")
@SequenceGenerator(schema = "public", name = "id_generator", sequenceName = "actor_actor_id_seq", allocationSize = 1)
public class Actor {

    @Id
    @GeneratedValue
    private long actor_id;

    public Actor() {
    }

    public Actor(long actor_id, String first_name, String last_name, Time last_update) {
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.last_update = last_update;
    }

    public long getActor_id() {
        return actor_id;
    }

    public void setActor_id(long actor_id) {
        this.actor_id = actor_id;
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

    public Time getLast_update() {
        return last_update;
    }

    public void setLast_update(Time last_update) {
        this.last_update = last_update;
    }

    private String first_name;
    private String last_name;
    private Time last_update;
}