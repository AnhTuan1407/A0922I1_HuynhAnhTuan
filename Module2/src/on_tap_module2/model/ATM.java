package on_tap_module2.model;

public class ATM extends Card{
    private double surplus;

    public ATM() {
    }

    public ATM(String numCard, String nameCard, String identityCard, String address, double surplus) {
        super(numCard, nameCard, identityCard, address);
        this.surplus = surplus;
    }

    public double getSurplus() {
        return surplus;
    }

    public void setSurplus(double surplus) {
        this.surplus = surplus;
    }

    @Override
    public String toString() {
        return super.toString() + "ATM{" +
                "surplus=" + surplus +
                '}';
    }

    public void input()
    {
        super.input();
    }
}
