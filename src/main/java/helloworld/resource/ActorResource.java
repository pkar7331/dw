package helloworld.resource;


import com.codahale.metrics.annotation.Timed;
import helloworld.api.Actor;
import helloworld.dao.ActorDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
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
