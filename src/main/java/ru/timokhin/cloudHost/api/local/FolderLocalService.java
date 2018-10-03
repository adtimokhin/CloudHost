package ru.timokhin.cloudHost.api.local;

import ru.timokhin.cloudHost.api.basic.FolderService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface FolderLocalService extends FolderService {
    void init();
}
