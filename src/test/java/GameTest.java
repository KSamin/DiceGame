import org.example.Game;
import org.example.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

public class GameTest {

    private Player playerA;
    private Player playerB;
    private Game game;

    @BeforeEach
    public void setUp() {
        playerA = Mockito.spy(new Player("Player A", 100));
        playerB = Mockito.spy(new Player("Player B", 100));
        game = new Game(playerA, playerB);
    }

    @Test
    public void testGameInitialization() {
        assertNotNull(game);
    }

    @Test
    public void testPlayerTurn() {
        Mockito.when(playerA.rollDice()).thenReturn(5);
        game.start();
        Mockito.verify(playerA, Mockito.atLeastOnce()).rollDice();
        Mockito.verify(playerB, Mockito.atLeastOnce()).reduceShareValue(5);
    }

    @Test
    public void testPlayerDefeat() {
        Mockito.when(playerA.rollDice()).thenReturn(100);
        Mockito.when(playerB.rollDice()).thenReturn(100);
        game.start();
        assertTrue(playerA.isDefeated() || playerB.isDefeated());
    }

    @Test
    public void testGameEnd() {
        Mockito.when(playerA.rollDice()).thenReturn(100);
        game.start();
        assertTrue(playerB.isDefeated());
    }

    @Test
    public void testGameStartAndEnd() {
        Mockito.when(playerA.rollDice()).thenReturn(100);
        Mockito.when(playerB.rollDice()).thenReturn(1);  // Ensure player B is not defeated on first turn
        game.start();
        assertTrue(playerB.isDefeated());
    }

    @Test
    public void testMultipleTurns() {
        Mockito.when(playerA.rollDice()).thenReturn(10, 20, 30, 40);
        Mockito.when(playerB.rollDice()).thenReturn(5, 15, 25, 35);

        game.start();

        Mockito.verify(playerA, Mockito.atLeast(4)).rollDice();
        Mockito.verify(playerB, Mockito.atLeast(4)).rollDice();
        assertTrue(playerA.isDefeated() || playerB.isDefeated());
    }
}
