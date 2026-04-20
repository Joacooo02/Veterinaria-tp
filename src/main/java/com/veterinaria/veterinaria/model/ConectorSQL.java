package com.veterinaria.veterinaria.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorSQL { //FALTA AGREGAR LOS PARAMETROS PASSWORD DBNAME Y URL
    private static final String user = "root";
    private static final String password = "root";
    private static final String db_name = "";
    private static final String url = "jdbc:mysql://localhost:3306/veterinaria";

    public static Connection crearConexion() {
        try {
            return DriverManager.getConnection(url + db_name, user, password);
        } catch (SQLException e) {
            System.out.println("Error al conectar: \n" + e.getMessage());
            return null;
        }
    }
}
