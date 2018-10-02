package ru.timokhin.cloudHost.handler.keyboard;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Scanner;

public class KeyboardCommandHandler {
    // todo: String-константы для всех допустимых для ввода команд
    // annotations

    //TODO: добавить @Inject-ы для File/Folder/Local/Sync Hadlers
    @Inject
    private Event<KeyboardCommandHandler> keyboardCommandEvent;
    public void observe(@Observes final KeyboardCommandHandler event){
        System.out.println("\ncmd:");
        final Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();// nextLine() вместо next(), чтобы была возможность реализовать функионал
        // создания запроса с доп. параметрами(например имя).
        /*switch (command){
            case
        }*/
        System.out.println(command);
        keyboardCommandEvent.fire(new KeyboardCommandHandler());
    }
}
