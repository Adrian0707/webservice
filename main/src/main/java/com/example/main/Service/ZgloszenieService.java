package com.example.main.Service;


import com.example.main.Dao.ZgloszenieDao;
import com.example.main.Entity.Zgloszenie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ZgloszenieService {

    @Autowired
    @Qualifier("zgloszenieSql")
    private ZgloszenieDao zgloszenieDao;

    public Collection<Zgloszenie> getAllZgloszenie() {
        return zgloszenieDao.getAllZgloszenie();

    }

    public Zgloszenie getZgloszenieById(int id) {
        return this.zgloszenieDao.getZgloszenieById(id);
    }

    public Collection<Zgloszenie> getZgloszeniaByIdUz(int idUz) {
        return this.zgloszenieDao.getZgloszeniaByIdUz(idUz);
    }

    public void removeZgloszenieById(int id) {
        zgloszenieDao.removeZgloszenieById(id);
    }

    public void upadeZgloszenieByID(Zgloszenie zgloszenie) {
        zgloszenieDao.upadeZgloszenieByID(zgloszenie);

    }
    public Collection<Zgloszenie> getAllPracownik(int id_prac) {
        return zgloszenieDao.getAllZgloszenie(id_prac);

    }
    public void insertZgloszenie(Zgloszenie zgloszenie) {
        zgloszenieDao.insertZgloszenie(zgloszenie);
    }
    public int getZgloszenieCount(){return this.zgloszenieDao.getZgloszenieCount();}
}
