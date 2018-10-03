package ru.timokhin.cloudHost.api.basic;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface FolderService {
    @NotNull List<String> getListFolderName();
    @NotNull List<String> getListFolderNameRoot();
    void createFolder(@Nullable String folderName);

}
