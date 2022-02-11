package Dao;

public class DaoFactory {
    public static BuildingDao getBuildingDao() {return new BuildingDao();}
    public static CivilizationDao getCivilizationDao() {
        return new CivilizationDao();
    }
    public static CityDao getCityDao() {
        return new CityDao();
    }
    public static PlayerDao getPlayerDao() {
        return new PlayerDao();
    }
    public static PropertyDao getPropertyDao() {
        return new PropertyDao();
    }
}