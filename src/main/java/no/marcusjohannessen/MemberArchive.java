package no.marcusjohannessen;

import java.time.LocalDate;
import java.util.HashMap;


public class MemberArchive {
    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    /**
     * Adds a new member to the register. The new member must have a memebr number
     * different from exsisting members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          membernumber that allready exsists.
     */
    public boolean addMember(BonusMember bonusMember) {
        boolean success = false;
        if(!members.containsKey(bonusMember.getMemberNumber())){
            members.put(bonusMember.getMemberNumber(),bonusMember);
            success = true;
        }
        return success;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code flase} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        boolean success = false;
        if(members.containsKey(memberNumber)){
            members.get(memberNumber).registerBonusPoints(bonusPoints);
            success = true;
        }
        return success;
    }

    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        System.out.println(members);
    }

    /**
     *
     * @param memberNumber
     * @param password
     * @return amounts of points for a member if right password it typed
     */
    public int findPoints(int memberNumber ,String password){
        if(password.equals("marcus123")){
            if(members.containsKey(memberNumber)){
                return members.get(memberNumber).getBonusPointBalance();
            }else{
                return -1;
            }
        }
        return -1;
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com");
        this.members.put(member.getMemberNumber(), member);

    }

    @Override
    public String toString() {
        return
                "\n\nmembers=" + members;
    }
}
