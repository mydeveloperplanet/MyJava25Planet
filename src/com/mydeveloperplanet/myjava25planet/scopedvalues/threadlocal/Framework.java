package com.mydeveloperplanet.myjava25planet.scopedvalues.threadlocal;

public class Framework {

    private final Application application;

    public Framework(Application app) { this.application = app; }
    
    private static final ThreadLocal<FrameworkContext> CONTEXT 
                       = new ThreadLocal<>();    // (1)

    void serve(Request request, Response response) {
        var context = createContext(request);
        CONTEXT.set(context);                    // (2)
        application.handle(request, response);
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
