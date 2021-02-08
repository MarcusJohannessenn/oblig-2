package no.marcusjohannessen;

public abstract class Membership {
    private String membershipName;

    //Har egentlig ikke noe å si her at den settes som protected
    //fordi alle klassene i denne oppgaven er i samme pakke (no.marcusjohannessen)
    protected Membership(String membershipName){
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
