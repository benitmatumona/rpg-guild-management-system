package za.co.wethinkcode.service;

import za.co.wethinkcode.model.*;

import java.util.*;

public abstract class GuildSystem {

    private String guildName;
    private List<Player> members;
    private List<Match> matchQueue;
    private int memberConter;

    public GuildSystem(String guildName) {
        this.guildName = guildName;
        this.members = new ArrayList<>();
        this.matchQueue = new ArrayList<>();
        this.memberConter = 0;
    }

    // =========================
    // CORE METHODS
    // =========================

    public void addMember(Player member){
        this.members.add(member);
    }

    public boolean removeMemberById(int id){
        return members.removeIf(member -> member.getId() == id);
    }

    public Player getMemberById(int id){
        for (Player member: members){
            if(member.getId() == id){
                return member;
            }
        }
        return null;
    }

    public List<Player> getAllMembers(){
        return Collections.unmodifiableList(this.members);
    }
    // - return unmodifiable list

    public Match createMatch(int memberId1, int memberId2){
        memberConter ++;
        Match match = new Match(this.memberConter,memberId1, memberId2);
        matchQueue.add(match);
        return  match;
    }

    public Match processNextMatch(){
        for (Match match : matchQueue){
            if (match.getStatus() == Match.MatchStatus.PENDING){
                match.updateStatus(Match.MatchStatus.IN_PROGRESS);
                resolveMatch(match);
                match.updateStatus(Match.MatchStatus.COMPLETED);
            }

            return match;
        }
        return null;
    }
    // - find next PENDING match
    // - set IN_PROGRESS
    // - call abstract resolveMatch(match)
    // - set COMPLETED
    // - return match
    // - return null if none

    public List<Match> matchQueue() {
        return Collections.unmodifiableList(this.matchQueue);
    }
    // - return unmodifiable list

    public String guildName(){
        return this.guildName;
        }
    // - return name

    // =========================
    // ABSTRACT BEHAVIOUR
    // =========================

    // Each subclass defines how a match is resolved
    protected abstract void resolveMatch(Match match);
}