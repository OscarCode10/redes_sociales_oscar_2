package model.Publicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Connecting;

public class PublicacionDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int r;

    public int createPublication(PublicacionVO publicacion) throws SQLException{
        sql="insert into publicacion(idPublicacion, publicacion, num) values(null,?,?);";
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            ps.setString(1, publicacion.getPublication());
            ps.setInt(2, publicacion.getNum());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro correctamente tu publicación");
        } catch (Exception e) {
            System.out.println("Error al registrar"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }
    
    public List<PublicacionVO> showPublication() throws Exception{
        List<PublicacionVO> listaPublicaciones=new ArrayList<>();
        sql="select * from publicacion";
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                PublicacionVO r=new PublicacionVO();
                r.setIdPublication(rs.getInt("idPublicacion"));
                r.setPublication(rs.getString("publicacion"));  
                r.setNum(rs.getInt("num"));
                listaPublicaciones.add(r);
            }
            ps.close();
            System.out.println("Select Completado");
        } catch (Exception e) {
            System.out.println("No se ejecutó el listar "+e.getMessage().toString());
        } finally{
            con.close();
        }
        return listaPublicaciones;
    }

    public PublicacionVO selectId(int idPubli)throws Exception{
        sql="Select * from publicacion where idPublicacion="+idPubli;
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            if (rs.next()) {
                int idPublicacion=rs.getInt("idPublicacion");
                System.out.println(idPublicacion);
                String publi=rs.getString("publicacion");
                System.out.println(publi);
                int num=rs.getInt("num");
                System.out.println(num);   
                return new PublicacionVO(idPublicacion, publi, num);
            }
            ps.close();
            System.out.println("Se envio el select");
        } catch (Exception e) {
            System.out.println("No se pudo hacer el select "+e.getMessage().toString());
        }finally{
            con.close();
        }
        return null;
    }   

    public void updatePublication(int idPublicacion, String publicacion, int num) throws SQLException{
        sql="UPDATE publicacion SET publicacion='"+publicacion+"',num='"+num+"' WHERE idPublicacion="+idPublicacion;
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se actualizó la publicación");
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la publicación"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
    }
    public void deletePublication(int idPublicacion) throws SQLException {
        sql="DELETE FROM publicacion WHERE idPublicacion="+idPublicacion;
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se elimino la publicación");
        } catch (Exception e) {
            System.out.println("Error al eliminar la publicación"+e.getMessage().toString());
        }finally{
            con.close();
        }
    }
}
