import Dao.BaseDao;
import Dao.CivilizationDao;
import Dao.DaoFactory;
import Entity.Civilization;
import Entity.EntityInterface;
import Entity.Player;

import java.util.Collection;
import java.util.List;

public class TurnActionGenerator {

    boolean over;

    public TurnActionGenerator() {
        over = false;
        CivilizationDao civDao = DaoFactory.getCivilizationDao();
        List<Civilization> civs = civDao.findAll();
    }

    public void makeActions(Player player) {
        // do some stuff / build / attack

        // build

        // walk / attack

        // research
    }
}
