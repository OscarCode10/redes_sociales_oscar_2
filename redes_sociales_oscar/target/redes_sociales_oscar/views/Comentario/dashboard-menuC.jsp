<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DashBoard de Facebook</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="assets/css/dashboard11.css">
</head>
<body>
    <aside class="aside active" id="aside">
        <div class="head">
            <div class="profile">
                <p>Menu de Opciones de Facebook</p>
            </div>
            <i class='bx bx-menu' id="menu"></i>
        </div>
        <div class="options">            
            <div>  
                <i class='bx bx-plus' ></i>
                <a href="comentario?comentario=dMenuC"><span class="option">Comentarios</span></a>
            </div>
        </div>
    </aside>
    <!--<center><p><%=new String ("Bienvenido Usuario Oscar") %></p></center>-->
    <script src="assets/js/dashboard.js"></script>
    <h1 class="titu-dash">DashBoard de Twitter</h1>
    <a href="usuario?usuario=Cerrar Sesion"><input type="submit" value="Cerrar Sesión" class="bot-cerrar"></a>
    <a href="comentario?comentario=crearC"><input type="submit" value="Crear Comentario" class="bot-crear"></a>
    <a href="comentario?comentario=verC"><input type="submit" value="Ver Comentario" class="bot-ver"></a>
    <!--<p>
        <%!
        private String coment;

        public String verComentario(String comenta){
        coment="Me gusta tu foto";
        return coment;
        }
        %>
    </p>
    <center><p><%=new String ("Este es tu comentario: "+verComentario("")) %></p></center>-->
</body>
</html>