<%-- 
    Document   : inclusao
    Created on : 15/03/2017, 21:36:23
    Author     : Rogerio.Rodrigues
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../estilo/html5.css"/>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="starter-template">
                <form method="post" action="/abdi-formulario-web/FormServlet">
                    <h4>Preencha os dados:</h4>
                    <div style="width: 50%">
                        <span class="input-group-addon" id="basic-addon1">Nome</span>
                        <input class="form-control" type="input" width="80px" name="nome"
                               maxlength="150" aria-describedby="basic-addon1"/>
                    </div>

                    <div class="input-group input-group-sm">
                        <span class="input-group-addon" id="basic-addon3">Opcoes</span>
                        <select name="opcoes" class="form-control" aria-describedby="basic-addon3">
                            <option selected value="1">Opcao 1</option>
                            <option value="2">Opcao 2</option>
                        </select>
                    </div>

                    <div class="input-group input-group-sm">
                        <span class="input-group-addon" id="basic-addon2">Cpf</span>
                        <input class="form-control" type="input" width="80px" name="cpf" maxlength="150" aria-describedby="basic-addon2"/>
                    </div>

                    <button type="submit" class="btn btn-default">Enviar</button>
                </form>
            </div>
        </div>

    </body>
</html>
