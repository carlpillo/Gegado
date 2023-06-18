<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Información</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<div class="container-fluid hstack gap-3">
      <input type="hidden" name="id" value="${idU }">
      
      <a class="btn btn-info mt-3 text-center" href="Controller?opcion=nuevaTransaccion">Nueva Transaccion </a>
      <label for="importe" class="form-label fst-italic mx-auto p-3"><strong><c:out value="${nombreU}"></c:out>&#129503;</strong></label>
      <a class="btn btn-info mt-3" href="Controller?id=${idU }&opcion=modificacion">Editar Usuario</a>
      <button class="btn btn-danger mt-3 ">Cerrar Sesion </button>
      
     <div class="hstack gap-3">
  <select class="form-select mt-2 " aria-label="Default select example" name="opcionBusq">
    <option selected>Método de búsqueda</option>
    <option value="gastos">Gastos</option>
    <option value="ingresos">Ingresos</option>
 
     </select>
    

   </div>
      <button class="btn btn-outline-dark" type="submit" name="search">Buscar</button>
      
</div>
 <table class="table table-hover">
        <tr>
            <th>DETALLES</th>
            <th>CATEGORIA</th>
            <th>TIPO</th>
            <th>CANTIDAD</th>
            <th>FECHA</th>
            <th>ACCIONES</th>
        </tr>

        <!--RECORRIDO FOR EACH DE LA TABLA-->
        <c:forEach var="tabla" items="${listaA}">
        <tr>
            <th><c:out value="${tabla.detalles}"></c:out></th>
            <td><c:out value="${tabla.nombreC}"/></td>
            <td><c:out value="${tabla.nombreT}"/></td>          
            <td><c:out value="${tabla.importe}"></c:out></td>
            <td><c:out value="${tabla.fechahora}"></c:out></td>
           <td>
               <a href="Controller?opcion=eliminar&pagina=1&id=<c:out value='${tabla.id}'></c:out>" class="btn fs-6"> &#128465;</a>
           </td>


        </tr>
        </c:forEach>
        </table>
</div>

</body>
</html>
<!-- Antes del pull -->
<!-- Esto es otro comentario -->