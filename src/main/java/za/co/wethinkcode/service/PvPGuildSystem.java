// FILE: src/main/java/za/co/wethinkcode/service/PvPGuildSystem.java

package za.co.wethinkcode.service;

import za.co.wethinkcode.model.Match;

public class PvPGuildSystem extends GuildSystem {

    // TODO: constructor
    // PvPGuildSystem(String guildName)
    // - call super(guildName)

    // =========================
    // MATCH RESOLUTION RULES
    // =========================

    // TODO: implement resolveMatch(Match match)
    // PvP rules (simple simulation logic expected in tests):
    //
    // - Determine winner based on member levels or random rule (depending on tests)
    // - If member1 level >= member2 level -> member1 wins
    // - otherwise member2 wins
    //
    // - Update match with winnerId
    // - Print:
    //   "PvP Match resolved: Winner is Member <id>"
}