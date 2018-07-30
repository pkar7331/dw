package helloworld;


import helloworld.api.actor;
import helloworld.config.HelloWorldConfiguration;

import helloworld.resource.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.hibernate.HibernateBundle;

public class App extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }


    private final HibernateBundle<HelloWorldConfiguration> hibernate = new HibernateBundle<HelloWorldConfiguration>(actor.class) {
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
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }



}
