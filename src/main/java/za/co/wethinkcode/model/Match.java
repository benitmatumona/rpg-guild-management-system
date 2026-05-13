package za.co.wethinkcode.model;

public class Match {

    public enum MatchStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

    // TODO: declare private fields:
    // matchId (int)
    // memberId1 (int)
    // memberId2 (int)
    // winnerId (int)
    // status (MatchStatus)

    // TODO: constructor:
    // Match(int matchId, int memberId1, int memberId2)
    // - set status = PENDING
    // - winnerId = -1 (no winner yet)

    // TODO: getters:
    // int getMatchId()
    // int getMemberId1()
    // int getMemberId2()
    // int getWinnerId()
    // MatchStatus getStatus()

    // TODO: setWinner(int winnerId)
    // - set winnerId
    // - update status logic handled in service layer

    // TODO: updateStatus(MatchStatus status)

    // TODO: toString()
    // Example:
    // Match 1: 10 vs 12 | COMPLETED | Winner: 10
}