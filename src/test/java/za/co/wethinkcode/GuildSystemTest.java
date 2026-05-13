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

        GuildMember member = new GuildMember(1, "Arthur", 10);
        guild.addMember(member);

        assertNotNull(guild.getMemberById(1));
        assertEquals("Arthur", guild.getMemberById(1).getName());
    }

    @Test
    void testRemoveMember() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        guild.addMember(new GuildMember(1, "Arthur", 10));

        assertTrue(guild.removeMemberById(1));
        assertFalse(guild.removeMemberById(1));
    }

    @Test
    void testCreateMatch() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        guild.addMember(new GuildMember(1, "Arthur", 10));
        guild.addMember(new GuildMember(2, "Lancelot", 12));

        Match match = guild.createMatch(1, 2);

        assertNotNull(match);
        assertEquals(1, match.getMemberId1());
        assertEquals(2, match.getMemberId2());
    }

    @Test
    void testProcessNextMatchPvP() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        guild.addMember(new GuildMember(1, "Arthur", 10));
        guild.addMember(new GuildMember(2, "Lancelot", 12));

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

        guild.addMember(new GuildMember(1, "Arthur", 10));

        assertThrows(UnsupportedOperationException.class, () -> {
            guild.getAllMembers().add(new GuildMember(2, "Fake", 1));
        });
    }

    @Test
    void testGuildName() {
        PvPGuildSystem guild = new PvPGuildSystem("Knights");

        assertEquals("Knights", guild.guildName());
    }
}