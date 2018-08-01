package com.siseth.dw.helloworld.resource;

import com.codahale.metrics.annotation.Timed;
import com.siseth.dw.helloworld.api.Actor;
import com.siseth.dw.helloworld.dao.ActorDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;

import javax.validation.Valid;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.sql.Date;
import java.util.List;

@Path("/actors")
@Api(value = "/actors", description = "Operations about actors")
@Produces(MediaType.APPLICATION_JSON)
public class ActorResource{

    private final ActorDAO actorDAO;

    public ActorResource(ActorDAO actorDAO){
        this.actorDAO = actorDAO;
    }

    @GET
    @Path("/{id}")
    @Timed
    @UnitOfWork
    public Actor findActor(@PathParam("id") Long id){
        return actorDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @Path("/new")
    public Actor createActor(Actor actor){
        return actorDAO.create(actor);
    }

    @GET
    @Path("/all")
    @UnitOfWork
    public List<Actor> findAll(){
        return actorDAO.findAll();
    }

    @DELETE
    @Path("/delete/{id}")
    @UnitOfWork
    public void deleteById(@PathParam("id") Long id) {
        actorDAO.delete(actorDAO.findById(id));
    }

    @PUT
    @Path("/update/{id}")
    @UnitOfWork
    public Actor update(@PathParam("id") Long id, @Valid Actor actor){
        actor.setActor_id(id);
        actor.setLast_update(new Date(System.currentTimeMillis()));
        actorDAO.update(actor);
        return actor;
    }
}