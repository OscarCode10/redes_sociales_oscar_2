<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="assets/css/styles10.css">
    <title>Registrarse en Twitter</title>
</head>
<body>
    <main>
        <p>
            <h1 class="registrarse">Registrarse en Twitter</h1>
        </p>    
    </main>
    <div>
        <center>
            <form action="usuario" method="post">
            <select class="input1" name="estadoPedido" class="form-control" id="exampleInputPassword1">
                <option value="buen estado"> C.C. </option>
                <option value="mal estado"> T.I. </option>
                <option value="disponible"> C.E </option>
            </select>
            <br>
            <input class="input" type="number" placeholder="Numero de Documento">
            <br>
            <input class="input" type="text" placeholder="Nombre Completo">
            <br> 
            <input class="input" type="email" placeholder="Email">
            <br> 
            <input class="input" type="password" placeholder="Contraseña">
            <br> 
            <input class="input" type="password" placeholder="Confirmar contraseña">
            <br>
            <input class="iniciar" type="submit" name="usuario" value="Registrarse en Twitter">
            </form>
        </center>
    </div>

    <a href="usuario?usuario=Volver"> <input class="bot-volver" type="button" value="Volver"></a>
</body>
</html>