package ru.timokhin.cloudHost.service.system;


import ru.timokhin.cloudHost.api.anotations.Loggable;
import ru.timokhin.cloudHost.api.system.AppService;
import ru.timokhin.cloudHost.api.system.SettingService;
import ru.timokhin.cloudHost.event.keyboard.KeyboardInitEvent;
import ru.timokhin.cloudHost.service.local.FolderLocalServiceBean;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@ApplicationScoped
public class BootstrapServiceBean {
    @Inject
    private Event<KeyboardInitEvent> keyboardInitEventEvent;

    @Inject
    private AppService appService;
    @Inject
    private SettingService settingService;
    @Inject
    private FolderLocalServiceBean folderLocalServiceBean;

    @Loggable
    /**
     * {@linkplain SettingServiceBean} сервис для работы с resources.properties
     * {@linkplain AppServiceBean} сервис для работы с клиентом. Вход в репозиторий, выход итд
     * {@linkplain FolderLocalServiceBean} сервис для создания папок на локальной машине пользователя
     * {@linkplain ru.timokhin.cloudHost.handler.keyboard.KeyboardInitHandler} ловит {@link KeyboardInitEvent}
     * **/
    public void init() {
        settingService.init();
        appService.init();
        folderLocalServiceBean.init();
        keyboardInitEventEvent.fire(new KeyboardInitEvent());

    }
}
