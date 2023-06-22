package model.Comentario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Connecting;
import model.Publicacion.PublicacionVO;

public class ComentarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int r;

    public int createComents(ComentarioVO coments)throws SQLException{ 
        sql="insert into comentario(idComentario, comentario, num) values(null,?,?)";
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            ps.setString(1,coments.getComents());
            ps.setInt(2,coments.getNum());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro tu comentario");
        } catch (Exception e) {
            System.out.println("Error al registrar"+e.getMessage().toString());
        }finally{
            con.close();
        }
        return r;
    }
    public List<ComentarioVO> showComents() throws Exception{
        List<ComentarioVO> listComentario=new ArrayList<>();
        sql="select * from comentario";
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
                ComentarioVO r=new ComentarioVO();
                r.setIdComents(rs.getInt("idComentario"));
                r.setComents(rs.getString("comentario"));
                r.setNum(rs.getInt("num"));
                listComentario.add(r);
            }
            ps.close();
            System.out.println("Select Enviado ");
        } catch (Exception e) {
            System.out.println("No se ejecutó el listar "+e.getMessage().toString());
        } finally{
            con.close();
        }
        return listComentario;
    }
    public ComentarioVO selectIdComentario(int idComents)throws Exception{
        sql="Select * from comentario where idComentario="+idComents;
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            if (rs.next()) {
                int idComentario=rs.getInt("idComentario");
                String comentario=rs.getString("comentario");
                int num=rs.getInt("num");
                return new ComentarioVO(idComentario, comentario, num);
            }
            ps.close();
            System.out.println("Se hizo el select");
        } catch (Exception e) {
            System.out.println("No se pudo hacer el select "+e.getMessage().toString());
        }finally{
            con.close();
        }
        return null;
    }   
    public void updateComents(int idComents, String coments, int num) throws SQLException{
        sql="UPDATE comentario SET comentario='"+coments+"',num='"+num+"' WHERE idComentario="+idComents;
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se actualizo el comentario modelo");
        } catch (Exception e) {
            System.out.println("No se puedo actualizar "+e.getMessage().toString());
        }
    }
    public void deleteComents(int idComents) throws SQLException{
        sql="delete from comentario where idComentario="+idComents;
        try {
            con=Connecting.conecting();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se eliminó correctamente");
        } catch (Exception e) {
            System.out.println("Error al elinminar el comentario "+e.getMessage().toString());
        } finally{
            con.close();
        }
    }
}
