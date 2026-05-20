// FILE: src/main/java/za/co/wethinkcode/service/PvEGuildSystem.java

package za.co.wethinkcode.service;

import za.co.wethinkcode.model.*;

import za.co.wethinkcode.service.*;

public class PvEGuildSystem extends GuildSystem {


    public PvEGuildSystem(String guildName) {
        super(guildName);
    }


    // =========================
    // MATCH RESOLUTION RULES
    // =========================

    @Override
    public void resolveMatch(Match match){

        Player player = getMemberById(match.getMemberId1());
        Player enemy = getMemberById(match.getMemberId2());

        if(player == null || enemy == null){
            return;
        }
        int winnerId;
        if (player.getLevel() >= enemy.getLevel()) {
            winnerId = player.getId();
        } else {
            winnerId = enemy.getId();
        }

        match.setWinner(winnerId);

        System.out.println("PvE Match resolved: Winner is Member " + winnerId);
    }
    }
