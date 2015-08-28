<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:if test="${not empty mapProdutores}">
    <div class="container page-header">
        <h2>Produtores</h2>
    </div>

    <c:set var="sumConsumo" value="${0}" />
    <c:set var="sumCusto" value="${0}" />
    <c:set var="sumCotaParte" value="${0}" />
    <c:set var="sumReducao" value="${0}" />
    <c:set var="sumBiogas" value="${0}" />

    <!-- calcula custo total -->
    <c:set var="custoTotal" value="${0}" />
    <c:set var="biogasTotal" value="${0}" />
    <c:forEach items="${mapProdutores}" var="entry">
        <c:forEach items="${entry.value}" var="produtor" varStatus="st">
            <c:set var="custoTotal" value="${custoTotal + produtor.custo}" />
            <c:set var="biogasTotal" value="${biogasTotal + produtor.volumeBiogas}" />
        </c:forEach>
    </c:forEach>

    <div class="row">
        <table class="table table-striped table-bordered">
            <tr>
                <th colspan="4" rowspan="2"></th>
                <th colspan="3" style="text-align: center;">Sistema Atual de Faturamento</th>
                <th colspan="11" style="text-align: center;">Sistema de Compensação Financeira</th>
            </tr>
            <tr>
                <th colspan="3"></th>
                <th colspan="4" style="text-align: center;">Divisão igualitária</th>
                <th colspan="3" style="text-align: center;">Divisão prop. ao consumo</th>
                <th colspan="4" style="text-align: center;">Divisão prop. à produção de biogás</th>
            </tr>
            <tr>
                <th>Propriedade</th>
                <th>Produtor</th>
                <th style="text-align: right;">Cód. UC</th>
                <th style="text-align: right;">Tensão Nominal (V)</th>

                <th style="text-align: right;">Consumo (kWh)</th>
                <th style="text-align: right;">Custo UC (R$)</th>
                <th style="text-align: right;">Custo (R$)</th>

                <th style="text-align: right;">Disponib. UC (R$)</th>
                <th style="text-align: right;">Custo Operacional (R$)</th>
                <th style="text-align: right;">Custo Energia (R$)</th>
                <th style="text-align: right;">Redução (R$)</th>

                <th style="text-align: right;">Custo Operacional (R$)</th>
                <th style="text-align: right;">Custo Energia (R$)</th>
                <th style="text-align: right;">Redução (R$)</th>

                <th style="text-align: right;">Volume Biogás (m³)</th>
                <th style="text-align: right;">Custo Operacional (R$)</th>
                <th style="text-align: right;">Custo Energia (R$)</th>
                <th style="text-align: right;">Redução (R$)</th>
            </tr>
            <c:forEach items="${mapProdutores}" var="entry">
                <c:set var="custoProp" value="${0}" />
                <c:set var="custoDisp" value="${0}" />
                <c:set var="volBiogas" value="${0}" />
                <c:forEach items="${entry.value}" var="produtor" varStatus="st">
                    <c:set var="custoProp" value="${custoProp + produtor.custo}" />
                    <c:set var="custoDisp" value="${custoDisp + produtor.custoDisponibilidade}" />
                    <c:set var="volBiogas" value="${volBiogas + produtor.volumeBiogas}" />
                </c:forEach>
                <c:forEach items="${entry.value}" var="produtor" varStatus="st">
                    <tr>
                        <c:if test="${st.first}">
                            <th rowspan="${fn:length(entry.value)}" style="vertical-align: middle;">${produtor.nomePropriedade}</th>
                        </c:if>
                        <td>${produtor.nome}</td>
                        <td style="text-align: right; vertical-align: middle;">${produtor.codigoUC}</td>
                        <td style="text-align: right; vertical-align: middle;">${produtor.tensaoNominal}</td>

                        <!-- INICIO Custo Atual-->
                        <td style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${produtor.consumo}" pattern="#0" /><c:set var="sumConsumo" value="${sumConsumo + produtor.consumo}" /></td>
                        <td style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${produtor.custo}" pattern="#,##0.00" /><c:set var="sumCusto" value="${sumCusto + produtor.custo}" /></td>
                        <c:if test="${st.first}">
                            <td style="text-align: right;vertical-align: middle;" rowspan="${fn:length(entry.value)}"><fmt:formatNumber value="${custoProp}" pattern="#,##0.00" /></td>
                        </c:if>
                        <!-- FIM Custo Atual-->

                        <!-- INICIO Custo Div Igualitaria-->
                        <td style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${produtor.custoDisponibilidade}" pattern="#,##0.00" /></td>
                        <c:if test="${st.first}">
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${produtor.custoOperacional}" pattern="#,##0.00" /></td>
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${custoDisp + produtor.custoOperacional}" pattern="#,##0.00" /></td>
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${custoProp - (custoDisp + produtor.custoOperacional)}" pattern="#,##0.00" /><c:set var="sumReducao" value="${sumReducao + (produtor.custo - (custoDisp + produtor.custoOperacional))}" /></td>
                        </c:if>
                        <!-- FIM Custo Div Igualitaria-->

                        <!-- INICIO Custo Div Consumo-->
                        <c:if test="${st.first}">
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${produtor.custoOperacionalTotal * (custoProp / custoTotal)}" pattern="#,##0.00" /></td>
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${(produtor.custoOperacionalTotal * (custoProp / custoTotal)) + custoDisp}" pattern="#,##0.00" /></td>
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${custoProp - ((produtor.custoOperacionalTotal * (custoProp / custoTotal)) + custoDisp)}" pattern="#,##0.00" /></td>
                        </c:if>
                        <%--<!-- FIM Custo Div Consumo-->--%>

                        <%--<!-- INICIO Custo Div Prod Biogas-->--%>
                        <c:if test="${st.first}">
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${volBiogas}" pattern="#,##0.00" /></td>
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${produtor.custoOperacionalTotal * (volBiogas / biogasTotal)}" pattern="#,##0.00" /></td>
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${(produtor.custoOperacionalTotal * (volBiogas / biogasTotal)) + custoDisp}" pattern="#,##0.00" /></td>
                            <td rowspan="${fn:length(entry.value)}" style="text-align: right; vertical-align: middle;"><fmt:formatNumber value="${custoProp - ((produtor.custoOperacionalTotal * (volBiogas / biogasTotal)) + custoDisp)}" pattern="#,##0.00" /></td>
                        </c:if>
                        <!-- FIM Custo Div Prod Biogas-->
                    </tr>
                </c:forEach>
            </c:forEach>
            <%--<tr>--%>
                <%--<td colspan="4" style="font-weight: bold; text-align: right;">Total</td>--%>
                <%--<td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumConsumo}" pattern="#0" /></td>--%>
                <%--<td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumBiogas}" pattern="#0,00" /></td>--%>
                <%--<td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumCusto}" pattern="#,##0.00" /></td>--%>
                <%--<td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumCotaParte}" pattern="#,##0.00" /></td>--%>
                <%--<td style="font-weight: bold; text-align: right;"><fmt:formatNumber value="${sumReducao}" pattern="#,##0.00" /></td>--%>
            <%--</tr>--%>
        </table>
    </div>
    <%--<div class="row">--%>
        <%--<p>Cota Parte Regime: <fmt:formatNumber value="${regimeOperacional.cotaParte}" pattern="#,##0.00" /></p>--%>
        <%--<p>Custo Disponibilidade do Regime: <fmt:formatNumber value="${regimeOperacional.custoDisponibilidade}" pattern="#,##0.00" /></p>--%>
        <%--<p>Num. Produtores: ${regimeOperacional.numProdutores}</p>--%>
        <%--<p>Custo kWh Primeiros 500: <fmt:formatNumber value="${custoAbaixo500}" pattern="#0.0000" /></p>--%>
        <%--<p>Custo kWh Acima 500: <fmt:formatNumber value="${custoAcima500}" pattern="#0.0000" /></p>--%>
    <%--</div>--%>
</c:if>