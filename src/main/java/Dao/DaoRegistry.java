package Dao;

import Entity.EntityInterface;

import java.util.HashMap;

public class DaoRegistry {
    private static HashMap<String, BaseDao> registry;

    private static void register(BaseDao dao) {
        String id = dao.getClass().getSimpleName();
        registry.put(id, dao);
    }

    static {
        register(new BuildingDao());
        register(new CityDao());
        register(new CivilizationDao());
        register(new PlayerDao());
        register(new PropertyDao());
    }

    public static BaseDao findDao(EntityInterface entity) throws RuntimeException {
        String id = entity.getClass().getSimpleName() + "Dao";

        if (registry.containsKey(id)) {
            return registry.get(id);
        }

        throw new RuntimeException("Unacceptable dao id");
    }
}