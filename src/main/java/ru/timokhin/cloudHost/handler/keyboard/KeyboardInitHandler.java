package ru.timokhin.cloudHost.handler.keyboard;

import ru.timokhin.cloudHost.event.keyboard.KeyboardCommandEvent;
import ru.timokhin.cloudHost.event.keyboard.KeyboardInitEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class KeyboardInitHandler {
    @Inject
    private Event<KeyboardCommandEvent> keyboardCommandEvent;
    /**
     * получив {@link KeyboardInitEvent} из ... , выводится приветственное сообщение и {@link KeyboardCommandEvent} срабатывает в {@linkplain KeyboardCommandHandler}**/
    public void init(@Observes final KeyboardInitEvent event){
        System.out.println();
        System.out.println("WELCOME TO COMMAND LINE INTERFACE");
        System.out.println("FOR LIST OF COMMANDS ENTER COMMAND \"help\"");
        keyboardCommandEvent.fire(new KeyboardCommandEvent());
    }
}