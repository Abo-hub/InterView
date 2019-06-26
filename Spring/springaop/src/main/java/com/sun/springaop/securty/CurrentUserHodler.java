package com.sun.springaop.securty;

public class CurrentUserHodler {

    private static final ThreadLocal<String> holer = new ThreadLocal<>();

    public static String get() {
        return holer.get() == null ? "unkown" : holer.get();
    }

    public static void set(String user){
        holer.set(user);
    }
}
