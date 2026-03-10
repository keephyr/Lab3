package objects;

import interfaces.Payable;
import interfaces.Trainable;

public class Player extends Member implements Payable, Trainable {
    private String position;
    private int number;

    public Player(String name, String team, int exp,int age, String position, int number) {
        super(name, team, exp,age);
        this.setRole("player");
        this.position = position;
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + " - Player{" +
                "position='" + position + '\'' +
                ", number=" + number +
                "} ";
    }

    @Override
    public void TrainMember(int day, int month, int year) {
        System.out.println("Игрок " + this.getName() + " потренировался ("+day+"/"+month+"/"+year+")");
    }
    @Override
    public void PayMember() {
        System.out.println("Игроку " + this.getName() + " заплатили");
    }
    @Override
    public boolean isTrainable() {
        return true;
    }
    @Override
    public boolean isPayable() {
        return true;
    }

}
