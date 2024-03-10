package com.company.dao.implementations;

import com.company.dao.DAO;
import com.company.dao.Database;
import com.company.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements DAO<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);
    private static final String INSERT_ODONTOLOGO = "INSERT INTO Odontologos (Numero_de_matricula, Nombre, Apellido) VALUES (?, ?, ?)";
    private static final String SEARCH_ODONTOLOGO = "SELECT FROM Odontologos WHERE ID = ?";
    private static final String DELETE_ODONTOLOGO = "DELETE FROM Odontologos WHERE ID = ?";
    private static final String SEARCH_ALL_ODONTOLOGOS = "SELECT * FROM Odontologos";


    @Override
    public Odontologo save(Odontologo odontologo) {
        LOGGER.info("Guardando odontólogo...");
        Connection connection = null;
        try {
            connection = Database.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(INSERT_ODONTOLOGO, PreparedStatement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1, odontologo.getNumeroDeMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            if(rs.next())
                odontologo.setId(rs.getLong(1));
        } catch (ClassNotFoundException | SQLException throwables) {
            LOGGER.error("ERROR: " + throwables.getMessage());
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
        public Odontologo search(Long id) {
        LOGGER.info("Buscando odontólogo...");
        Connection connection = null;
        Odontologo odontologo = null;
        try {
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SEARCH_ODONTOLOGO);
            psSearch.setLong(1, id);
            ResultSet rs = psSearch.executeQuery();
            if(rs.next())
                odontologo = new Odontologo(id, rs.getInt(2), rs.getString(3), rs.getString(4));
        } catch (ClassNotFoundException | SQLException throwables) {
            LOGGER.error("ERROR: " + throwables.getMessage());
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Eliminando odontólogo...");
        Connection connection = null;
        try {
            connection = Database.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(DELETE_ODONTOLOGO);
            psDelete.setLong(1, id);
            psDelete.execute();
        } catch (ClassNotFoundException | SQLException throwables) {
            LOGGER.error("ERROR: " + throwables.getMessage());
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Odontologo> searchAll() {
        LOGGER.info("Buscando todos los odontólogos...");
        Connection connection = null;
        List<Odontologo> odontologoList = new ArrayList<>();
        try {
            connection = Database.getConnection();
            Statement sSearchAll = connection.createStatement();
            ResultSet rs = sSearchAll.executeQuery(SEARCH_ALL_ODONTOLOGOS);
            while (rs.next())
                odontologoList.add(new Odontologo(rs.getLong(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
        } catch (ClassNotFoundException | SQLException throwables) {
            LOGGER.error("ERROR: " + throwables.getMessage());
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return odontologoList;
    }
}