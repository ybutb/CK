package Dao;

import Entity.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CityDao extends BaseDao {
    private static final String PREFIX = "city:id:";
    private final BuildingDao buildingDao;
    private final PropertyDao propertyDao;

    public CityDao() {
        this.buildingDao = DaoFactory.getBuildingDao();
        this.propertyDao = DaoFactory.getPropertyDao();
    }

    // city:id:1 name test
    // city:id:1 prop.id 1
    // HGET city:id:1 buildings 1,2,5
    // HGET city:id:1 => all props

    public City addBuilding(Building building, City city) throws Exception
    {
        String cityKey   = PREFIX + city.getId();
        String cityValue = GSON.toJson(building.getId());

        insert(cityKey, cityValue);
        city.setCivilizationId(building.getId());

        return city;
    }

    public City assignCivilization(Civilization civ, City city) throws Exception
    {
        String civKey   = PREFIX + city.getId();
        String civValue = GSON.toJson(civ.getId());

        insert(civKey, civValue);
        city.setCivilizationId(civ.getId());

        return city;
    }

    public City find(int id) {
        String key = PREFIX + id;
        Map<String, String> cityData = fetchMap(key);

        if (cityData.isEmpty()) {
            System.out.println("Test");
        }

        City city = new City();

        city.setId(id);
        city.setCivilizationId(Integer.parseInt(cityData.get("civilization.id")));
        city.setName(cityData.get("name"));
        city.setLevel(Integer.parseInt(cityData.get("level")));

        this.populateBuildings(city, cityData);
        populateProps(city, cityData);

        return city;
    }

    public void populateBuildings(City city, Map<String, String> cityData)
    {
        // 1,2,5 etc
        String buildingIds = cityData.get("buildings");

        List<Building> buildings = Stream.of(buildingIds.split(",")).parallel()
                .filter(Objects::nonNull)
                .map(Integer::parseInt)
                .distinct()
                .map(this.buildingDao::find)
                .collect(Collectors.toList());

        city.setCityBuildings(buildings);
    }

    public void populateProps(City city, Map<String, String> cityData)
    {
        String propIds = cityData.get("props");

        List<Property> properties = Stream.of(propIds.split(",")).parallel()
                .filter(Objects::nonNull)
                .map(Integer::parseInt)
                .distinct()
                .map(this.propertyDao::find)
                .collect(Collectors.toList());

        city.setProps(properties);
    }

    public void save(EntityInterface entity) {
        this.insert(PREFIX + entity.getId(), GSON.toJson(entity));
    }
}