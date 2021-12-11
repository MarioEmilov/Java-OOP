package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class  GunRepository implements Repository<Gun>  {
    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Gun model) {
        models.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        Gun removed = models.remove(model.getName());
        return removed != null;
    }

    @Override
    public Gun find(String name) {
        return models.get(name);
    }
}
