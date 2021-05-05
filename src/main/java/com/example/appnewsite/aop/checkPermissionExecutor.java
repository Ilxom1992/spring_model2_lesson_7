package com.example.appnewsite.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class checkPermissionExecutor {
    @Before(value = "@annotation(checkPermission)")
    public void checkPermissionMyMethod(checkPermission checkPermission){

    }
}
