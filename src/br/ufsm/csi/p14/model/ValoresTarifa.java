package br.ufsm.csi.p14.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by politecnico on 03/07/2015.
 */
@Entity
@Table
public class ValoresTarifa {

    @Id
    @GeneratedValue
    private Long id;

    //verde, azul ou convencional
    private String nomeTarifa;

    @NumberFormat(pattern = "#0.00000", style = NumberFormat.Style.NUMBER)
    @NotNull(message = "Preencha o valor da demanda.")
    private Float demanda;

    @NumberFormat(pattern = "#0.00000", style = NumberFormat.Style.NUMBER)
    @NotNull(message = "Preencha o valor da energia em bandeira verde.")
    private Float energiaBandVerde;

    @NumberFormat(pattern = "#0.00000", style = NumberFormat.Style.NUMBER)
    @NotNull(message = "Preencha o valor da energia em bandeira amarela.")
    private Float energiaBandAmarela;

    @NumberFormat(pattern = "#0.00000", style = NumberFormat.Style.NUMBER)
    @NotNull(message = "Preencha o valor da energia em bandeira vermelha.")
    private Float energiaBandVermelha;

    //na, ponta e fora de ponta
    private String tipoCusto;

    @Transient
    private Custos custos;

    public enum NomesTarifas { VERDE, AZUL, CONVENCIONAL }
    public enum TiposCusto { NA, PONTA, FORA_PONTA }

    public Custos getCustos() {
        return custos;
    }

    public void setCustos(Custos custos) {
        this.custos = custos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarifa() {
        return nomeTarifa;
    }

    public void setNomeTarifa(String nomeTarifa) {
        this.nomeTarifa = nomeTarifa;
    }

    public Float getDemanda() {
        return demanda;
    }

    public void setDemanda(Float demanda) {
        this.demanda = demanda;
    }

    public Float getEnergiaBandVerde() {
        return energiaBandVerde;
    }

    public void setEnergiaBandVerde(Float energiaBandVerde) {
        this.energiaBandVerde = energiaBandVerde;
    }

    public Float getEnergiaBandAmarela() {
        return energiaBandAmarela;
    }

    public void setEnergiaBandAmarela(Float energiaBandAmarela) {
        this.energiaBandAmarela = energiaBandAmarela;
    }

    public Float getEnergiaBandVermelha() {
        return energiaBandVermelha;
    }

    public void setEnergiaBandVermelha(Float energiaBandVermelha) {
        this.energiaBandVermelha = energiaBandVermelha;
    }

    public String getTipoCusto() {
        return tipoCusto;
    }

    public void setTipoCusto(String tipoCusto) {
        this.tipoCusto = tipoCusto;
    }

    @Transient
    public Float getValorFinalDemanda() {
        return getDemanda() / ((100f - (getCustos().getCofins() + getCustos().getPis() + getCustos().getIcmsMenos500())) / 100f);
    }

    @Transient
    public Float getValorFinalEnergiaBandVerde() {
        return getEnergiaBandVerde() / ((100f - (getCustos().getCofins() + getCustos().getPis() + getCustos().getIcmsMenos500())) / 100f);
    }

    @Transient
    public Float getValorFinalEnergiaBandAmarela() {
        return getEnergiaBandAmarela() / ((100f - (getCustos().getCofins() + getCustos().getPis() + getCustos().getIcmsMenos500())) / 100f);
    }

    @Transient
    public Float getValorFinalEnergiaBandVermelha() {
        return getEnergiaBandVermelha() / ((100f - (getCustos().getCofins() + getCustos().getPis() + getCustos().getIcmsMenos500())) / 100f);
    }

}
