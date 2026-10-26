class Solution {
    public int findTheWinner(int n, int k) {
        // Josephus recurrence: winner (0-indexed) of i players from the winner of i-1.
        int winner = 0;
        for(int i=2; i<=n; i++){
            winner = (winner + k) % i;
        }
        return winner + 1;
    }
}
