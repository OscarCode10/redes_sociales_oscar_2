<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DashBoard de Twitter</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="assets/css/dashboard11.css">
</head>
<body>
    <aside class="aside active" id="aside">
        <div class="head">
            <div class="profile">
                <p>Menu de Opciones de Twitter</p>
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
    <div>
        <form action="comentario" method="post">
            <h1>Actualizar Comentario</h1>
            <input class="input" type="number" name="idComentario" placeholder="Id de la publicación" value="${dates.getIdComents()}" readonly="readonly">
            <input class="input" type="text" name="coment" placeholder="Texto de publicación" value="${dates.getComents()}">
            <input class="input" type="number" name="num" placeholder="Número de publicación" value="${dates.getNum()}">
            <input class="iniciar" type="submit" name="comentario" value="Actualizar Comentario">
        </form>
        <a href="comentario?comentario=verC"> <input class="bot-volver" type="button" value="Volver"></a>
    </div>
    <!--<script>
        alert(`La publicación se ha creado correctamente y dice: <%=request.getAttribute("publi")%>`);
    </script>-->
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