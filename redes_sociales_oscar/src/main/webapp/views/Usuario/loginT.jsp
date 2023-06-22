<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="assets/css/styles10.css">
    <title>Iniciar sesión en Twitter</title>
</head>
<body>
    <main> 
        <p>
            <h1 class="sesion">Iniciar Sesión en Twitter</h1>
        </p>
    </main>
    <center><form action="usuario" method="post">
        <input class="input" type="email" placeholder="Email" name="correo" required>
        <br>
        <input class="input" type="password" placeholder="Contraseña" name="pswd" required>
        <br>
        <input class="input" type="hidden" name="lugar" value="T">
        <br>
        <input class="iniciar" type="submit" name="usuario" value="Iniciar Sesion en Twitter">
    </form></center>
    <a href="usuario?usuario=Volver"> <input class="bot-volver" type="button" value="Volver"></a>
</body>
</html>