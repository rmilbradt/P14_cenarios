package br.ufsm.csi.p14.model;

import javax.persistence.*;
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
    private String nome;
    private Float potencia;
    private Integer qtdHoras;
    private Integer numProdutores;
    @Transient
    private Map<String, Map<String, ValoresTarifa>> valoresTarifa;
    @Transient
    private Custos custos;

    public Map<String, Map<String, ValoresTarifa>> getValoresTarifa() {
        return valoresTarifa;
    }

    public void setValoresTarifa(Map<String, Map<String, ValoresTarifa>> valoresTarifa) {
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
    public Float getCustoDisponibilidadeAzul() {
        if (getQtdHoras() == 24) {
            return (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.AZUL).get(ValoresTarifa.TiposCusto.FORA_PONTA).getValorFinalDemanda()) +
                    (getNumProdutores() * valoresTarifa.get(ValoresTarifa.NomesTarifas.AZUL).get(ValoresTarifa.TiposCusto.PONTA).getValorFinalDemanda());
        } else {
            return (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.AZUL).get(ValoresTarifa.TiposCusto.FORA_PONTA).getValorFinalDemanda());
        }
    }

    @Transient
    public Float getCustoDisponibilidadeVerde() {
        return (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.VERDE).get(ValoresTarifa.TiposCusto.NA).getValorFinalDemanda());
    }

    @Transient
    public Float getCustoDisponibilidadeConvencional() {
        return (getPotencia() * valoresTarifa.get(ValoresTarifa.NomesTarifas.CONVENCIONAL).get(ValoresTarifa.TiposCusto.NA).getValorFinalDemanda());
    }

    @Transient
    public Float getCotaParteAzul() {
        return getCustoDisponibilidadeAzul() / getNumProdutores();
    }

    @Transient
    public Float getCotaParteVerde() {
        return getCustoDisponibilidadeVerde() / getNumProdutores();
    }

    @Transient
    public Float getCotaParteConvencional() {
        return getCustoDisponibilidadeConvencional() / getNumProdutores();
    }

}
