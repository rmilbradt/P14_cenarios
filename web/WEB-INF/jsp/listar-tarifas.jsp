<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

<c:if test="${not empty tarifas}">
  <div class="container page-header">
    <h1>Valores de Tarifas</h1>
  </div>

  <div class="row">
    <table class="table table-striped table-bordered">
      <tr>
        <th>Tarifa</th>
        <th>Tipo</th>
        <th style="text-align: right;">Demanda (R$/kW)</th>
        <th style="background-color: #67b168; text-align: right;">Energia (R$/kWh)</th>
        <th style="background-color: khaki; text-align: right;">Energia (R$/kWh)</th>
        <th style="background-color: tomato; text-align: right;">Energia (R$/kWh)</th>
        <th></th>
      </tr>
      <c:forEach items="${tarifas}" var="tarifa">
        <tr>
          <td>${tarifa.nomeTarifa}</td>
          <td>${tarifa.tipoCusto}</td>
          <td style="text-align: right;"><fmt:formatNumber value="${tarifa.demanda}" pattern="#0.00000" /></td>
          <td style="text-align: right;"><fmt:formatNumber value="${tarifa.energiaBandVerde}" pattern="#0.00000" /></td>
          <td style="text-align: right;"><fmt:formatNumber value="${tarifa.energiaBandAmarela}" pattern="#0.00000" /></td>
          <td style="text-align: right;"><fmt:formatNumber value="${tarifa.energiaBandVermelha}" pattern="#0.00000" /></td>
          <td style="text-align: center;">
            <a href="editar-tarifa.html?id=${tarifa.id}" class="btn btn-sm btn-primary" >Editar</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</c:if>
</body>
</html>