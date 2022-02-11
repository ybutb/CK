package Dao;

import Entity.Civilization;
import Entity.Player;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Civilization> findAll() {
        Set<Map<String, String>> civilizationsData = fetchAll(CIV_PREFIX);

        if (civilizationsData.isEmpty()) {
            System.out.println("Error");
        }

        return civilizationsData.stream().map(this::populateEntityFromData).collect(Collectors.toList());
    }

    private Civilization populateEntityFromData(Map<String, String> civilizationData)
    {
        Civilization civ = new Civilization();

        civ.setId(Integer.parseInt(civilizationData.get("id")));
        civ.setPlayerId(Integer.parseInt(civilizationData.get("player.id")));
        civ.setName(civilizationData.get("name"));

        return civ;
    }
}