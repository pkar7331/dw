package com.siseth.dw.helloworld.ManagedObject;

import com.siseth.dw.helloworld.config.HelloWorldConfiguration;

public class RandomClass {

    public RandomClass(HelloWorldConfiguration configuration) {
    }

    public void start(){
        System.out.println("\nstart app\n");
    }
    public void stop(){
        System.out.println("shutdown app");
    }
}
