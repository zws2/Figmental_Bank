package com.company;

import java.util.HashMap;

public class LoginCred {

    HashMap<String, String> loginInfo = new HashMap<>();

    public LoginCred() {
        loginInfo.put("Batman", "I'mBatman");
        loginInfo.put("Robin", "loser");
        loginInfo.put("Eileen", "rawr");
    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}

