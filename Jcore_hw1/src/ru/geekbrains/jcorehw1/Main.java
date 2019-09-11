package ru.geekbrains.jcorehw1;


import ru.geekbrains.lesson5.ArrayProcessing;

public class Main {

    public static void main(String[] args) {
        final int size = 10000000;
        float[] floatArr = new float[size];

        System.out.println("Массив перезаполнен в одном потоке за "+ ArrayProcessing.refillArrInOneThread(floatArr) +" миллисекунд");
        System.out.println("Массив перезаполнен в одном потоке за "+ ArrayProcessing.refillArrInTwoThreads(floatArr) +" миллисекунд");
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

/*lesson 2
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
 */
/*//lesson 3
//Задание1 - подсчет имен
String[] names = new String[]{"Вова","Коля","Маша","Вова","Вася","Дима","Маша","Олег","Маша","Вика"};

    HashMap<String, Integer> namesMap = new HashMap<>();
        for (String str : names) {
                if (namesMap.containsKey(str)){
                namesMap.put(str, namesMap.get(str) + 1);
                }
                else {
                namesMap.put(str, 1);
                }
                }
                System.out.println(namesMap);
                System.out.println();

                //Задание 2 - телефонный справочник
                Phonebook phonebook = new Phonebook();
                phonebook.add("Иванов", "8 903 552 45 11");
                //Дубликат телефона не будет добавлен
                phonebook.add("Иванов", "8 903 552 45 11");
                phonebook.add("Петров", "8 914 445 22 01");
                phonebook.add("Петров", "8 901 666 13 13");

                phonebook.get("Иванов");
                phonebook.get("Петров");
                phonebook.get("Сидоров");*/