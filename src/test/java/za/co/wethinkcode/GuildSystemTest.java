// FILE: src/test/java/za/co/wethinkcode/GuildSystemTest.java

package za.co.wethinkcode;

import za.co.wethinkcode.model.*;
import za.co.wethinkcode.service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuildSystemTest {

    @Test
    void testAddAndRetrieveMember() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        // Replacing GuildMember with Player
        Player member = new Player(1, "Arthur");
        guild.addMember(member);

        assertNotNull(guild.getMemberById(1));
        assertEquals("Arthur", guild.getMemberById(1).getName());
    }

    @Test
    void testRemoveMember() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        // Replacing GuildMember with Player
        guild.addMember(new Player(1, "Arthur"));

        assertTrue(guild.removeMemberById(1));
        assertFalse(guild.removeMemberById(1));
    }

    @Test
    void testCreateMatch() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        // Creating Players and adding them to the guild
        Player arthur = new Player(1, "Arthur");
        Player lancelot = new Player(2, "Lancelot");

        guild.addMember(arthur);
        guild.addMember(lancelot);

        Match match = guild.createMatch(1, 2);

        assertNotNull(match);
        assertEquals(1, match.getMemberId1());
        assertEquals(2, match.getMemberId2());
    }

    @Test
    void testProcessNextMatchPvP() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        Player arthur = new Player(1, "Arthur");
        Player lancelot = new Player(2, "Lancelot");

        // Optional: If you want to replicate specific levels from the old test,
        // you can give them experience (e.g., 900 XP to reach Level 10)
        arthur.addExperience(900);
        lancelot.addExperience(1100);

        guild.addMember(arthur);
        guild.addMember(lancelot);

        guild.createMatch(1, 2);

        Match match = guild.processNextMatch();

        assertNotNull(match);
        assertEquals(Match.MatchStatus.COMPLETED, match.getStatus());
        assertTrue(match.getWinnerId() == 1 || match.getWinnerId() == 2);
    }

    @Test
    void testProcessNextMatchPvENoMatch() {
        PvEGuildSystem guild = new PvEGuildSystem("Monsters");

        assertNull(guild.processNextMatch());
    }

    @Test
    void testUnmodifiableMembers() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        guild.addMember(new Player(1, "Arthur"));

        // Verifying that trying to add directly to getAllMembers() throws an exception
        assertThrows(UnsupportedOperationException.class, () -> {
            guild.getAllMembers().add(new Player(2, "Fake"));
        });
    }

    @Test
    void testGuildName() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        assertEquals("Knights", guild.guildName());
    }
}