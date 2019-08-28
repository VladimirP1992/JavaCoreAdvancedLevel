package ru.geekbrains.lesson2;

public class ExceptionLesson {

    public static int summator(String[][] StringArray) throws MyArraySizeException, MyArrayDataException, Exception
    {
        final int PREFERRED_SIZE = 4;
        //Проверить размер полученного массива
        if(StringArray.length != PREFERRED_SIZE) {
            throw new MyArraySizeException("Размер массива String не равен " + PREFERRED_SIZE);
        }
        for (int i = 0; i < PREFERRED_SIZE; i++) {
            if(StringArray[i].length != PREFERRED_SIZE){
                throw new MyArraySizeException("Размер массива String["+ i +"] не равен " + PREFERRED_SIZE);
            }
        }

        //Преобразовать массив строк в массив целых чисел и проссумировать его элементы
        int sum = 0;
        int[][] IntArray = new int[PREFERRED_SIZE][PREFERRED_SIZE];

        for (int i = 0; i < PREFERRED_SIZE; i++)
            for (int j = 0; j < PREFERRED_SIZE; j++){
                try {
                    IntArray[i][j] = Integer.parseInt(StringArray[i][j]);
                    sum += IntArray[i][j];
                }
                catch (NumberFormatException e){
                    String message = "Не удалось преобразовать в int " +
                            "элемент массива String из ячейки ["+i+"]["+j+"]";
                    throw new MyArrayDataException(message);
                }
                catch (Exception e) {
                    throw e;
                }

            }
        /**/

        return sum;
    }
}
