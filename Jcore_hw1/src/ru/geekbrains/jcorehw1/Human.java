package ru.geekbrains.jcorehw1;

public class Human implements Moveable {
    int jumpSkill;
    int runSkill;
    boolean canMove;

    public Human(int jumpSkill, int runSkill){
        this.jumpSkill = jumpSkill;
        this.runSkill = runSkill;
        canMove = true;
    }

    @Override
    public void jump(Wall wall) {
        if(!canMove){
            System.out.println("Человек застрял где-то позади");
        }
        else if(wall.getHeight() > jumpSkill){
            System.out.println("Человек не смог перепрыгнуть");
            canMove = false;
        }
        else
            System.out.println("Человек перепрыгнул препятствие");
    }

    @Override
    public void run(Treadmill treadmill) {
        if(!canMove){
            System.out.println("Человек застрял где-то позади");
        }
        else if(treadmill.getLength() > runSkill){
            System.out.println("Человек не смог перебежать");
            canMove = false;
        }
        else
            System.out.println("Человек пробежал необходимое расстояние");
    }

    @Override
    public void info() {
        System.out.println("Способность человека двигаться дальше = " + canMove);
    }
}
