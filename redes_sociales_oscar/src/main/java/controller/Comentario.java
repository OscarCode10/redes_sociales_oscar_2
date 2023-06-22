package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario.ComentarioDAO;
import model.Comentario.ComentarioVO;

public class Comentario extends HttpServlet{
    ComentarioVO r=new ComentarioVO();
    ComentarioDAO rd=new ComentarioDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comentario=req.getParameter("comentario");
        System.out.println(comentario);

        switch (comentario) {
            case "dMenuC":
            req.getRequestDispatcher("views/Comentario/dashboard-menuC.jsp").forward(req, resp);
                break;
            case "verC":
            verComentario(req, resp);
                break;
            case "crearC":
            req.getRequestDispatcher("views/Comentario/dashboard-crearC.jsp").forward(req, resp);
                break;
            case "actuC":
            consultaXId(req, resp);
                break;
            default:
                break;
        }
    }
    private void verComentario(HttpServletRequest req, HttpServletResponse resp){
        try {
            List<ComentarioVO> comentarios=rd.showComents();
            req.setAttribute("comentarios", comentarios);
            req.getRequestDispatcher("views/Comentario/dashboard-verC.jsp").forward(req, resp);
            System.out.println("Se mostraron los comentarios");
        } catch (Exception e) {
            System.out.println("No se pueden ver los comentarios "+e.getMessage().toString());
        }
    }
    private void consultaXId(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("id")!=null) {
            r.setIdComents(Integer.parseInt(req.getParameter("id")));
        }
        try {
            ComentarioVO dates=rd.selectIdComentario(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("dates", dates);
            req.getRequestDispatcher("views/Comentario/dashboard-actuC.jsp").forward(req, resp);
            System.out.println("Se mostraron los datos para actualizar");
        } catch (Exception e) {
            System.out.println("No se pueden ver los datos de actualizar " + e.getMessage().toString());
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comentario=req.getParameter("comentario");
        System.out.println(comentario);
        
        switch (comentario) {
            case "Crear Comentario":
            crearComentario(req, resp);
                break;
            case "Actualizar Comentario":
            actuComentario(req, resp);
                break;
            case "eliminar":
            eliminarComentario(req, resp);
                break;
            default:
                break;
        }
    }
    private void crearComentario(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("coment")!=null) {
            r.setComents(req.getParameter("coment"));
        }
        if (req.getParameter("num")!=null) {
            r.setNum(Integer.parseInt(req.getParameter("num")));
        }
        try {
            rd.createComents(r);
            resp.sendRedirect("comentario?comentario=crearC");
            System.out.println("Comentario creada");
        } catch (Exception e) {
            System.out.println("Error en la insersion del comentario "+e.getMessage().toString());
        }
    }
    private void actuComentario(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("idComentario")!=null) {
            r.setIdComents(Integer.parseInt(req.getParameter("idComentario")));

        }
        if (req.getParameter("coment")!=null) {
            r.setComents(req.getParameter("coment"));
        }
        if (req.getParameter("num")!=null) {
            r.setNum(Integer.parseInt(req.getParameter("num")));
        }
        try {
            rd.updateComents(r.getIdComents(), r.getComents(), r.getNum());
            resp.sendRedirect("comentario?comentario=verC");
            System.out.println("Se actualizo el comentario");
        } catch (Exception e) {
            System.out.println("La publicación no se pudo actualizar "+e.getMessage().toString());
        }
    }
    private void eliminarComentario(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("idComentario")!=null) {
            r.setIdComents(Integer.parseInt(req.getParameter("idComentario")));
        }
        try {
            rd.deleteComents(r.getIdComents());
            resp.sendRedirect("comentario?comentario=verC");
            System.out.println("Se elimino el comentario");
        } catch (Exception e) {
            System.out.println("No se puede eliminar el comentario "+e.getMessage());
        }
    }
}
