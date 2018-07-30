package helloworld.dao;

import helloworld.api.Actor;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class ActorDAO extends AbstractDAO<Actor> {
    public ActorDAO(SessionFactory factory){
        super(factory);
    }

    public Actor findById(Long id){
        return get(id);
    }

    public long create(Actor actor){
        return persist(actor).getActorId();
    }


}
