import Dao.DaoRegistry;
import Entity.Civilization;
import Entity.Player;

import java.util.ArrayList;

public class World {

    private final ArrayList<Player> players;
    private final DaoRegistry registry;
    boolean over;

    public World() {
        players = new ArrayList<Player>();
        over = false;

        registry = DaoRegistry.getInstance();
    }

    public void start() {
        while(!over) {
            System.out.println("The turn starts");

            ArrayList<Civilization> civs = registry.findDao(new Civilization()).findAll();

            // save players // Facade ???

            civs.forEach(civ -> {
                Player player = new Player();
                players.add(player);
            });

        }
    }
}
