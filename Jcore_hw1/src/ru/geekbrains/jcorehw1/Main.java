package ru.geekbrains.jcorehw1;

public class Main {

    public static void main(String[] args) {

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

    }
}

