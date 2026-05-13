// FILE: src/main/java/za/co/wethinkcode/service/PvEGuildSystem.java

package za.co.wethinkcode.service;

import za.co.wethinkcode.model.Match;

public class PvEGuildSystem extends GuildSystem {

    // TODO: constructor
    // PvEGuildSystem(String guildName)
    // - call super(guildName)

    // =========================
    // MATCH RESOLUTION RULES
    // =========================

    // TODO: implement resolveMatch(Match match)
    //
    // PvE rules (simple simulation expected in tests):
    //
    // - Player 1 is the "player"
    // - Player 2 is the "enemy"
    //
    // - Player always wins if their level >= enemy level
    // - otherwise enemy wins
    //
    // - Update match with winnerId
    // - Print:
    //   "PvE Match resolved: Winner is Member <id>"
}