package com.siseth.dw.helloworld.ManagedObject;

import com.siseth.dw.helloworld.config.HelloWorldConfiguration;
import io.dropwizard.lifecycle.Managed;
import org.flywaydb.core.Flyway;

public class RandomClassManager implements Managed {
    final HelloWorldConfiguration helloWorldConfiguration;
    
    public RandomClassManager(HelloWorldConfiguration helloWorldConfiguration) {
        this.helloWorldConfiguration = helloWorldConfiguration;
    }

    @Override
    public void start() throws Exception {
        if (helloWorldConfiguration.getApp().getMigration() == Boolean.FALSE) {
            //log.debug("migration disable");
            return;
        }

        final Flyway flyway = new Flyway();
        flyway.setDataSource(helloWorldConfiguration.getDataSourceFactory().getUrl(), helloWorldConfiguration.getDataSourceFactory().getUser(), helloWorldConfiguration.getDataSourceFactory().getPassword());
        //log.debug("execute database migrations");

        if (helloWorldConfiguration.getApp().getReinstall()) {
            //log.info("-------- DB: CLEAN --------");
            flyway.clean();
//            ExecuteSQLCallback executeSQLCallback = new ExecuteSQLCallback(new Locations("db/clean"), "UTF-8");
//            executeSQLCallback.execute(flyway.getDataSource().getConnection());
        }

        if (helloWorldConfiguration.getApp().getRepair()) {
            //log.info("-------- DB: REPAIR --------");
            flyway.repair();
        }

        //flyway.setCallbacks(new SqlScriptFlywayCallback(coreConfigurationProvider, settingServiceProvider, seasonStyleServiceProvider));

        //log.info("-------- DB: MIGRATION --------");
        flyway.migrate();

        //log.info("-------- DB: RUN --------");
        //ExecuteSQLCallback runSQL = new ExecuteSQLCallback(new Locations("db/run"), "UTF-8");
        //runSQL.execute(flyway.getDataSource().getConnection());

        //log.info("database migrations successfully executed");
    }

    @Override
    public void stop() throws Exception {
        // Do nothing
    }
}