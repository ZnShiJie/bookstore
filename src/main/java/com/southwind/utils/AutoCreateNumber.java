package com.southwind.utils;

import java.util.UUID;

public class AutoCreateNumber {


    public static String createOrderNumber() {

        System.out.println("hello");

        return UUID.randomUUID().toString();


    }
}
