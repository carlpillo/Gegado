
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
<head>
  <title>Gegado</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container text-center">
<h2 class="text-center">Alta de cliente</h2>
  <hr>
  <form class="row g-3 needs-validation" novalidate action="Controller" method="post">
      <input type="hidden" name="opcion" value="alta">
  
 <div class="col-md-4 col-xl-4 mx-auto">
      <label for="nombre" class="form-label">Nombre y Apellidos</label>
      <input type="text" class="form-control text-capitalize"  name="nombre" id="nombre" maxlength="50" placeholder="Nombre y Apellidos" required>
      <div class="invalid-feedback">
      Nombre está mal o está vacío
      </div>
    </div>
  <div class="col-md-4 col-xl-4 mx-auto">
      <label for="nombreU" class="form-label">Nombre Usuario</label>
      <input type="text" class="form-control"  name="nombreU" id="nombreU" maxlength="50" placeholder="Nombre" required>
      <div class="invalid-feedback">
      Nombre de usuario vacío o mal
      </div>
    </div>
   <div class="row-md-3 col-xl-3 mx-auto pb-3 text-center">
  <div class="col-auto">
    <label for="passU" class="col-form-label" >Password</label>
  </div>
  <div class="col-auto">
    <input type="password" id="passU" name="passU" class="form-control" aria-labelledby="passwordHelpInline" pattern="(?=.*\d)(?=.*[\W_]).{8,}" required placeholder="8 caracteres mínimo, debe teber un caracter especial y numero">
     <div class="invalid-feedback">
      Contraseña Maaaaaaaal
      </div>
  </div>
   
  <div class="col-auto">

  </div>
</div>
<div class="row">
<hr>
<div class="col mt-auto ms-3">
      <button class="btn btn-primary" type="submit">Dar alta</button>
    </div>
    <div class="col-6">
      <a class="btn btn-primary" href="index.jsp">Cancelar </a>
</div>
    </div>
</form>
<script src="<c:url value="js/script.js"/>"></script>

</div>


</body>
</html>
<!-- Antes del pull -->
<!-- Esto es otro comentario -->