package daos.interfaces;

import models.Region;

import java.util.List;

public interface IRegionDAO {
    public List<Region> getAll();

    public Region getById(int regionID);

    public boolean insert(Region region);

    public boolean update(Region region);

    public boolean delete(int regionId);

}
