package ru.geekbrains.jcorehw1;

import ru.geekbrains.lesson2.*;

public class Main {

    public static void main(String[] args) {
        //Создадим ситуацию с недопустимым размером массива
        String[][] strArr = new String[3][5];
        try {
            ExceptionLesson.summator(strArr);
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        //Заполним массив числами в строковом представлении без ошибок
        strArr = new String[4][4];
        for (int i = 0; i < strArr.length; i++)
            for(int j = 0; j< strArr[i].length; j++) {
                strArr[i][j] = String.valueOf(i+j);
            }
        try {
            int sum = ExceptionLesson.summator(strArr);
            System.out.println("Сумма элементов массива в числовом представлении = " + sum);
        }
        catch (Exception e) {
            System.out.println("Это сообщение не должно выводиться");
        }

        System.out.println();
        //Вводим в массив недопустимый элемент
        strArr[2][1] = "asdfsd";
        try {
            ExceptionLesson.summator(strArr);
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

/*lesson1
Human human = new Human(10, 10);
        Cat cat = new Cat(8, 8);
        Robot robot = new Robot(5, 5);

        Moveable[] competitors = new Moveable[] {human, cat, robot};
        Obstacle[] obstacles = new Obstacle[]{
                new Treadmill(4), new Wall(4),
                new Treadmill(6), new Wall(5),
                new Treadmill(8), new Wall(9)};

        for (Obstacle obstacle : obstacles){
            for(Moveable competitor : competitors){
                if(obstacle instanceof Wall){
                    competitor.jump((Wall)obstacle);
                }
                else
                    competitor.run((Treadmill)obstacle);
            }
            System.out.println();
        }

        for (Moveable mov : competitors) {
            mov.info();
        }
 */