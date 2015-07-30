<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

  <c:if test="${not empty produtores}">
    <div class="container page-header">
      <h1>Produtores</h1>
    </div>

    <div class="row">
      <table class="table table-striped">
        <tr>
          <th>#</th>
          <th>Produtor</th>
          <th>Cód. UC</th>
          <th>Tensão Nominal (V)</th>
          <th>Grupo</th>
          <th>Classificação</th>
          <th>Consumo mínimo (kWh)</th>
          <th>Consumo (kWh)</th>
        </tr>
        <c:forEach items="${produtores}" var="produtor" varStatus="st">
          <tr>
            <td>${st.count}</td>
            <td>${produtor.nome}</td>
            <td>${produtor.codigoUC}</td>
            <td>${produtor.tensaoNominal}</td>
            <td>${produtor.grupoTensao}</td>
            <td>${produtor.classificacao}</td>
            <td><fmt:formatNumber value="${produtor.consumoMinimo}" pattern="#0" /></td>
            <td><fmt:formatNumber value="${produtor.consumo}" pattern="#0" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </c:if>

  <div class="row">
    <h3>Carregar produtores</h3>
    <form action="carregar-produtores.html" method="POST" enctype="multipart/form-data">
      <p>Arquivo CSV: <input name="file" type="file" /> </p>
      <p><button type="submit" class="btn btn-sm btn-primary">Carregar</button></p>
    </form>
  </div>
</body>
</html>