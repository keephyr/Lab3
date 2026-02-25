package objects;

import interfaces.Raisable;

public class Manager extends Member implements Raisable {
    private String contact;
    private String position;

    public Manager(String name, String team, int exp,int age, String contact) {
        super(name, team, exp,age);
        this.setRole("manager");
        this.contact = contact;
        this.position = "junior";
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return super.toString() + " - Manager{" +
                "contact='" + contact + '\'' +
                "} ";
    }

    @Override
    public void raiseMember() {
        position = positions.get(positions.indexOf(position)+1);
    }

    @Override
    public void lowerMember() {
        position = positions.get(positions.indexOf(position)-1);
    }

    @Override
    public void showPosition() {
        System.out.println(this.position);
    }
}
