package Dao;

import Entity.Civilization;
import Entity.Player;
import com.google.gson.Gson;

public class CivilizationDao extends BaseDao {
    private static final String CIV_PREFIX = "civilization:id:";
    private static final Gson GSON = new Gson();

    public Civilization assignPlayer(Civilization civilization, Player player) throws Exception {
        String userKey = CIV_PREFIX + civilization.getId();
        String userValue = GSON.toJson(player.getId());

        insert(userKey, userValue);
        civilization.setPlayerId(player.getId());

        return civilization;
    }

    public Civilization find(int id) {
        String key = CIV_PREFIX + id;
        String data = fetch(key);

        Civilization civ = new Civilization();
        civ.setPlayerId(Integer.parseInt(data));

        // name???

        return civ;
    }
}