package za.co.wethinkcode.service;

import za.co.wethinkcode.model.Match;
import za.co.wethinkcode.model.Player;

public class PvPGuildSystem extends GuildSystem {

    public PvPGuildSystem(String guildName) {
        super(guildName); // Invokes the abstract parent constructor
    }

    // =========================
    // MATCH RESOLUTION RULES
    // =========================

    @Override
    protected void resolveMatch(Match match) {
        Player member1 = getMemberById(match.getMemberId1());
        Player member2 = getMemberById(match.getMemberId2());


        if (member1 == null || member2 == null) {
            return;
        }

        int winnerId;

        if (member1.getLevel() >= member2.getLevel()) {
            winnerId = member1.getId();
        } else {
            winnerId = member2.getId();
        }

        match.setWinner(winnerId);

        System.out.println("PvP Match resolved: Winner is Member " + winnerId);
    }
}