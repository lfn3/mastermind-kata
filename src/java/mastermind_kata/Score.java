package mastermind_kata;

public class Score {
    public final int exactMatches;
    public final int inexactMatches;

    public Score(int exactMatches, int nearMatches) {
        this.exactMatches = exactMatches;
        this.inexactMatches = nearMatches;
    }
}
