package ru.geekbrains.lesson2;

public class ExceptionLesson {

    public static int summator(int[][] IntArray) throws MyArraySizeException
    {
        //check size
        if(IntArray.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < 4; i++) {
            if(IntArray[i].length != 4){
                throw new MyArraySizeException();
            }
        }



        return 0;
    }
}
