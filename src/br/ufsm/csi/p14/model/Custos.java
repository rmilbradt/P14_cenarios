package br.ufsm.csi.p14.model;

import javax.persistence.*;

/**
 * Created by politecnico on 03/07/2015.
 */
@Entity
@Table
public class Custos {

    @Id
    @GeneratedValue
    private Long id;

    private Float pis;
    private Float cofins;
    private Float icmsMenos500;
    private Float icmsMais500;
    private Float custoKWhVerde;
    private Float custoKWhAmarela;
    private Float custoKWhVermelha;

    public Float getCustoKWh(BandeiraTarifaria bandeiraTarifaria) {
        if (bandeiraTarifaria == BandeiraTarifaria.VERDE) {
            return getCustoKWhVerde();
        } else if (bandeiraTarifaria == BandeiraTarifaria.AMARELA) {
            return getCustoKWhAmarela();
        } else {
            return getCustoKWhVermelha();
        }
    }

    public Float getCustoKWhVerde() {
        return custoKWhVerde;
    }

    public void setCustoKWhVerde(Float custoKWhVerde) {
        this.custoKWhVerde = custoKWhVerde;
    }

    public Float getCustoKWhAmarela() {
        return custoKWhAmarela;
    }

    public void setCustoKWhAmarela(Float custoKWhAmarela) {
        this.custoKWhAmarela = custoKWhAmarela;
    }

    public Float getCustoKWhVermelha() {
        return custoKWhVermelha;
    }

    public void setCustoKWhVermelha(Float custoKWhVermelha) {
        this.custoKWhVermelha = custoKWhVermelha;
    }

    public enum BandeiraTarifaria { VERDE, AMARELA, VERMELHA }

    @Transient
    public Float getCustoKWhPrimeiros500(BandeiraTarifaria bandeiraTarifaria) {
        return (getCustoKWh(bandeiraTarifaria) / ((100-(getPis() + getCofins() + getIcmsMenos500())) / 100));
    }

    @Transient
    public Float getCustoKWhAcima500(BandeiraTarifaria bandeiraTarifaria) {
        return (getCustoKWh(bandeiraTarifaria) / ((100-(getPis() + getCofins() + getIcmsMais500())) / 100));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPis() {
        return pis;
    }

    public void setPis(Float pis) {
        this.pis = pis;
    }

    public Float getCofins() {
        return cofins;
    }

    public void setCofins(Float cofins) {
        this.cofins = cofins;
    }

    public Float getIcmsMenos500() {
        return icmsMenos500;
    }

    public void setIcmsMenos500(Float icmsMenos500) {
        this.icmsMenos500 = icmsMenos500;
    }

    public Float getIcmsMais500() {
        return icmsMais500;
    }

    public void setIcmsMais500(Float icmsMais500) {
        this.icmsMais500 = icmsMais500;
    }
}
