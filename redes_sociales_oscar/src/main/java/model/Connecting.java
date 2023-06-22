package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connecting {
    private static final String bbdd="jdbc:mysql://localhost:3306/redes_sociales_oscar";
    private static final String usuario="root";
    private static final String pswd="";
    private static Connection con;

    public static Connection conecting(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(bbdd, usuario, pswd);
            System.out.println("Conexión exitosa!");
        } catch (Exception e) {
            System.out.println("Error de la conexión "+e.getMessage().toString());
        }
        return con;
    }
    public static void main(String[] args) {
        conecting();
    }
}
