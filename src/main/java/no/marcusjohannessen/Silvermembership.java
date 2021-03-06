package no.marcusjohannessen;

public class Silvermembership extends Membership {
    private final float POINTS_SCALING_FACTORE;

    //Protected slik at bare klassene i samme
    protected Silvermembership() {
        super("Silver");
        this.POINTS_SCALING_FACTORE = 1.2f;
    }

    @Override
    public int registrerPoints(int bonusPointBalance, int newPoints) {
        newPoints*= POINTS_SCALING_FACTORE;
        return Math.round(super.registrerPoints(bonusPointBalance, newPoints));
    }

    @Override
    public String getMembershipName() {
        return super.getMembershipName();
    }
}
