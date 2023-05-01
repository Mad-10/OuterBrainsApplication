package com.outerbrains.base.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class PreUpdateAspect {
//    @Before("execution(* com.outerbrains.base.entity.*.update*(..)) && target(com.outerbrains.base.aspect.PreUpdateable)")
    public void preUpdate(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        if (target instanceof PreUpdateable) {
            PreUpdateable preUpdateable = (PreUpdateable) target;
            preUpdateable.preUpdate();
        }
    }
}
