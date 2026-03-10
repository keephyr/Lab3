package objects;

import interfaces.Payable;

public class Coach extends Member implements Payable {
    private int amountOfPeople;
    private String type;

    public Coach(String name, String team, int exp,int age, int amountOfPeople, String type) {
        super(name, team, exp, age);
        this.setRole("coach");
        this.amountOfPeople = amountOfPeople;
        this.type = type;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " - Coach{" +
                "amountOfPeople=" + amountOfPeople +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void PayMember() {
        System.out.println("Тренеру " + this.getName() + " заплатили");
    }
    @Override
    public boolean isPayable() {
        return true;
    }
    public boolean isTrainable() {
        return false;
    }
}
