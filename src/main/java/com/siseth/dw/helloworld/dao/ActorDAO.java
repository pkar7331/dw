package com.siseth.dw.helloworld.dao;

import com.siseth.dw.helloworld.api.Actor;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class ActorDAO extends AbstractDAO<Actor> {
    public ActorDAO(SessionFactory factory){
        super(factory);
    }

    public Actor findById(Long id){
        return get(id);
    }

    public long create(Actor actor){
        return persist(actor).getActor_id();
    }
}
