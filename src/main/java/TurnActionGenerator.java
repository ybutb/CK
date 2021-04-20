import Dao.CivilizationDao;
import Dao.DaoRegistry;
import Entity.Civilization;
import Entity.Player;

import java.util.ArrayList;

public class TurnActionGenerator {

    private final DaoRegistry registry;
    boolean over;

    public TurnActionGenerator() {
        over = false;

        CivilizationDao civ = DaoRegistry.getInstance().findDao(new Civilization());
    }

    public void makeActions(Player player) {
        // do some stuff / build / attack

        // build

        // walk / attack

        // research
    }
}
