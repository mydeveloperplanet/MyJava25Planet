package com.mydeveloperplanet.myjava25planet.scopedvalues;

import static java.lang.ScopedValue.where;

public class Framework {

    private final Application application;

    public Framework(Application app) { this.application = app; }

    private static final ScopedValue<FrameworkContext> CONTEXT
            = ScopedValue.newInstance();    // (1)

    void serve(Request request, Response response) {
        var context = createContext(request);
        where(CONTEXT, context)                         // (2)
                .run(() -> application.handle(request, response));
    }

    public UserInfo readKey(String key) {
        var context = CONTEXT.get();              // (3)
        return context.getUserInfo();
    }

    FrameworkContext createContext(Request request) {
        FrameworkContext frameworkContext = new FrameworkContext();
        UserInfo userInfo = new UserInfo();
        // set data from request
        frameworkContext.setUserInfo(userInfo);
        return frameworkContext;
    }

}

class FrameworkContext {
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
