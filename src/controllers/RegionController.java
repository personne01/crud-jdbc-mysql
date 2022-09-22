package controllers;

import daos.concretes.RegionDAO;
import daos.interfaces.IRegionDAO;
import models.Region;

import java.sql.Connection;
import java.util.List;

//menerima input (dari UI /view)
//logic(validasi)

public class RegionController {

    private IRegionDAO rdao;

    public RegionController(Connection connection) {
        rdao = new RegionDAO(connection);
    }

    public String insert(String regionId, String regionName) {
        Region region = new Region(Integer.parseInt(regionId), regionName);

        if (rdao.insert(region)) {
            return "Insert Berhasil";
        }
        return "Insert Gagal";
    }

    public String update(String regionId, String regionName){
        Region region = new Region(Integer.parseInt(regionId), regionName);
        if (rdao.update(region)) return ("Data name dengan Id"+regionId+ " berhasil diubah");
        return "Data tidak berhasil diubah";
    }

    public String delete(String regionId){

        if (rdao.delete(Integer.parseInt(regionId))) return ("Data name dengan Id"+regionId+ " berhasil dihapus");
        return "Data tidak berhasil Dihapus";
    }

    public Region getById(String regionId){
        Region region = rdao.getById(Integer.parseInt(regionId));
        return region;
    }

    public List<Region> getAll() {
        return rdao.getAll();
    }

}