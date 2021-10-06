<%-- 
    Document   : index
    Created on : 2/09/2021, 09:38:42 AM
    Author     : Sergio Cruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="container m-5 p-5">
            <h1 class="mb-5 text-center">Inicio de sesión</h1>
            <div>
                <form>
                    <div class="mb-3">
                        <label class="form-label">Nombre: </label>
                        <input class="form-control" type="text" name="txtNombreUsuario" required="true" autofocus="true" placeholder="Juan">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Clave de acceso </label>
                        <input class="form-control" type="password" name="txtPassword" required="true">
                    </div>
                    <div class="d-grid gap-2 mt-5">
                        <input class="btn btn-primary" type="submit" value="Ingresar" name="accion">
                    </div>
                </form>
            </div>
            <div>
                <a href="ProductoCTO?accion=listar">gestión de Productos</a>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        </div>
    </body>
</html>
