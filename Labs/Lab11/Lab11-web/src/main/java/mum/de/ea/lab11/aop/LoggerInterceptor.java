/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab11.aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author tuvshuu
 */
public class LoggerInterceptor {

    Logger logger = LogManager.getLogger(LoggerInterceptor.class);

    @AroundInvoke
    private Object logMethod(InvocationContext ic) throws Exception {
        logger.info("%s %s is being called.", new Object[]{ic.getTarget().toString(), ic.getMethod().getName()});
        try {
            return ic.proceed();
        } finally {
            logger.info("%s %s has been called.", new Object[]{ic.getTarget().toString(), ic.getMethod().getName()});
        }
    }
}
