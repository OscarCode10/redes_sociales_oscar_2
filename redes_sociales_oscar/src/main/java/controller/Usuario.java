 package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario.UsuarioVO;
import model.Usuario.UsuarioDAO;

public class Usuario extends HttpServlet {
    UsuarioVO r=new UsuarioVO();
    UsuarioDAO rd=new UsuarioDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario=req.getParameter("usuario");
        System.out.println(usuario);

        switch (usuario) {
            //Facebook
            case "registerF":
                req.getRequestDispatcher("views/Usuario/registerF.jsp").forward(req, resp);
                break;
            case "loginF":
                req.getRequestDispatcher("views/Usuario/loginF.jsp").forward(req, resp);
                break;
            
            //Twitter
            case "registerT":
                req.getRequestDispatcher("views/Usuario/registerT.jsp").forward(req, resp);
                break;
            case "loginT":
                req.getRequestDispatcher("views/Usuario/loginT.jsp").forward(req, resp);
                break;
            
            //Para ambos
            case "Cerrar Sesion":
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "Volver":
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;

            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario=req.getParameter("usuario");
        System.out.println(usuario);

        switch (usuario) {
            //Facebook
            case "Iniciar Sesion en Facebook":
            inicarSesion(req, resp);
                break;
            case "Registrarse en Facebook":
            registrarUsuario(req, resp);
                break;
            //Twitter
            case "Iniciar Sesion en Twitter":
            inicarSesion(req, resp);
                break;
            case "Registrarse en Twitter":
            registrarUsuario(req, resp);
                break;
            default:
                break;
        }
    }
    private void registrarUsuario(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("tipoDoc")!=null) {
            r.setTipoDoc(req.getParameter("tipoDoc"));
        }
        if (req.getParameter("numDoc")!=null) {
            r.setNumDoc(Integer.parseInt(req.getParameter("numDoc")));
        }
        if (req.getParameter("nombre")!=null) {
            r.setNombre(req.getParameter("nombre"));
        }
        if (req.getParameter("correo")!=null) {
            r.setCorreo(req.getParameter("correo"));
        }
        if (req.getParameter("pswd")!=null && req.getParameter("pswdC")!=null) {
            r.setPswd(req.getParameter("pswd"));
        }
        if (req.getParameter("estado")!=null) {
            r.setEstado(req.getParameter("estado"));
        }
        try {
            rd.registrarUsuario(r);
            resp.sendRedirect("usuario?usuario=Volver");
            System.out.println("Se registro el usuario");
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    private void inicarSesion(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("correo")!=null) {
            r.setCorreo(req.getParameter("correo"));
        }
        if (req.getParameter("pswd")!=null) {
            r.setPswd(req.getParameter("pswd"));
        }
        try {
            String estado = rd.login(r.getCorreo(), r.getPswd(),"");
            System.out.println(estado);
            /*1f (estado.equals("usuario correcto")&& req.getParameter("lugar").equals("F")) {
                req.getRequestDispatcher("views/dashboardF.jsp").forward(req, resp);
            }else if (estado.equals("usuario correcto")&& req.getParameter("lugar").equals("T")) {
                req.getRequestDispatcher("views/dashboardT.jsp").forward(req, resp);
            }else if(estado.equals("Este usuario no existe")&& req.getParameter("lugar").equals("F")){
                resp.sendRedirect("usuario?usuario=loginF");
            }else if(estado.equals("Este usuario no existe")&& req.getParameter("lugar").equals("T")){
                resp.sendRedirect("usuario?usuario=loginT");
            }*/
            if (estado.equals("usuario correcto")) {
                if (req.getParameter("lugar").equals("F")) {
                    req.getRequestDispatcher("views/dashboardF.jsp").forward(req, resp);
                }else{
                    req.getRequestDispatcher("views/dashboardT.jsp").forward(req, resp);
                }
            }else{
                if (req.getParameter("lugar").equals("F")) {
                    resp.sendRedirect("usuario?usuario=loginF");
                }else{
                    resp.sendRedirect("usuario?usuario=loginT");
                }
            }
            System.out.println("Se inicio sesion controlador");
        } catch (Exception e) {
            System.out.println("Error al iniciar sesion controlador "+e.getMessage().toString());
        }
    }
}
