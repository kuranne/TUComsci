// Wirakorn Thanabat
// 6809617415

package one.player;

public class ComputerPlayer extends PlayerData{
    public ComputerPlayer(TYPE playerType) {
        setPlayerType(playerType);
    }
    @Override
    public Dimension choose(Dimension range) {
        return new Dimension(rand.nextInt(range.row()), rand.nextInt(range.col()));
    }
}
