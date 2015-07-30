<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <script type="text/javascript">
      function iniciarSimulacao() {
        var reg = $(regime).val();
        var tar = $(tarifa).val();
        var band = $(bandeira).val();
        if (reg != null && reg != '' && tar != null && tar != '' && band != null && band != '') {
          document.getElementById('carreg').style.display = 'block';
          $.ajax({
            url: "simulacao.ajax?regime="+reg+"&tarifa="+tar + "&bandeira=" + band,
            context: document.body,
            success: function(result) {
                 document.getElementById('conteudo-simulacao').innerHTML = result;
            }
          }).done(function() {
            document.getElementById('carreg').style.display = 'none';
            document.getElementById('jumbo').style.display = 'none';
          });
        }
      }
    </script>
      </head>
  <body>
    <div class="jumbotron" style="height: 300px;" id="jumbo">
      <div class="row">
        <div class="col-md-6">
          <h1>Projeto P14</h1>
          <p>ipsun lorem</p>
        </div>
        <div class="col-md-6">
          <img src="img/logo_grande.png" />
        </div>
      </div>
    </div>
    <div class="container page-header">
      <h1>Iniciar Simulação</h1>
    </div>
    <div class="row">
      <div class="col-lg-2">
        <label for="regime">Regime de Operação</label>
        <select id="regime" name="regime" class="form-control">
          <option></option>
          <c:forEach items="${regimes}" var="regime">
            <option value="${regime.id}">${regime.nome}</option>
          </c:forEach>
        </select>
      </div>
      <div class="col-lg-2">
        <label for="tarifa">Tarifa</label>
        <select id="tarifa" name="tafira" class="form-control">
          <option></option>
          <c:forEach items="${tarifas}" var="tarifa">
            <option value="${tarifa}">${tarifa}</option>
          </c:forEach>
        </select>
      </div>
      <div class="col-lg-2">
        <label for="bandeira">Bandeira</label>
        <select id="bandeira" name="bandeira" class="form-control">
          <option></option>
          <c:forEach items="${bandeiras}" var="bandeira">
            <option value="${bandeira}">${bandeira}</option>
          </c:forEach>
        </select>
      </div>
      <div class="col-lg-1" >
        <p>&nbsp;</p>
        <button type="button" class="btn btn-sm btn-primary" style="vertical-align: text-bottom;" onclick="iniciarSimulacao();">Simular Cenário</button>
      </div>
    </div>
    <div class="container" align="center" style="display: none;" id="carreg"><img src="img/carregando.gif"/></div>
    <div class="container" id="conteudo-simulacao"></div>
  </body>
</html>