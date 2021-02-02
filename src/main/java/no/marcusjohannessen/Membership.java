package no.marcusjohannessen;

public class Membership {
    private String membershipName;

    public Membership(String membershipName){
        this.membershipName = membershipName;
    }

    public int registrerPoints(int bonusPointBalance, int newPoints){
        return bonusPointBalance + newPoints;

    }

    public String getMembershipName(){
        return membershipName;
    }

    @Override
    public String toString() {
        return membershipName;
    }
}
