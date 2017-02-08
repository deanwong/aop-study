package com.deanwangpro.aop;

import com.deanwangpro.aop.cglib.CGLibProxy;
import com.deanwangpro.aop.jdkproxy.DynamicProxy;
import com.deanwangpro.aop.service.Person;
import com.deanwangpro.aop.service.PersonImpl;
import com.deanwangpro.aop.service.Speakable;

/**
 * Created by i311609 on 08/02/2017.
 */
public class PersonProxyFactory {

    public static Speakable newJdkProxy() {
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        Speakable proxy = dynamicProxy.getProxy();
        return proxy;
    }

    public static Person newCglibProxy() {
        CGLibProxy cglibProxy = CGLibProxy.getInstance();
        Person proxy = cglibProxy.getProxy(Person.class);
        return proxy;
    }

}
