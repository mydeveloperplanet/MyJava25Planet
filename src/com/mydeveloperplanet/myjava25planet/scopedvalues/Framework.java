package com.mydeveloperplanet.myjava25planet.scopedvalues;

public class Framework {

    private final Application application;

    public Framework(Application app) { this.application = app; }
    
    private static final ThreadLocal<FrameworkContext> CONTEXT 
                       = new ThreadLocal<>();    // (1)

    void serve(Request request, Response response) {
        var context = createContext(request);
        CONTEXT.set(context);                    // (2)
        Application.handle(request, response);
    }

    public PersistedObject readKey(String key) {
        var context = CONTEXT.get();              // (3)
        var db = getDBConnection(context);
        db.readKey(key);
    }

}