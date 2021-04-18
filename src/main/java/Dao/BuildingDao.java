package Dao;

import Entity.Building;
import Entity.City;
import Entity.Property;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingDao extends BaseDao {
    private static final String PREFIX = "building:id:";

    public static Building find(int id) {
        String key = PREFIX + id;
        Map<String, String> buildingData = fetchMap(key);

        if (buildingData.isEmpty()) {
            System.out.println("Building not found: " + id);
        }

        Building building = new Building();

        building.setId(id);
        building.setName(buildingData.get("name"));

        int cityId = Integer.parseInt(buildingData.get("city"));
        City city = CityDao.find(cityId);
        building.setCity(city);

        return building;
    }

    public void populateProps(City city, Map<String, String> cityData)
    {
        String propIds = cityData.get("props");

        List<Property> properties = Stream.of(propIds.split(",")).parallel()
                .filter(Objects::nonNull)
                .map(Integer::parseInt)
                .distinct()
                .map(PropertyDao::find)
                .collect(Collectors.toList());

        city.setProps(properties);
    }
}