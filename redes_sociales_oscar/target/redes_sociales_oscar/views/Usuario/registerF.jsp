<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="assets/css/styles10.css">
    <title>Registrarse en Facebook</title>
</head>
<body>
    <main>
        <p>
            <h1 class="registrarse">Registrarse en Facebook</h1>
        </p>    
    </main>
    <div>
        <center>
            <form action="usuario" method="post">
            <select class="input1" name="tipoDoc" class="form-control" id="exampleInputPassword1">
                <option value="">Tipo de Documento</option>
                <option value="C.C."> C.C.</option>
                <option value="T.I."> T.I.</option>
                <option value="C.E"> C.E </option>
            </select>
            <br>
            <input class="input" type="number" name="numDoc" placeholder="Numero de Documento">
            <br>
            <input class="input" type="text" name="nombre" placeholder="Nombre Completo">
            <br> 
            <input class="input" type="email" name="correo" placeholder="Email">
            <br> 
            <input class="input" type="password" name="pswd" placeholder="Contraseña">
            <br> 
            <input class="input" type="password" name="pswdC" placeholder="Confirmar contraseña">
            <br>
            <select class="input" name="estado" class="form-control" id="exampleInputPassword1">
                <option value="">Estado</option>
                <option value="Activado">Activado</option>
                <option value="Desactivado">Desactivado</option>
            </select>
            <input class="iniciar" type="submit" name="usuario" value="Registrarse en Facebook">
            </form>
        </center>
    </div>

    <a href="usuario?usuario=Volver"> <input class="bot-volver" type="button" value="Volver"></a>
</body>
</html>