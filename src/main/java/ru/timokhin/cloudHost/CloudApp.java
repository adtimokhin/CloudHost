package ru.timokhin.cloudHost;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class CloudApp { // точка входа

    public static void main(String[] args) {
       final SeContainer container = SeContainerInitializer.newInstance().addPackages(CloudApp.class).initialize();
    }
}
