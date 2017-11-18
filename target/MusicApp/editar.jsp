<%@taglib  prefix="m"  uri="/WEB-INF/DescritorTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Editar álbum</title>
    </head>
    <body>
        <m:get descricao="perfilAlbum" id="${param.id}" />
        <m:get  descricao="bandas"/>
        <div class="container">
            <center><h4>Editar álbum</h4></center>
            <div class="row">
                <div class="col l4 offset-l4">
                    <form action="frozen" method="POST">
                        <select name="estilo" required>                            
                            <option value="${album.estilo.toString()}" selected>${album.estilo.toString()}</option>
                            <option value="ROCK">Rock</option>
                            <option value="POP">Pop</option>
                            <option value="SERTANEJO">Sertanejo</option>
                        </select><br>
                        <div class="input-field">
                            <input id="lancamento" value="${album.lancamento.toString()}" name="lancamento" type="date" class="validate" required>
                            <label class="active" name="lancamento" for="lancamento">Lançamento</label>
                        </div><br>
                        <select name="banda" required>
                            <option value="${album.banda.id}" selected>${album.banda.nome}</option>
                            <c:forEach  items="${bandas}" var="banda">
                                <option value="${banda.id}">${banda.nome}</option>
                            </c:forEach>
                        </select><br>
                        <input type="hidden" name="action" value="Update">
                        <input type="hidden" name="id" value="${album.id}">
                        <button class="btn waves-effect waves-light col l12" type="submit">
                            Atualizar
                        </button>
                    </form>
                </div>
            </div>
        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('select').material_select();
            });
        </script>
    </body>
</html>
