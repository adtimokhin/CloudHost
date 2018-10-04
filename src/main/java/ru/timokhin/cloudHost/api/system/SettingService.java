package ru.timokhin.cloudHost.api.system;

import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;

/**
 * Интерфейс для работы со значениями resources.properties. Интерфейс также имеет метод init() для инитилизации класса,
 * вызывающего данный метод
 **/
public interface SettingService {
    void init();

    // Jcr getters
    @NotNull
    Boolean getJcrActive();

    @NotNull
    String getJcrUrl();

    @NotNull
    String getJcrLogin();

    @NotNull
    String getJcrPassword();

    //Sync getters
    @NotNull
    Boolean getSyncActive();

    @NotNull
    Boolean getSyncSoap();

    @NotNull
    String getSyncEndpoint();

    @NotNull
    Integer getSyncTimeout();

    @NotNull
    String getSyncFolder();

}
