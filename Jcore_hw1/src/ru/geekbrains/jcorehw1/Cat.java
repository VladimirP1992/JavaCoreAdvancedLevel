package ru.geekbrains.jcorehw1;

public class Cat implements Moveable{
    int jumpSkill;
    int runSkill;
    boolean canMove;

    public Cat(int jumpSkill, int runSkill){
        this.jumpSkill = jumpSkill;
        this.runSkill = runSkill;
        canMove = true;
    }

    @Override
    public void jump(Wall wall) {
        if(!canMove){
            System.out.println("Кот застрял где-то позади");
        }
        else if(wall.getHeight() > jumpSkill){
            System.out.println("Кот не смог перепрыгнуть");
            canMove = false;
        }
        else
            System.out.println("Кот перепрыгнул препятствие");
    }

    @Override
    public void run(Treadmill treadmill) {
        if(!canMove){
            System.out.println("Кот застрял где-то позади");
        }
        else if(treadmill.getLength() > runSkill){
            System.out.println("Кот не смог перебежать");
            canMove = false;
        }
        else
            System.out.println("Кот пробежал необходимое расстояние");
    }

    @Override
    public void info() {
        System.out.println("Способность кота двигаться дальше = " + canMove);
    }
}
