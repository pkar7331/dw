package helloworld;


import helloworld.api.Actor;
import helloworld.config.HelloWorldConfiguration;

import helloworld.dao.ActorDAO;
import helloworld.resource.ActorResource;
import helloworld.resource.HelloWorldResource;
import io.dropwizard.Application;

//import io.dropwizard.db.DataSourceFactory;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;



public class App extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }


    private final HibernateBundle<HelloWorldConfiguration> hibernate = new HibernateBundle<HelloWorldConfiguration>(Actor.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }


    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        /*
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);*/
        final ActorDAO actorDAO = new ActorDAO(hibernate.getSessionFactory());
        environment.jersey().register(new ActorResource(actorDAO));
    }

    }


