package no.marcusjohannessen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MembertArchiveClientTest {


    @Nested
    class AsserterTrue{
        //Oppretter en instans av MemberArchive
        BonusMember member = new BonusMember(6, LocalDate.now(),"Lisa","lisa@mail");
        MemberArchive mem = new MemberArchive();

        @Test
        @DisplayName("To see if the methods will return true")
        public void addMemberThatShouldReturnTrue(){
            assertTrue(mem.addMember(member));
        }

        @Test
        @DisplayName("If it is possible to registrer bonuspoints for a member")
        public void registerBonusPointsThatShouldReturnTrue(){
            assertTrue(mem.registerPoints(3,500));
        }

        @Test
        @DisplayName("Sjekker om Den er silver member, setter poeng til 30.000")
        public void checkToSeIfMembershipEqualsSilver(){
            //Ny member
            BonusMember m = new BonusMember(9, LocalDate.now(),"Lisa","lisa@mail");
            //lager et nytt memberarchive (Hashmap)
            MemberArchive mem = new MemberArchive();
            //legger member m til i arkivet
            mem.addMember(m);
            //registrerer 30.000 poeng (silver er grense over 25.000)
            m.registerBonusPoints(30_000);
            //Sjekker om type medlemskap er det samme som jeg forventer
            assertEquals("Silver",m.getMembershipLevel());
        }
    }
    @Nested
    class AssertFalse{
        BonusMember members = new BonusMember(3, LocalDate.now(),"John","lisa@mail");
        MemberArchive meme = new MemberArchive();

        @Test
        @DisplayName("Should not be able to register a member that allready exsists")
        public void registerMemberWithMemberNumberThatAlreadyExsistis(){
            assertFalse(meme.addMember(members));
        }

        @Test
        @DisplayName("Check if you can register points on a member that do not exsists")
        public void registerPointsOnAMemberThatDoNotExsists(){
            assertFalse(meme.registerPoints(40,40000));
        }
    }
}
