package br.ufsm.csi.p14.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Float custoKWhPrimeiros500;
    private Float custoKWhAcima500;

    public Float getCustoKWhPrimeiros500() {
        return custoKWhPrimeiros500;
    }

    public void setCustoKWhPrimeiros500(Float custoKWhPrimeiros500) {
        this.custoKWhPrimeiros500 = custoKWhPrimeiros500;
    }

    public Float getCustoKWhAcima500() {
        return custoKWhAcima500;
    }

    public void setCustoKWhAcima500(Float custoKWhAcima500) {
        this.custoKWhAcima500 = custoKWhAcima500;
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
