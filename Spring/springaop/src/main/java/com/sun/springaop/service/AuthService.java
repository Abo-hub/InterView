package com.sun.springaop.service;

import com.sun.springaop.securty.CurrentUserHodler;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    public void checkAccess(){
        String user = CurrentUserHodler.get();
        if(!"admin".equals(user)){
            throw new RuntimeException("operation not allow");
        }
    }
}
