package com.google.www.util;

import java.util.Random;

public class RandomValue {

    public int getRandomValue(int superiorRange){
        int r=new Random().nextInt(superiorRange);
        System.out.println(r);
        return r;
    }
}
