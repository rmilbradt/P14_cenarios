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
  <link href="bootstrap/css/sticky-footer.css" rel="stylesheet">
  <script src="js/jquery-2.1.4.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <style type="text/css">
    body {color: #777;}
    h2 {font-size: 28px; color: #000000;}
    h3 {font-size: 20px;}
  </style>
  <dec:head />
</head>

<body role="document">



  <nav class="navbar navbar-inverse">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="inicia-simulacao.html">Projeto P14</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a href="inicia-simulacao.html">Início</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Configurações <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="carregar-produtores.html">Produtores</a></li>
              <li><a href="listar-tarifas.html">Tarifas</a></li>
              <li><a href="listar-regimes.html">Regimes Operacionais</a></li>
              <li><a href="editar-custos.html">Outros Custos</a></li>
            </ul>
          </li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>



  <div class="container theme-showcase">

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

  <footer class="footer">
    <div class="container" align="center">
      <img src="img/logo_horiz.png" />
    </div>
  </footer>


</body>
</html>