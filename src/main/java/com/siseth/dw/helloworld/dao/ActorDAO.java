package com.siseth.dw.helloworld.dao;

import com.siseth.dw.helloworld.api.Actor;
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

    public Actor create(Actor actor){
        return persist(actor);
    }

    public List<Actor> findAll() {
        return list(namedQuery("com.siseth.dw.helloworld.api.Actor.findAll"));
    }

    public void delete(Actor actor){
        currentSession().delete(actor);
    }

    public void update(Actor actor){
        currentSession().saveOrUpdate(actor);
    }

}
