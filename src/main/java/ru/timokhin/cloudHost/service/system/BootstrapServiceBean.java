package ru.timokhin.cloudHost.service.system;


import ru.timokhin.cloudHost.api.system.AppService;
import ru.timokhin.cloudHost.event.keyboard.KeyboardInitEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class BootstrapServiceBean{
    @Inject
    private Event<KeyboardInitEvent> keyboardInitEventEvent;

//    @Inject
//    private AppService appService;

    public void init(){
        System.out.println(3);
        keyboardInitEventEvent.fire(new KeyboardInitEvent());

    }
}
