package com.yang.crm.commons.utlis;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
