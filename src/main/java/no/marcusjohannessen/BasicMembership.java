package no.marcusjohannessen;

public class BasicMembership extends Membership{

    protected BasicMembership(){
        super("Basic");
    }

    @Override
    public int registrerPoints(int bonusPointBalance, int newPoints) {
        return super.registrerPoints(bonusPointBalance, newPoints);
    }

    @Override
    public String getMembershipName() {
        return super.getMembershipName();
    }
}
