package Dao;

import Entity.Building;
import Entity.Player;
import Entity.Property;

import java.util.Map;

public class PropertyDao extends BaseDao {
    private static final String PREFIX = "property:id:";

    public Property find(int id) {
        String key = PREFIX + id;
        Map<String, String> propertyData = this.fetchMap(key);

        if (propertyData.isEmpty()) {
            System.out.println("property not found: " + id);
        }

        Property property = new Property();

        property.setId(id);
        property.setName(propertyData.get("name"));
        property.setValue(propertyData.get("value"));

        return property;
    }
}