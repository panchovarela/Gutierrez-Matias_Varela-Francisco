package com.company.dao.implementations;

import com.company.dao.DAO;
import com.company.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOEnMemoria implements DAO<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOEnMemoria.class);
    private List<Odontologo> odontologoList = new ArrayList<>();

    @Override
    public Odontologo save(Odontologo odontologo) {
        LOGGER.info("Guardando odontólogo...");
        odontologoList.add(odontologo);
        return odontologo;
    }

    @Override
    public Odontologo search(Long id) {
        LOGGER.info("Buscando odontólogo...");
        Odontologo odontologoABuscar = null;
        int i = 0;
        while(odontologoABuscar == null && i < odontologoList.size()) {
            Odontologo odontologo = odontologoList.get(i);
            if(odontologo.getId() == (long) id)
                odontologoABuscar = odontologo;
            i++;
        }
        return odontologoABuscar;
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Eliminando odontólogo...");
        Odontologo odontologo = search(id);
        odontologoList.remove(odontologo);
    }

    @Override
    public List<Odontologo> searchAll() {
        LOGGER.info("Buscando todos los odontólogos...");
        return odontologoList;
    }
}