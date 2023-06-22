package model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Connecting;

public class UsuarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int r;

    public int registrarUsuario(UsuarioVO usuario) throws SQLException{
        sql="INSERT INTO usuario (`tipoDoc`,`numDoc`,`nombre`,`correo`,`pswd`,`estado`) values (?,?,?,?,?,?)";
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario.getTipoDoc());
            ps.setInt(2, usuario.getNumDoc());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getPswd());
            ps.setString(6, usuario.getEstado());
            System.out.println(ps);
            r=ps.executeUpdate();
            ps.close();
            System.out.println("Se registro el usuario correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

    /*public String login(String correo){
        UsuarioVO r=new UsuarioVO();
        sql="select * from usuario where correo="+correo;
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            if (rs.next()) {
                String pswd=rs.getString("pswd");
                if (pswd.equals(r.getPswd())) {
                    String estado="Usuario correcto";
                    return estado;
                } else{
                    String estado="Clave incorrecta";
                    return estado;
                }
            }else{
                String estado="Correo incorrecto";
                return estado;
            }
        } catch (Exception e) {
            System.out.println("No se puede hacer el login model "+e.getMessage().toString());
        }
        return null;
    }*/
    public String login(String correo, String pswd, String estado) {
        sql = "SELECT * FROM usuario WHERE correo ='"+correo+"';";
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            if (rs.next()) {
                String pswdBD=rs.getString("pswd");
                if (pswdBD.equals(pswd)) {
                    estado="usuario correcto";
                }
            }else{
                estado="Este usuario no existe";
            }
            ps.close();
            System.out.println("Se envio el inicio de sesion modelo");
        } catch (Exception e) {
            System.out.println("No se puede hacer el login model " + e.getMessage().toString());
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage().toString());
            }
        }
        return estado;
    }
}
