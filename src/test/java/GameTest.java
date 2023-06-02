import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class GameTest {

    @Test
    public void register() {
        Player player1 = new Player(1, "Петя", 100);
        Game game = new Game();
        game.register(player1);

        Assertions.assertEquals(player1, game.findByName(player1.getName()));
    }

    @Test
    public void round() {
        Player player1 = new Player(1, "Петя", 110);
        Player player2 = new Player(2, "Оля", 100);
        Player player3 = new Player(3, "Вася", 100);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), "Коля");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", player3.getName());
        });
        Assertions.assertEquals(2, game.round(player2.getName(), player1.getName()));
        Assertions.assertEquals(1, game.round(player1.getName(), player3.getName()));
        Assertions.assertEquals(0, game.round(player2.getName(), player3.getName()));
    }

}
