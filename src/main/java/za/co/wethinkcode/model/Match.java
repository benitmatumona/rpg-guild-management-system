package za.co.wethinkcode.model;

public class Match {

    public enum MatchStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
    private int matchId;
    private int memberId1;
    private int memberId2;
    private int winnerId;
    private MatchStatus status;

    public Match(int matchId, int memberId1, int memberId2) {
        this.matchId = matchId;
        this.memberId1 = memberId1;
        this.memberId2 = memberId2;
        this.status = MatchStatus.PENDING;
        this.winnerId = -1;
    }

    public int getMatchId() {
        return matchId;
    }

    public int getMemberId1() {
        return memberId1;
    }

    public int getMemberId2() {
        return memberId2;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public MatchStatus getStatus() {
        return status;
    }
    

    public void setWinner(int winnerId){
        this.winnerId = winnerId;
    }
    // - set winnerId
    // - update status logic handled in service layer
    public void updateStatus(MatchStatus status){
        this.status = status;
    }

    // TODO: toString()
    // Example:
    @Override
    public String toString(){
        return "Match "+ ": " +  this.matchId +  ": " + this.memberId1 + " vs " + this.memberId2 + "| " + this.status + "| "+  "Winner: " +winnerId;
    }
    // Match 1: 10 vs 12 | COMPLETED | Winner: 10
}