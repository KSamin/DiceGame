import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    public Player player;

    @Test
    public void testInitialShareValue() {
        Player player = new Player("Test Player", 100);
        assertEquals(100, player.getShareValue());
    }

    @Test
    public void testReduceShareValue() {
        Player player = new Player("Test Player", 100);
        player.reduceShareValue(20);
        assertEquals(80, player.getShareValue());

        player.reduceShareValue(90);
        assertEquals(0, player.getShareValue());
    }

    @Test
    public void testIsDefeated() {
        Player player = new Player("Test Player", 100);
        assertFalse(player.isDefeated());

        player.reduceShareValue(100);
        assertTrue(player.isDefeated());
    }

    @Test
    public void testRollDice() {
        Player player = new Player("Test Player", 100);
        int diceValue = player.rollDice();
        assertTrue(diceValue >= 1 && diceValue <= 6);
    }
}
