package helloworld.api;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.sql.Time;
import java.util.Timer;

@Entity
@Table(schema = "public", name="actor")
public class actor {

    @Id
    @GeneratedValue
    private long actor_id;

    private String first_name;
    private String last_name;
    private Time last_update;

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
}