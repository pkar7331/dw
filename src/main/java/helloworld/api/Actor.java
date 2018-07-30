package helloworld.api;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(schema = "public", name="Actor")
public class Actor {

    @Id
    @GeneratedValue
    private long actorId;

    private String firstName;
    private String lastName;
    private Time lastUpdate;

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Time getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Time lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}