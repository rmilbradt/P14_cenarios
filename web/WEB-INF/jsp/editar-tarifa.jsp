<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>


<div class="page-header">
  <h2>Editar Tarifa</h2>
</div>


<form:form action="editar-tarifa.html" method="post" commandName="tarifa">
  <form:errors path="*" element="div" cssClass="alert alert-success" delimiter="li"/>
  <div class="row">
    <div class="col-lg-3">
      <form:hidden path="id" />
      <label for="nomeTarifa">Tarifa</label>
      <form:input path="nomeTarifa" type="text" class="form-control" required="true" readonly="true"/>
    </div>
    <div class="col-lg-3">
      <label for="tipoCusto">Tipo</label>
      <form:input path="tipoCusto" type="text" class="form-control" required="true" readonly="true"/>
    </div>
    <div class="col-lg-3">
      <label for="demanda">Demanda (R$/kW)</label>
      <form:input path="demanda" type="text" class="form-control" required="true" />
    </div>
  </div>
  <div class="row" style="padding-top: 15px;">
    <div class="col-lg-3">
      <label for="energiaBandVerde">Energia Band. Verde (R$/kW)</label>
      <form:input path="energiaBandVerde" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-3">
      <label for="energiaBandAmarela">Energia Band. Amarela (R$/kW)</label>
      <form:input path="energiaBandAmarela" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-3">
      <label for="energiaBandVermelha">Energia Band. Vermelha (R$/kW)</label>
      <form:input path="energiaBandVermelha" type="text" class="form-control" required="true" />
    </div>
  </div>
  <div class="row">
    <div class="col-lg-3" style="padding-top: 15px;">
      <button type="submit" class="btn btn-xs btn-default">Enviar</button>
    </div>
  </div>
</form:form>



</body>
</html>
