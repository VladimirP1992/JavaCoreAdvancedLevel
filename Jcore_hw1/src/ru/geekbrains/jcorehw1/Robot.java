package ru.geekbrains.jcorehw1;

public class Robot implements Moveable {
    int jumpSkill;
    int runSkill;
    boolean canMove;

    public Robot(int jumpSkill, int runSkill){
        this.jumpSkill = jumpSkill;
        this.runSkill = runSkill;
        canMove = true;
    }

    @Override
    public void jump(Wall wall) {
        if(!canMove){
            System.out.println("Робот застрял где-то позади");
        }
        else if(wall.getHeight() > jumpSkill){
            System.out.println("Робот не смог перепрыгнуть");
            canMove = false;
        }
        else
            System.out.println("Робот перепрыгнул препятствие");
    }

    @Override
    public void run(Treadmill treadmill) {
        if(!canMove){
            System.out.println("Робот застрял где-то позади");
        }
        else if(treadmill.getLength() > runSkill){
            System.out.println("Робот не смог перебежать");
            canMove = false;
        }
        else
            System.out.println("Робот пробежал необходимое расстояние");
    }

    @Override
    public void info() {
        System.out.println("Способность робота двигаться дальше = " + canMove);
    }
}
