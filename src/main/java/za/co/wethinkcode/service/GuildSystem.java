package za.co.wethinkcode.service;

import za.co.wethinkcode.model.*;

import java.util.*;

public abstract class GuildSystem {

    // TODO: declare private fields:
    // guildName (String)
    // members (List<GuildMember>)
    // matchQueue (List<Match>)
    // memberCounter (int)

    // TODO: constructor:
    // GuildSystem(String guildName)
    // - initialise lists
    // - set memberCounter = 0

    // =========================
    // CORE METHODS
    // =========================

    // TODO: addMember(GuildMember member)
    // - add to list

    // TODO: removeMemberById(int id)
    // - remove member if found
    // - return true/false

    // TODO: getMemberById(int id)

    // TODO: getAllMembers()
    // - return unmodifiable list

    // TODO: createMatch(int memberId1, int memberId2)
    // - increment counter
    // - create Match object
    // - add to queue
    // - return Match

    // TODO: processNextMatch()
    // - find next PENDING match
    // - set IN_PROGRESS
    // - call abstract resolveMatch(match)
    // - set COMPLETED
    // - return match
    // - return null if none

    // TODO: matchQueue()
    // - return unmodifiable list

    // TODO: guildName()
    // - return name

    // =========================
    // ABSTRACT BEHAVIOUR
    // =========================

    // Each subclass defines how a match is resolved
    protected abstract void resolveMatch(Match match);
}