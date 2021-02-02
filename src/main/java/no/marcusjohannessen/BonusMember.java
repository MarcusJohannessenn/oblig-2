package no.marcusjohannessen;

import java.time.LocalDate;

/**
 * @author marcusjohannessen
 *
 */

public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointBalance;
    private String name;
    private String emailAdress;
    private String password;
    private final int SILVER_LIMIT;
    private final int GOLD_LIMIT;
    private Membership membership;

    //Constructor if bonusPointBalance it not chosen
    public BonusMember(int memberNumber, LocalDate enrolledDate, String name, String emailAdress) {
        this(memberNumber, enrolledDate, 0, name, emailAdress);

    }
    //Main Constructor
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointBalance, String name, String emailAdress) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointBalance = bonusPointBalance;
        this.name = name;
        this.emailAdress = emailAdress;
        this.SILVER_LIMIT = 25_000;
        this.GOLD_LIMIT = 75_000;
    }

    public int getBonusPointBalance() {
        return bonusPointBalance;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public boolean checkPassword(String password){
        if(this.password.equals(password)){
            return true;
        }else{
            return false;
        }
    }

    //hvordan får jeg til å legge til bonuspoints med bonusPointBalan
    public void registerBonusPoints(int newPoints){
        if(newPoints < 0){
            throw new IllegalArgumentException("Ny poeng kan ikke være negativ");
        }
        if(bonusPointBalance < SILVER_LIMIT){
            membership = new BasicMembership();
            this.bonusPointBalance = membership.registrerPoints(bonusPointBalance, newPoints);
        }
        else if(bonusPointBalance < GOLD_LIMIT){
            membership = new Silvermembership();
            this.bonusPointBalance = membership.registrerPoints(bonusPointBalance, newPoints);
        }
        else {
            membership = new GoldMembership();//og det økes med 30% eller 50% fikses i Goldmembership-klassen
            this.bonusPointBalance = membership.registrerPoints(bonusPointBalance, newPoints);
        }
    }

    public String getMembershipLevel(){
        //Overrider i Membership-klassen
        if(bonusPointBalance < SILVER_LIMIT){
            membership = new BasicMembership();
            return membership.getMembershipName();
        }
        else if(bonusPointBalance < GOLD_LIMIT){
            membership = new Silvermembership();
            return membership.getMembershipName();
        }
        else {
            membership = new GoldMembership();//og det økes med 30% eller 50% fikses i Goldmembership-klassen
            return membership.getMembershipName();
        }
    }

    //trenger ikke denne for navnet blir settet i subklassene
    private void checkAndSetMembership(){

    }

    @Override
    public String toString() {
        return "\n\n======= Membernumber: " + memberNumber + " =========" +
                "\nenrolledDate = " + enrolledDate +
                "\nbonusPointBalance = " + bonusPointBalance +
                "\nname = " + name + '\'' +
                "\nemailAdress = " + emailAdress + '\'' +
                "\npassword = " + password + '\'' +
                "\nmembership = " + getMembershipLevel();
    }
}
