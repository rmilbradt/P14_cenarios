<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><dec:title default="P14 - Cenários" /></title>
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="all">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" media="all"/>
  <script src="js/jquery-2.1.4.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <style type="text/css">
    body {color: #777;}
    h2 {font-size: 28px; color: #000000;}
    h3 {font-size: 20px;}
  </style>
  <dec:head />
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
        <a class="navbar-brand" href="inicia-simulacao.html" style="font-size: 27px;"><b>Projeto P14 - Simulação de Cenários</b></a>
      </div>
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 16px;">Configurações<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="carregar-produtores.html">Produtores</a></li>
              <li><a href="listar-tarifas.html">Tarifas</a></li>
              <li><a href="editar-custos.html">Outros Custos</a></li>

              <%--<li role="separator" class="divider"></li>--%>

            </ul>
          </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>

  <div align="center" style="display: none" id="carreg"><img src="img/carregando.gif"/></div>

  <c:if test="${not empty sucesso}">
    <div class="alert alert-success">${sucesso}</div>
  </c:if>

  <c:if test="${not empty alerta}">
    <div class="alert alert-warning">${alerta}</div>
  </c:if>

  <c:if test="${not empty erro}">
    <div class="alert alert-danger">${erro}</div>
  </c:if>

  <div class="container">
    <dec:body />
  </div>

</div>
</body>
</html>