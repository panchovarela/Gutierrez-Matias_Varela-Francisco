package com.company;

import com.company.dao.DAO;
import com.company.dao.Database;
import com.company.dao.implementations.OdontologoDAOEnMemoria;
import com.company.dao.implementations.OdontologoDAOH2;
import com.company.entity.Odontologo;
import com.company.service.OdontologoService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OdontologoServiceTest {

    private DAO<Odontologo> odontologoDAOH2 = new OdontologoDAOH2();
    private DAO<Odontologo> odontologoDAOEnMemoria = new OdontologoDAOEnMemoria();
    private OdontologoService odontologoService = new OdontologoService();
    private Database database = new Database();

    @Before
    public void cargarOdontologos() {
        database.crearTabla();
        odontologoService.save(new Odontologo(42933088, "Francisco", "Varela"));
        odontologoService.save(new Odontologo(12345678, "Matías", "Gutierrez"));
        odontologoService.save(new Odontologo(87654321, "Pepe", "Argento"));
    }

    @Test
    public void testListarOdontologos() {
        List<Odontologo> odontologoList = odontologoService.searchAll();
        for(Odontologo odontologo: odontologoList)
            System.out.println(odontologo.toString());
    }
}