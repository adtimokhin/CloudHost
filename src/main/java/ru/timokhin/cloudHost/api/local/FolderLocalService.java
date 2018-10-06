package ru.timokhin.cloudHost.api.local;

import org.jetbrains.annotations.NotNull;
import ru.timokhin.cloudHost.api.basic.FolderService;

import javax.enterprise.context.ApplicationScoped;

public interface FolderLocalService extends FolderService {
    void init();
}
