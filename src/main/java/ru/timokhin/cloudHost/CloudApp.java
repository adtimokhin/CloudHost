package ru.timokhin.cloudHost;

import ru.timokhin.cloudHost.service.system.BootstrapServiceBean;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.se.SeContainerInitializer;
@ApplicationScoped
public class CloudApp { // точка входа

    public static void main(String[] args) {
        SeContainerInitializer.newInstance().addPackages(CloudApp.class).initialize()
                .select(BootstrapServiceBean.class).get().init();
    }
}
