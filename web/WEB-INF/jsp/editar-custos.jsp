<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>


<div class="container page-header">
  <h1>Editar Outros Custos</h1>
</div>


<form:form action="editar-custos.html" method="post" commandName="custos">
  <form:errors path="*" element="div" cssClass="alert alert-success" delimiter="li"/>
  <div class="row">
    <div class="col-lg-4">
      <form:hidden path="id" />
      <label for="pis">PIS</label>
      <form:input path="pis" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-4">
      <label for="cofins">Cofins</label>
      <form:input path="cofins" type="text" class="form-control" required="true"/>
    </div>
  </div>
  <div class="row" style="padding-top: 15px;">
    <div class="col-lg-4">
      <label for="icmsMenos500">ICMS - Abaixo de 500 kWh</label>
      <form:input path="icmsMenos500" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-4">
      <label for="icmsMais500">ICMS - Acima de 500 kWh</label>
      <form:input path="icmsMais500" type="text" class="form-control" required="true" />
    </div>
  </div>
  <div class="row" style="padding-top: 15px;">
    <div class="col-lg-3">
      <label for="custoKWhVerde">Custo kWh Band. Verde</label>
      <form:input path="custoKWhVerde" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-3">
      <label for="custoKWhAmarela">Custo kWh Band. Amarela</label>
      <form:input path="custoKWhAmarela" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-3">
      <label for="custoKWhVermelha">Custo kWh Band. Vermelha</label>
      <form:input path="custoKWhVermelha" type="text" class="form-control" required="true" />
    </div>
  </div>
  <div class="row" style="padding-top: 15px;">
    <div class="col-lg-3">
      <button type="submit" class="btn btn-sm btn-primary">Enviar</button>
    </div>
  </div>
</form:form>



</body>
</html>