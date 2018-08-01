package com.siseth.dw.helloworld.config;

import io.dropwizard.Configuration;

public class AppConfiguration extends Configuration {
    private Boolean migration;

    private Boolean reinstall;

    private Boolean repair;

    public Boolean getMigration() {
        return migration;
    }

    public Boolean getReinstall() {
        return reinstall;
    }

    public Boolean getRepair() {
        return repair;
    }
}
