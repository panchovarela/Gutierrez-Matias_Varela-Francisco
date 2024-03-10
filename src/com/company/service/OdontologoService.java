package com.company.service;

import com.company.dao.DAO;
import com.company.dao.implementations.OdontologoDAOH2;
import com.company.entity.Odontologo;

import java.util.List;

public class OdontologoService {

    private DAO<Odontologo> dao;

    public OdontologoService() {
        this.dao = new OdontologoDAOH2();
    }

    public void setDAO(DAO<Odontologo> dao) {
        this.dao = dao;
    }

    public Odontologo save(Odontologo odontologo) {
        return dao.save(odontologo);
    }

    public Odontologo search(Long id) {
        return dao.search(id);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public List<Odontologo> searchAll() {
        return dao.searchAll();
    }
}