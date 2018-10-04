package ru.timokhin.cloudHost.api.system;

import org.jetbrains.annotations.Nullable;

import javax.enterprise.context.ApplicationScoped;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;

/**
 * Содержит методы для реализации базового функционала по работе с клиентской частью приложения
 **/
public interface AppService {
    void init();

    void shutdown();

    boolean login();

    boolean logout();

    boolean status();

    boolean save();

    @Nullable
    Exception error();

    @Nullable
    Repository repository();

    @Nullable Session session();

    @Nullable Node getRootNode();
}
