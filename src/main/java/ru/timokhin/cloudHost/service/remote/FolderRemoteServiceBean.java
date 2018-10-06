package ru.timokhin.cloudHost.service.remote;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.timokhin.cloudHost.api.remote.FolderRemoteService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
@ApplicationScoped
public class FolderRemoteServiceBean implements FolderRemoteService{
    @Override
    public void init() {

    }

    @Override
    public @NotNull List<String> getListFolderName() {
        return null;
    }

    @Override
    public void getListNamesRoot() {
    }

    @Override
    public void createFolder(@Nullable String folderName) {

    }

    @Override
    public boolean deleteFolder(@Nullable String folderName) {
        return true;
    }

    @Override
    public boolean clearRoot() {
        return false;
    }

    @Override
    public boolean exists(@Nullable String folderName) {
        return false;
    }
}
