package com.siseth.dw.helloworld;

import com.siseth.dw.helloworld.ManagedObject.RandomClass;
import com.siseth.dw.helloworld.ManagedObject.RandomClassManager;
import com.siseth.dw.helloworld.config.HelloWorldConfiguration;

import com.siseth.dw.helloworld.dao.ActorDAO;
import com.siseth.dw.helloworld.resource.ActorResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.flywaydb.core.Flyway;

public class App extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    private static final ScanningHibernateBundle<HelloWorldConfiguration> hibernateBundle =
            new ScanningHibernateBundle<HelloWorldConfiguration>(App.class.getPackage().getName()) {
                @Override
                public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    private final SwaggerBundle<HelloWorldConfiguration> swaggerBundle =
            new SwaggerBundle<HelloWorldConfiguration>() {
                @Override
                protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(HelloWorldConfiguration helloWorldConfiguration) {
                    return helloWorldConfiguration.swaggerBundleConfiguration;
                }
            };

    private final FlywayBundle<HelloWorldConfiguration> flywayBundle =
            new FlywayBundle<HelloWorldConfiguration>() {
                @Override
                public PooledDataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(swaggerBundle);
        bootstrap.addBundle(flywayBundle);
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {

        final ActorDAO actorDAO = new ActorDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new ActorResource(actorDAO));

        RandomClassManager randomClassManager = new RandomClassManager(configuration);

        environment.lifecycle().manage(randomClassManager);
    }
}


