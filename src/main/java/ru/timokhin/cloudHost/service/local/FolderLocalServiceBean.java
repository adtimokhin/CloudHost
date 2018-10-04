package ru.timokhin.cloudHost.service.local;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.timokhin.cloudHost.api.local.FileLocalService;
import ru.timokhin.cloudHost.api.local.FolderLocalService;
import ru.timokhin.cloudHost.api.system.SettingService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.util.List;
@ApplicationScoped
public class FolderLocalServiceBean implements FolderLocalService {
    // Todo: реализовать все методы. Все есть в 3-ем уроке
    @Inject
    private SettingService settingService;

    @Override
    public void init() {
        String folder = settingService.getSyncFolder();
        final File file = new File(folder);
        file.mkdir();
    }

    @Override
    public @NotNull List<String> getListFolderName() {
        return null;
    }

    @Override
    public @NotNull List<String> getListFolderNameRoot() {
        return null;
    }

    @Override
    public void createFolder(@Nullable String folderName) {

    }


}
