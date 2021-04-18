package Entity;

public class Unit  implements EntityInterface {
    private int id;
    private int civilizationId;
    private String name;
    private int level;
    private int[] cityBuildingIds;
    private int defence;
    private int propIds;

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

    public int[] getCityBuildingIds() {
        return cityBuildingIds;
    }

    public void setCityBuildingIds(int[] cityBuildingIds) {
        this.cityBuildingIds = cityBuildingIds;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPropIds() {
        return propIds;
    }

    public void setPropIds(int propIds) {
        this.propIds = propIds;
    }
}
