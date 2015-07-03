package br.ufsm.csi.p14.model;

import javax.persistence.*;

/**
 * Created by politecnico on 03/07/2015.
 */
@Entity
@Table
public class ValoresTarifa {

    @Id
    @GeneratedValue
    private Long id;

    private String nomeTarifa;
    private Float demanda;
    private Float energiaBandVerde;
    private Float energiaBandAmarela;
    private Float energiaBandVermelha;
    private String tipoCusto;

    @ManyToOne
    @JoinColumn(name = "ID_TRIBUTOS")
    private Tributos tributos;

    enum NomesTarifas { VERDE, AZUL, CONVENCIONAL }
    enum TiposCusto { NA, PONTA, FORA_PONTA }

    public Tributos getTributos() {
        return tributos;
    }

    public void setTributos(Tributos tributos) {
        this.tributos = tributos;
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
        return null;
    }

    @Transient
    public Float getValorFinalEnergiaBandVerde() {
        return null;
    }

    @Transient
    public Float getValorFinalEnergiaBandAmarela() {
        return null;
    }

    @Transient
    public Float getValorFinalEnergiaBandVermelha() {
        return null;
    }


}
