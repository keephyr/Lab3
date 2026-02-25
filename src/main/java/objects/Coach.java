package objects;

public class Coach extends Member{
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
}
