package Dao;

import Entity.Civilization;
import Entity.Player;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class CivilizationDao extends BaseDao {
    private static final String CIV_PREFIX = "civilization:id:";
    private static final Gson GSON = new Gson();

    // civilization:id:1 name test
    // civilization:id:1 player.id 1
    // HGET civilization:id:1 player.id => 1
    // HGET civilization:id:1 => all props

    public Civilization assignPlayer(Civilization civilization, Player player) throws Exception {
        String userKey = CIV_PREFIX + civilization.getId();
        String userValue = GSON.toJson(player.getId());

        insert(userKey, userValue);
        civilization.setPlayerId(player.getId());

        return civilization;
    }

    public Civilization find(int id) {
        String key = CIV_PREFIX + id;
        Map<String, String> civilizationData = fetchMap(key);

        if (civilizationData.isEmpty()) {
            System.out.println("Error");
        }

        Civilization civ = new Civilization();

        civ.setId(id);
        civ.setPlayerId(Integer.parseInt(civilizationData.get("player.id")));
        civ.setName(civilizationData.get("name"));

        return civ;
    }

    public ArrayList<Civilization> findAll() {
        String key = CIV_PREFIX;
        Map<String, String> civilizationData = fetchMap(key);

        if (civilizationData.isEmpty()) {
            System.out.println("Error");
        }

        Civilization civ = new Civilization();

        civ.setId(id);
        civ.setPlayerId(Integer.parseInt(civilizationData.get("player.id")));
        civ.setName(civilizationData.get("name"));

        return civ;
    }
}