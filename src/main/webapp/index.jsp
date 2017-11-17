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
        <title>Álbuns</title>
    </head>
    <body>
        
        <m:get descricao="albuns" />
        <div class="container">
            <center><h2>Álbuns</h2></center>
            <div class="row">
                <a href="novo.jsp" class="waves-effect waves-light btn">Novo</a>
            </div>
            <div class="row">
                <table>
                    <thead>
                      <tr>
                          <th>Estilo</th>
                          <th>Banda</th>
                          <th>Lançamento</th>
                      </tr>
                    </thead>
                    <tbody>  
                        <c:forEach items="${albuns}" var="album">  
                            <tr>
                                <td>${album.estilo.toString()}</td>
                                <td>${album.banda.nome}</td>
                                <td>${album.lancamento.toString()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
