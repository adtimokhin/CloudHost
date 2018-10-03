package ru.timokhin.cloudHost.api.basic;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface FileService {
    @NotNull List<String> getListNameFiles();

    @Nullable
    Byte[] readData(@Nullable String fileName);

    boolean exist(@Nullable String fileName);

    void remove(@Nullable String fileName);

    void createSimpleTxtFile(@Nullable String fileName, String inputData);
}
