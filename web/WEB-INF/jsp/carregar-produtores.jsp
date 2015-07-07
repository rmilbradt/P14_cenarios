<%--
  Created by IntelliJ IDEA.
  User: politecnico
  Date: 10/06/2015
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Leitura Fronius</title>

  <link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="all">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" media="all"/>
  <script src="js/jquery-2.1.4.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>

  <style type="text/css">
    body {color: #777;}
    h2 {font-size: 28px; color: #000000;}
    h3 {font-size: 20px;}
  </style>
</head>

<body>

<div class="container">

  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="leitura.html" style="font-size: 27px;"><b>Simulação</b></a>
      </div>
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 16px;">Configurações<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="impostos.html">Impostos</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="custos.html">Custos</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="carregarProdutores.html">Produtores</a></li>
              <%--<li role="separator" class="divider"></li>--%>
              <%--<li><a href="relatorioOutros.html">Outros</a></li>--%>
            </ul>
          </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>

  <div align="center" style="display: none" id="carreg"><img src="imagens/carregando.gif"/></div>
  <div class="row">
    <form action="carregar-produtores.html" method="POST" enctype="multipart/form-data">
      Carregar produtores: <input name="file" type="file" /> <input type="submit" name="smt" value="Carregar...">
    </form>
  </div>

  <div class="row">
    <table>
      <tr>
        <th>Produtor</th>
        <th>Cód. UC</th>
        <th>Tensão Nominal (V)</th>
        <th>Grupo</th>
        <th>Classificação</th>
        <th>Consumo mínimo (kWh)</th>
        <th>Consumo (kWh)</th>
      </tr>
      <c:forEach items="${produtores}" var="produtor">
        <tr>
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

</div>

</body>

</html>