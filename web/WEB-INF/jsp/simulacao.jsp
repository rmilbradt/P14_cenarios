<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:if test="${not empty produtores}">
    <div class="page-header">
        <h2>Produtores</h2>
    </div>

    <c:set var="sumConsumo" value="${0}" />
    <c:set var="sumCusto" value="${0}" />
    <c:set var="sumCotaParte" value="${0}" />
    <c:set var="sumReducao" value="${0}" />

    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>Produtor</th>
                <th style="text-align: right;">Cód. UC</th>
                <th style="text-align: right;">Tensão Nominal (V)</th>
                <th style="text-align: right;">Consumo (kWh)</th>
                <th style="text-align: right;">Custo (R$)</th>
                <th style="text-align: right;">Cota Parte (R$)</th>
                <th style="text-align: right;">Redução (R$)</th>
            </tr>
            <c:forEach items="${produtores}" var="produtor">
                <tr>
                    <td>${produtor.nome}</td>
                    <td style="text-align: right;">${produtor.codigoUC}</td>
                    <td style="text-align: right;">${produtor.tensaoNominal}</td>
                    <td style="text-align: right;"><fmt:formatNumber value="${produtor.consumo}" pattern="#0" /><c:set var="sumConsumo" value="${sumConsumo + produtor.consumo}" /></td>
                    <td style="text-align: right;"><fmt:formatNumber value="${produtor.custo}" pattern="#,##0.00" /><c:set var="sumCusto" value="${sumCusto + produtor.custo}" /></td>
                    <td style="text-align: right;"><fmt:formatNumber value="${produtor.cotaParte}" pattern="#,##0.00" /><c:set var="sumCotaParte" value="${sumCotaParte + produtor.cotaParte}" /></td>
                    <td style="text-align: right;"><fmt:formatNumber value="${produtor.reducao}" pattern="#,##0.00" /><c:set var="sumReducao" value="${sumReducao + produtor.reducao}" /></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" style="font-weight: bold; text-align: right;">Total</td>
                <td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumConsumo}" pattern="#0" /></td>
                <td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumCusto}" pattern="#,##0.00" /></td>
                <td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumCotaParte}" pattern="#,##0.00" /></td>
                <td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumReducao}" pattern="#,##0.00" /></td>
            </tr>
        </table>
    </div>
    <div class="row">
        <p>Cota Parte Regime: <fmt:formatNumber value="${regimeOperacional.cotaParte}" pattern="#,##0.00" /></p>
        <p>Custo Disponibilidade do Regime: <fmt:formatNumber value="${regimeOperacional.custoDisponibilidade}" pattern="#,##0.00" /></p>
        <p>Num. Produtores: ${regimeOperacional.numProdutores}</p>
        <p>Custo kWh Primeiros 500: <fmt:formatNumber value="${custoAbaixo500}" pattern="#0.0000" /></p>
        <p>Custo kWh Acima 500: <fmt:formatNumber value="${custoAcima500}" pattern="#0.0000" /></p>
    </div>
</c:if>