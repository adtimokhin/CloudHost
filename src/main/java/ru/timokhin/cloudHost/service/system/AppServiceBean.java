package ru.timokhin.cloudHost.service.system;

//import lombok.SneakyThrows;
import org.apache.jackrabbit.rmi.repository.URLRemoteRepository;
import org.jetbrains.annotations.Nullable;
import ru.timokhin.cloudHost.api.system.AppService;
import ru.timokhin.cloudHost.api.system.SettingService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jcr.*;
import java.net.MalformedURLException;

@ApplicationScoped
public class AppServiceBean implements AppService {
    @Inject
    private SettingService settingService;

    private Repository repository = null;
    private Session session = null;
    private Exception error = null;

    @Override
    public void init() {
        if (settingService.getJcrActive()) login();
    }

    @Override
    public void shutdown() {
        System.exit(0);
    }

    @Override
    public boolean login() {
        if (status()) return false;
        try {
            repository = new URLRemoteRepository(settingService.getJcrUrl());
            String jcrLogin = settingService.getJcrLogin();
            String jcrPassword = settingService.getJcrPassword();
            char[] password = jcrPassword.toCharArray();
            session = repository.login(new SimpleCredentials(jcrLogin, password));
            return true;
        } catch (Exception e) {
            error = e;
            return false;
        }

    }

    @Override
    public boolean logout() {
        try {
            session.logout();
            return true;
        } catch (Exception e) {
            error = e;
            return false;
        }

    }

    @Override
    public boolean status() {
        if(repository == null)return false;
        if(session == null)return false;
//        try{
//            repository = null;
//            session = null;
//            return true;
//        }catch (Exception e){
//            error = e;
//            return false;
//        }
        return true;
    }

    @Override
    public boolean save() {
        try {
            session.save();
            return true;
        } catch (Exception e) {
            error = e;
            return false;
        }
    }

    @Override
    public @Nullable Exception error() {
        return error;
    }

    @Override
    public @Nullable Repository repository() {
        return repository;
    }

    @Override
    public @Nullable Session session() {
        return session;
    }



    @Override
    public @Nullable Node getRootNode() {

        if(!status())return null;
        try {
            return session.getRootNode();
        } catch (RepositoryException e) {
            error =e;
        }
        return null;
    }
}
