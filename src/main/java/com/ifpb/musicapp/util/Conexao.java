package com.ifpb.musicapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author lyndemberg
 */
public class Conexao {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://host-banco:5432/MusicApp";
        String usuario = "postgres";
        String senha = "pgadmin";
        return DriverManager.getConnection(url,usuario,senha);
    }
}
