package ru.timokhin.cloudHost.service.local;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.timokhin.cloudHost.api.local.FileLocalService;
import ru.timokhin.cloudHost.api.local.FolderLocalService;

import java.util.List;

public class FolderLocalServiceBean implements FolderLocalService {
    // Todo: реализовать все методы. Все есть в 3-ем уроке
    @Override
    public void init() {

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
