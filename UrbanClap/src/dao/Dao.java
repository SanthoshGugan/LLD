package dao;

import exception.EntityNotFoundException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Dao<E, I>  {
    private final Map<I, E> entityMap;
    private final String entityField;

    public Dao(final String entityField) {
        this.entityField = entityField;
        this.entityMap = new HashMap<>();
    }

    public E get(final I id) {
        return entityMap.get(id);
    }

    public List<E> getAll() {
        return entityMap.values().stream().toList();
    }

    public void upsert(final E entity, final I id) {
        entityMap.put(id, entity);
    }

    public E delete(final I id) {
        if (!entityMap.containsKey(id)) {
            return null;
        }
        final E entity = entityMap.get(id);
        entityMap.remove(id);
        return entity;
    }

    private I getEntity(final E entity) {
        Field[] fields = entity.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals(entityField)) return (I) field.get(entity);
            }
        } catch(final EntityNotFoundException e) {
            return null;
        } catch (final IllegalAccessException e) {
            System.out.printf("entity id not accessible : %s", entityField);
            return null;
        }
        return null;
    }
}
