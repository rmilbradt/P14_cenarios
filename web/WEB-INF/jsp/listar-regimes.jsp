<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

<c:if test="${not empty regimes}">
  <div class="container page-header">
    <h1>Regimes Operacionais <a href="editar-regime.html" class="btn btn-sm btn-primary">Novo Regime</a></h1>
  </div>

  <div class="row">
    <table class="table table-striped table-bordered">
      <tr>
        <th>Nome</th>
        <th style="text-align: right;">Qtd. Horas</th>
        <th style="text-align: right;">Potência (kW)</th>
        <th style="text-align: center;">Ações</th>
      </tr>
      <c:forEach items="${regimes}" var="regime">
        <tr>
          <td>${regime.nome}</td>
          <td style="text-align: right;"><fmt:formatNumber value="${regime.qtdHoras}" pattern="#0" /></td>
          <td style="text-align: right;"><fmt:formatNumber value="${regime.potencia}" pattern="#0" /></td>
          <td style="text-align: center;">
            <a href="editar-regime.html?id=${regime.id}" class="btn btn-sm btn-primary">Editar</a>
            <a href="remover-regime.html?id=${regime.id}" class="btn btn-sm btn-primary" onclick="return confirm('Tem certeza de que deseja remover?');">Remover</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</c:if>
</body>
</html>