package com.deanwangpro.aop.service;

import org.springframework.stereotype.Service;

/**
 * Created by i311609 on 08/02/2017.
 */
@Service
public class PersonSpring implements Speakable {

    @Override
    public void sayHi() {
        try {
            Thread.currentThread().sleep(30);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!");
    }

    @Override
    public void sayBye() {
        try {
            Thread.currentThread().sleep(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!");
    }
}
