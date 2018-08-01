package com.siseth.dw.helloworld.config;

import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.flyway.FlywayFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HelloWorldConfiguration extends Configuration {

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    private FlywayFactory flyway = new FlywayFactory();

    @Valid
    @NotNull
    private AppConfiguration app = new AppConfiguration();

    @Valid
    @NotNull
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public void setDataSourceFactory(DataSourceFactory database){
        this.database = database;
    }

    @NotNull
    public AppConfiguration getApp() {
        return app;
    }

    @NotNull
    public FlywayFactory getFlyway() {
        return flyway;
    }
}
