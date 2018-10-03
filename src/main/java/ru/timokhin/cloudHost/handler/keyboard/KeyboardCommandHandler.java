package ru.timokhin.cloudHost.handler.keyboard;

import ru.timokhin.cloudHost.api.local.FileLocalService;
import ru.timokhin.cloudHost.api.local.FolderLocalService;
import ru.timokhin.cloudHost.api.remote.FileRemoteService;
import ru.timokhin.cloudHost.api.remote.FolderRemoteService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Scanner;

@ApplicationScoped
public class KeyboardCommandHandler {
    // todo: String-константы для всех допустимых для ввода команд
    // константы

    @Inject
    private FolderLocalService folderLocalService;
    @Inject
    private FileLocalService fileLocalService;
    @Inject
    private FolderRemoteService folderRemoteService;
    @Inject
    private FileRemoteService fileRemoteService;
    @Inject
    private Event<KeyboardCommandHandler> keyboardCommandEvent;

    public void observe(@Observes final KeyboardCommandHandler event) {
        System.out.println("\ncmd:");
        final Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();// nextLine() вместо next(), чтобы была возможность реализовать функионал
        // создания запроса с доп. параметрами(например имя).
        //todo: создать switch, в котором, все методы будут вызываться, используя константы
        /*switch (command){
            case
        }*/
        System.out.println(command);
        keyboardCommandEvent.fire(new KeyboardCommandHandler());
    }
}
