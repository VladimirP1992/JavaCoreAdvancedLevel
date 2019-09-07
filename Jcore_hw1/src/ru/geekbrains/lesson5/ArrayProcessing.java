package ru.geekbrains.lesson5;

public class ArrayProcessing {

    public static float equationCalc(float floatArg, int intArg){
        float resalt = (float)(floatArg * Math.sin(0.2f + intArg / 5) * Math.cos(0.2f + intArg / 5) * Math.cos(0.4f + intArg / 2));
        return resalt;
    }

    public  long refillArrInOneThread(float[] floatArr){
        long begin = System.currentTimeMillis();

        int arrLength = floatArr.length;
        for (int i = 0; i < arrLength; i++){
            floatArr[i] = equationCalc(floatArr[i], i);
        }

        return (System.currentTimeMillis() - begin);
    }
}
