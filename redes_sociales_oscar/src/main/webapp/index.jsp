<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/styles10.css">
    <link rel="stylesheet" href="assets/css/modal1.css">
    <title>Entre Tus Redes</title>
</head>
<body>
    <header>
        <div>
            <h1 class="entre-redes">ENTRE TUS REDES</h1>
            <img src="assets/img/logo.png" width="150px" height="150px" class="logo"> 
        </div>
    </header>
    <main>
        <br>
        <div class="parrafo">
            <p>
                 "Querido usuario, en esta página podrá utilizar
                Facebook y Twitter, oprima encima de las imágenes 
                para saber más información sobre cada red social."
            </p>
        </div>
        <!--<p>
        <%
        for(int i=0;i<4;i++){
        out.println("<BR>Iteración "+i);
        }
        %>
        </p>
        <p><%=new String("Hola Oscar").toUpperCase()%></p>
        <p>
            <%!
            private int res;
            
            public int restar(int n1,int n2){
            res=n1-n2;
            return res;
            }
            %>
        </p>
        <p><%= new String("El resultado de la resta es: "+restar(4,2)) %></p>-->
        <div>
            <h1 class="twitter">Twitter</h1>
            <img class="img-twitter" src="assets/img/logoTwitter.png" width="550px" height="500px" id="abrirModal">  
            <div id="ventanaModal" class="modal">
                <div class="contenidoModal">
                    <input type="submit" class="X" value="X">
                    <h2>Twitter</h2>
                    <p>
                        Twitter es una red social en la que puede interactuar con personas en internet, puedes ver 
                        Comentarios y con ellos puedes hacer más cosas. ¿Qué esperas?, inicia sesión ahora.
                    </p>
                    <a href="usuario?usuario=loginT" ><input class="bot-iniciar" type="button" value="Iniciar de sesión"></a>
                    <a href="usuario?usuario=registerT" ><input class="bot-registrar" type="button" value="Registrarse"></a>
                </div>
            </div>
            <h1 class="face">Facebook</h1>
            <img class="img-face" src="assets/img/logoFacebook.png" width="550px" height="500px" id="abrirModalF">
            <div id="ventanaModalF" class="modalF">
                <div class="contenidoModalF">
                    <input type="submit" class="XF" value="X">
                    <h2>Facebook</h2>
                    <p>
                        Facebook es una red social en la que puede interactuar con personas en internet, puedes ver 
                        publicaciones y con ellas puedes hacer más cosas. ¿Qué esperas?, inicia sesión ahora.
                    </p>
                    <a href="usuario?usuario=loginF" ><input class="bot-iniciar" type="button" value="Iniciar de sesión"></a>
                    <a href="usuario?usuario=registerF" ><input class="bot-registrar" type="button" value="Registrarse"></a>
                </div>
            </div> 
        </div>
        <script src="assets/js/modales.js"></script>
    </main>
</body>
</html>