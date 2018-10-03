package ru.timokhin.cloudHost.api.system;

public interface TimerService {
    boolean getActive();

    void setActive(boolean active);

    boolean start();

    boolean stop();

    void restart();
}
