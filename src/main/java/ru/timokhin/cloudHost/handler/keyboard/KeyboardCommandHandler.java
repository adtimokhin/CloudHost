package ru.timokhin.cloudHost.handler.keyboard;

import ru.timokhin.cloudHost.api.local.FileLocalService;
import ru.timokhin.cloudHost.api.local.FolderLocalService;
import ru.timokhin.cloudHost.api.remote.FileRemoteService;
import ru.timokhin.cloudHost.api.remote.FolderRemoteService;
import ru.timokhin.cloudHost.api.system.AppService;
import ru.timokhin.cloudHost.event.keyboard.KeyboardCommandEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Scanner;

@ApplicationScoped
public class KeyboardCommandHandler {
    //команда вызова списка команд и их описания
    private static final String HELP_CMD ="help";
    // команда выхода из приложения
    private static final String EXIT_CMD = "exit";
    //команды входа/выхода из учетной записи (пока не реализовано)
    private static final String LOGIN_CMD ="login";
    private static final String LOGOUT_CMD ="logout";
    // команды поиска элементов по локальному и удаленному хранилищу(не реализованно)
    private static final String LOCAL_FILE_LIST_CMD ="local-file-list";
    private static final String LOCAL_FOLDER_LIST_CMD ="local-folder-list";
    private static final String REMOTE_FILE_LIST_CMD ="remote-file-list";
    private static final String REMOTE_FOLDER_LIST_CMD ="remote-folder-list";
    //команды изменения состояния папок/файлов в удаленом хранилище
    private static final String REMOTE_FOLDER_ADD_CMD ="remote-folder-add";
    private static final String REMOTE_FOLDER_DELETE_CMD ="remote-folder-delete";
    private static final String REMOTE_FILE_DELETE_CMD ="remote-file-delete";
    private static final String REMOTE_FILE_ADD_CMD ="remote-file-add";
    //команды изменения состояния папок/файлов в локальном хранилище
    private static final String LOCAL_FOLDER_ADD_CMD ="local-folder-add";
    private static final String LOCAL_FOLDER_DELETE_CMD ="local-folder-delete";
    private static final String LOCAL_FILE_DELETE_CMD ="local-file-delete";
    private static final String LOCAL_FILE_ADD_CMD ="local-file-add";

    @Inject
    private AppService appService;
    @Inject
    private FolderLocalService folderLocalService;
    @Inject
    private FileLocalService fileLocalService;
    @Inject
    private FolderRemoteService folderRemoteService;
    @Inject
    private FileRemoteService fileRemoteService;
    @Inject
    private Event<KeyboardCommandEvent> keyboardCommandEvent;

    public void observe(@Observes final KeyboardCommandEvent event) {
        System.out.println("\ncmd:");
        final Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();// nextLine() вместо next(), чтобы была возможность реализовать функионал
        // создания запроса с доп. параметрами(например имя).
        //todo: создать switch, в котором, все методы будут вызываться, используя константы
        switch (command){
            case HELP_CMD:
                printHelp();
                break;
            case EXIT_CMD:
                appService.shutdown();
                break;
            case LOGIN_CMD:
                appService.login();
                break;
            case LOGOUT_CMD:
                appService.logout();
                break;
            default:
                System.out.println("Команда не опознана");
        }
        keyboardCommandEvent.fire(new KeyboardCommandEvent());
    }

    private void printHelp() {
        System.out.println();
        System.out.println(HELP_CMD+" - команда вызова списка команд и их описания");
        System.out.println(EXIT_CMD+" - команда выхода из приложения");
        System.out.println(LOGIN_CMD+" - команда регистрирования на удаленное хранилище");
        System.out.println(LOGOUT_CMD+" - команда выхода из учетной записи удаленного хранилища");
        System.out.println(LOCAL_FILE_LIST_CMD+" - команда возращающая лист файлов из локальной папки");
        System.out.println(LOCAL_FOLDER_LIST_CMD+" - команда возращающая лист папок из локальной папки");
        System.out.println(REMOTE_FILE_LIST_CMD+" - команда возращающая лист файлов из папки удаленного хранилища");
        System.out.println(REMOTE_FOLDER_LIST_CMD+" - команда возращающая лист папок из папки удаленного хранилища");
        System.out.println(LOCAL_FOLDER_ADD_CMD+" - команда создания папки в локальной папке");
        System.out.println(LOCAL_FILE_ADD_CMD+" - команда создания файла в локальной папке");
        System.out.println(LOCAL_FOLDER_DELETE_CMD+" - команда удаления папки из локальной папки");
        System.out.println(LOCAL_FILE_DELETE_CMD+" - команда удаления файла из локальной папки");
        System.out.println(REMOTE_FOLDER_ADD_CMD+" - команда создания папки в удаленной папке");
        System.out.println(REMOTE_FILE_ADD_CMD+" - команда создания файла в удаленной папке");
        System.out.println(REMOTE_FOLDER_DELETE_CMD+" - команда удаления папки из удаленной папки");
        System.out.println(REMOTE_FILE_DELETE_CMD+" - команда удаления файла из удаленной папки");
    }
}
