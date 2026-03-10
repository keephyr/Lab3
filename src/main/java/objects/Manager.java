package objects;

import interfaces.Payable;

public class Manager extends Member implements Payable {
    private String contact;

    public Manager(String name, String team, int exp,int age, String contact) {
        super(name, team, exp,age);
        this.setRole("manager");
        this.contact = contact;
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
                "}";
    }

    @Override
    public void PayMember() {
        System.out.println("Менеджеру " + this.getName() + " заплатили");
    }
    @Override
    public boolean isPayable() {
        return true;
    }
    public boolean isTrainable() {
        return false;
    }
}
