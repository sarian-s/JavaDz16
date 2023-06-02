import java.util.HashMap;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public Player findByName(String name) {
        return players.get(name);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("игрок(и) не зарегистрирован(ы) ");
        }

        if (player2.getStrength() > player1.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }

    }

}
