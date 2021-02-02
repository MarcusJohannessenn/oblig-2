package no.marcusjohannessen;

public class GoldMembership extends Membership {

    private final float POINTS_SCALING_FACTOR_LEVEL_1;
    private final float POINTS_SCALING_FACTOR_LEVEL_2;

    public GoldMembership() {
        super("Gold");
        this.POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
        this.POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;
    }

    @Override
    public int registrerPoints(int bonusPointBalance, int newPoints) {
        if(bonusPointBalance < 90_000){
            newPoints*= POINTS_SCALING_FACTOR_LEVEL_1;
        }else{
            newPoints *= POINTS_SCALING_FACTOR_LEVEL_2;
        }

        return super.registrerPoints(bonusPointBalance, newPoints);
    }

    @Override
    public String getMembershipName() {
        return super.getMembershipName();
    }
}
