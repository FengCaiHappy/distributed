package com.neusoft.common.uti;

import java.util.UUID;

public class Utils {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
