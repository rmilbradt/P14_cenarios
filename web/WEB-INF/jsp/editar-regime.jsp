<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>


<div class="container page-header">
  <h1>Editar Regime Operacional</h1>
</div>


<form:form action="editar-regime.html" method="post" commandName="regime">
  <form:errors path="*" element="div" cssClass="alert alert-success" delimiter="li"/>
  <div class="row">
    <div class="col-lg-3">
      <form:hidden path="id" />
      <label for="nome">Nome</label>
      <form:input path="nome" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-3">
      <label for="qtdHoras">Qtd. Horas</label>
      <form:input path="qtdHoras" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-3">
      <label for="potencia">Potência (kW)</label>
      <form:input path="potencia" type="text" class="form-control" required="true" />
    </div>
  </div>
  <div class="row" style="padding-top: 15px;">
    <div class="col-lg-3">
      <label for="custoInvestimento">Custo do Investimento (R$)</label>
      <form:input path="custoInvestimento" type="text" class="form-control" required="true" />
    </div>
    <div class="col-lg-3">
      <label for="custoRH">Custo Mensal com RH (R$)</label>
      <form:input path="custoRH" type="text" class="form-control" required="true" />
    </div>
  </div>
  <div class="row">
    <div class="col-lg-3" style="padding-top: 15px;">
      <button type="submit" class="btn btn-sm btn-primary">Enviar</button>
    </div>
  </div>

</form:form>



</body>
</html>