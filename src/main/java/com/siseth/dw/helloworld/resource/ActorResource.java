package com.siseth.dw.helloworld.resource;


import com.codahale.metrics.annotation.Timed;
import com.siseth.dw.helloworld.api.Actor;
import com.siseth.dw.helloworld.dao.ActorDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import io.swagger.annotations.Api;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    public Actor findActor(@PathParam("id") LongParam id){
        return actorDAO.findById(id.get());
    }
    


}
