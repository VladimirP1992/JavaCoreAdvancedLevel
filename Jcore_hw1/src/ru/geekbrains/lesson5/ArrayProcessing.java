package ru.geekbrains.lesson5;

public class ArrayProcessing {

    public static float equationCalc(float floatArg, int intArg){
        float resalt = (float)(floatArg * Math.sin(0.2f + intArg / 5) * Math.cos(0.2f + intArg / 5) * Math.cos(0.4f + intArg / 2));
        return resalt;
    }

    public static long refillArrInOneThread(float[] floatArr){
        long begin = System.currentTimeMillis();

        int size = floatArr.length;
        for (int i = 0; i < size; i++){
            floatArr[i] = equationCalc(floatArr[i], i);
        }

        return (System.currentTimeMillis() - begin);
    }

    public static long refillArrInTwoThreads(float[] floatArr){
        long begin = System.currentTimeMillis();

        int size = floatArr.length;
        int size1 = size / 2;
        int size2 = size - size1;

        float[] floatArr1 = new float[size1];
        float[] floatArr2 = new float[size2];

        System.arraycopy(floatArr, 0, floatArr1, 0, size1);
        System.arraycopy(floatArr, 0, floatArr2, 0, size2);

        Thread t1 = new Thread(()->{
            refillArrInOneThread(floatArr1);
        });
        Thread t2 = new Thread(()->{
            refillArrInOneThread(floatArr2);
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


        System.arraycopy(floatArr1, 0, floatArr, 0, size1);
        System.arraycopy(floatArr2, 0, floatArr, size1, size2);

        return (System.currentTimeMillis() - begin);
    }
}
