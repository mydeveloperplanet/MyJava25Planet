package com.mydeveloperplanet.myjava25planet.scopedvalues;

public class Application {

    Framework framework = new Framework(this);

    //@Override
    public void handle(Request request, Response response) {
        // user code, called by framework
        var userInfo = readUserInfo();

    }

    private UserInfo readUserInfo() {
        // call framework
        return (UserInfo) framework.readKey("userInfo");
    }

}