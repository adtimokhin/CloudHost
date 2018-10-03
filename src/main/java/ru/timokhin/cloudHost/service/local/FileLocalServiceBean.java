package ru.timokhin.cloudHost.service.local;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.timokhin.cloudHost.api.local.FileLocalService;

import java.util.List;

public class FileLocalServiceBean implements FileLocalService {
    // Todo: реализовать все методы. Все есть в 3-ем уроке
    @Override
    public @NotNull List<String> getListNameFiles() {
        return null;
    }

    @Nullable
    @Override
    public Byte[] readData(@Nullable String fileName) {
        return new Byte[0];
    }

    @Override
    public boolean exist(@Nullable String fileName) {
        return false;
    }

    @Override
    public void remove(@Nullable String fileName) {

    }

    @Override
    public void createSimpleTxtFile(@Nullable String fileName, String inputData) {

    }
}
