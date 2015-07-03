package br.ufsm.csi.p14.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by politecnico on 26/05/2015.
 */
@Entity
@Table
public class Produtor {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private Long codigoUC;
    private String tensaoNominal;
    private Float consumo;
    private Float consumoMinimo;

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

    public Long getCodigoUC() {
        return codigoUC;
    }

    public void setCodigoUC(Long codigoUC) {
        this.codigoUC = codigoUC;
    }

    public String getTensaoNominal() {
        return tensaoNominal;
    }

    public void setTensaoNominal(String tensaoNominal) {
        this.tensaoNominal = tensaoNominal;
    }

    public Float getConsumo() {
        return consumo;
    }

    public void setConsumo(Float consumo) {
        this.consumo = consumo;
    }

    public Float getConsumoMinimo() {
        return consumoMinimo;
    }

    public void setConsumoMinimo(Float consumoMinimo) {
        this.consumoMinimo = consumoMinimo;
    }
}
