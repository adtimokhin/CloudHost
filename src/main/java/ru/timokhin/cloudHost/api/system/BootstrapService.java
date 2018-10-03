package ru.timokhin.cloudHost.api.system;

import ter.tre;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

public interface BootstrapService {
    void init();
}
