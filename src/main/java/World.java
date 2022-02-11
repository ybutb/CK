import Dao.DaoFactory;
import Entity.Civilization;
import Entity.Player;

import java.util.ArrayList;
import java.util.List;

public class World {

    private final ArrayList<Player> players;
    boolean over;

    public World() {
        players = new ArrayList<Player>();
        over = false;
    }

    public void start() {
        while(!over) {
            System.out.println("The turn starts");

            List<Civilization> civs = DaoFactory.getCivilizationDao().findAll();

            // save players // Facade ???

            civs.forEach(civ -> {
                Player player = new Player();
                player.setName("Dude 1");
                players.add(player);
            });
        }
    }
}
