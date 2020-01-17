package com.google.www.util;

import java.util.Random;

/**
 *
 * Clase que retorna un valor entero aleatorio entre 0 y un rango superior.
 *
 */
public class RandomValue {

    public int getRandomValue(int superiorRange){
        return new Random().nextInt(superiorRange);
    }
}
