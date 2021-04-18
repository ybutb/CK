package Dao;

import Entity.Player;

import java.util.Map;

public class PlayerDao extends BaseDao {
    private static final String PREFIX = "player:id:";

    public Player find(int id) {
        String key = PREFIX + id;
        Map<String, String> playerData = fetchMap(key);

        if (playerData.isEmpty()) {
            System.out.println("Wrong player id - not found.");;
        }

        Player player = new Player();

        player.setId(id);
        player.setName(playerData.get("name"));

        return player;
    }

    public String getRegistryId()
    {
        return "player";
    }
}