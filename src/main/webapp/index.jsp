<%@taglib  prefix="m"  uri="/WEB-INF/DescritorTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Álbuns</title>
    </head>
    <body>
        <h1>Todos os albuns</h1>
        <m:retornaAlbuns/>
        <c:forEach items="albuns" var="album">
            
            
        </c:forEach>
    </body>
</html>
