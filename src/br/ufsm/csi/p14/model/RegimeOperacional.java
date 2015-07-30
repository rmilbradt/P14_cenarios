package br.ufsm.csi.p14.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by politecnico on 03/07/2015.
 */
@Entity
@Table
public class RegimeOperacional {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Preencha o nome.")
    private String nome;

    @NumberFormat(pattern = "#0", style = NumberFormat.Style.NUMBER)
    @NotNull(message = "Preencha a potência.")
    private Float potencia;

    @NotNull(message = "Preencha a quantidade de horas.")
    private Integer qtdHoras;
    private Integer numProdutores;
    @Transient
    private ValoresTarifa.NomesTarifas nomeTarifa;
    @Transient
    private Map<ValoresTarifa.NomesTarifas, Map<ValoresTarifa.TiposCusto, ValoresTarifa>> valoresTarifa;
    @Transient
    private Custos custos;

    @NotNull(message = "Preencha o custo do investimento.")
    @NumberFormat(pattern = "#,##0.00", style = NumberFormat.Style.NUMBER)
    private Float custoInvestimento;

    @NotNull(message = "Preencha o custo mensal com recursos humanos.")
    @NumberFormat(pattern = "#,##0.00", style = NumberFormat.Style.NUMBER)
    private Float custoRH;

    public Float getCustoInvestimento() {
        return custoInvestimento;
    }

    public void setCustoInvestimento(Float custoInvestimento) {
        this.custoInvestimento = custoInvestimento;
    }

    public Float getCustoRH() {
        return custoRH;
    }

    public void setCustoRH(Float custoRH) {
        this.custoRH = custoRH;
    }

    public ValoresTarifa.NomesTarifas getNomeTarifa() {
        return nomeTarifa;
    }

    public void setNomeTarifa(ValoresTarifa.NomesTarifas nomeTarifa) {
        this.nomeTarifa = nomeTarifa;
    }

    public Map<ValoresTarifa.NomesTarifas, Map<ValoresTarifa.TiposCusto, ValoresTarifa>> getValoresTarifa() {
        return valoresTarifa;
    }

    public void setValoresTarifa(Map<ValoresTarifa.NomesTarifas, Map<ValoresTarifa.TiposCusto, ValoresTarifa>> valoresTarifa) {
        this.valoresTarifa = valoresTarifa;
    }

    public Custos getCustos() {
        return custos;
    }

    public void setCustos(Custos custos) {
        this.custos = custos;
    }

    public Integer getNumProdutores() {
        return numProdutores;
    }

    public void setNumProdutores(Integer numProdutores) {
        this.numProdutores = numProdutores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPotencia() {
        return potencia;
    }

    public void setPotencia(Float potencia) {
        this.potencia = potencia;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(Integer qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    @Transient
    private Float getCustoDisponibilidadeAzul() {
        if (getQtdHoras() == 24) {
            return (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.AZUL).get(ValoresTarifa.TiposCusto.FORA_PONTA).getValorFinalDemanda()) +
                    (30f * valoresTarifa.get(ValoresTarifa.NomesTarifas.AZUL).get(ValoresTarifa.TiposCusto.PONTA).getValorFinalDemanda());
        } else {
            return (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.AZUL).get(ValoresTarifa.TiposCusto.FORA_PONTA).getValorFinalDemanda());
        }
    }

    @Transient
    private Float getCustoDisponibilidadeVerde() {
        return (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.VERDE).get(ValoresTarifa.TiposCusto.NA).getValorFinalDemanda());
    }

    @Transient
    private Float getCustoDisponibilidadeConvencional() {
        return (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.CONVENCIONAL).get(ValoresTarifa.TiposCusto.NA).getValorFinalDemanda());
    }

    @Transient
    public Float getCustoDisponibilidade() {
        if (nomeTarifa == ValoresTarifa.NomesTarifas.AZUL) {
            return getCustoDisponibilidadeAzul();
        } else if (nomeTarifa == ValoresTarifa.NomesTarifas.VERDE) {
            return getCustoDisponibilidadeVerde();
        } else {
            return getCustoDisponibilidadeConvencional();
        }
    }

    @Transient
    public Float getCotaParte() {
        return (getCustoDisponibilidade() + getCustoManutencao()) / getNumProdutores();
    }

    public Float getCustoManutencao() {
        return (getCustoInvestimento() / 100f) + getCustoRH() + (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.VERDE).get(ValoresTarifa.TiposCusto.NA).getValorFinalDemanda());
    }

}
