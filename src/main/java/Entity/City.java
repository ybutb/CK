package Entity;

import java.util.ArrayList;
import java.util.List;

public class City implements EntityInterface {
    private int id;
    private int civilizationId;
    private String name;
    private int level;
    private List<Building> cityBuildings;
    private List<Property> props;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCivilizationId() {
        return civilizationId;
    }

    public void setCivilizationId(int civilizationId) {
        this.civilizationId = civilizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Building> getCityBuildings() {
        return cityBuildings;
    }

    public void setCityBuildings(List<Building> cityBuildingIds) {
        this.cityBuildings = cityBuildingIds;
    }

    public void addCityBuilding(Building building) {
        this.cityBuildings.add(building);
    }

    public List<Property> getProps() {
        return props;
    }

    public void setProps(List<Property> props) {
        this.props = props;
    }
}
