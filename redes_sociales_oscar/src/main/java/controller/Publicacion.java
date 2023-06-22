package controller;

import java.io.IOException;
import java.lang.module.ModuleDescriptor.Requires;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;

import model.Publicacion.PublicacionVO;
import model.Publicacion.PublicacionDAO;

public class Publicacion extends HttpServlet{
    PublicacionVO r=new PublicacionVO();
    PublicacionDAO rd=new PublicacionDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String publicacion=req.getParameter("publicacion");
        System.out.println(publicacion);

        switch (publicacion) {
            case "dMenuP":
            req.getRequestDispatcher("views/Publicacion/dashboard-menuP.jsp").forward(req, resp);
                break;
            case "verP":
            verPublicacion(req, resp);
                break;
            case "crearP":
            req.getRequestDispatcher("views/Publicacion/dashboard-crearP.jsp").forward(req, resp);
                break;
            case "actuP":
            consultaXId(req, resp);
                break;
            default:
            break;
        }
    }
    private void verPublicacion(HttpServletRequest req, HttpServletResponse resp){
        PublicacionVO publicacionVO=new PublicacionVO();
        PublicacionDAO publicacionDAO=new PublicacionDAO();
        try {
            List<PublicacionVO> arrayPublicaciones = publicacionDAO.showPublication();
            req.setAttribute("publicaciones", arrayPublicaciones);
            req.getRequestDispatcher("views/Publicacion/dashboard-verP.jsp").forward(req, resp);
            System.out.println("Se mostraron los datos correctamente");
        } catch (Exception e) {
            System.out.println("No se pueden ver las publicaciones "+e.getMessage().toString());
        }
    }
    private void consultaXId(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id")!=null) {
            r.setIdPublication(Integer.parseInt(req.getParameter("id")));
        }
        try {
            PublicacionVO dates = rd.selectId(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("dates", dates); 
            req.getRequestDispatcher("views/Publicacion/dashboard-actuP.jsp").forward(req, resp);
            System.out.println("Se mostraron los datos para actualizar");
        } catch (Exception e) {
            System.out.println("No se pueden ver los datos de actualizar " + e.getMessage().toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String publicacion=req.getParameter("publicacion");
        System.out.println(publicacion);
        switch (publicacion) {
            case "Crear Publicacion":
            createPublicacion(req, resp);
                break;
            case "Actualizar Publicacion":
            actuPublicacion(req, resp);
                break;
            case "eliminar":
            eliminarPublicacion(req, resp);
                break;
            default:
                break;
        }
    }
    private void createPublicacion(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("publi")!=null) {
            r.setPublication(req.getParameter("publi"));
        }
        if (req.getParameter("num")!=null) {
            r.setNum(Integer.parseInt(req.getParameter("num")));
        }
        try {
            rd.createPublication(r);
            resp.sendRedirect("publicacion?publicacion=crearP");
            System.out.println("Se registro correctamente la publicación");
            
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    private void actuPublicacion(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("idPubli")!=null) {
            r.setIdPublication(Integer.parseInt(req.getParameter("idPubli")));
        }
        if (req.getParameter("publi")!=null) {
            r.setPublication(req.getParameter("publi"));
        }
        if (req.getParameter("num")!=null) {
            r.setNum(Integer.parseInt(req.getParameter("num")));
        }
        try {
            rd.updatePublication(r.getIdPublication(), r.getPublication(), r.getNum());
            resp.sendRedirect("publicacion?publicacion=verP");
            System.out.println("La publicación se actualizó");
        } catch (Exception e) {
            System.out.println("La publicación no se pudo actualizar "+e.getMessage().toString());
        }
    }
    private void eliminarPublicacion(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idPubli")!= null ) {
            r.setIdPublication(Integer.parseInt(req.getParameter("idPubli")));
        }
        try {
            rd.deletePublication(r.getIdPublication());
            resp.sendRedirect("publicacion?publicacion=verP");
            System.out.println("Publicación eliminada");
        } catch (Exception e) {
            System.out.println("No se puede eliminar la publicación"+e.getMessage());
        }
    }
}
