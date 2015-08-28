package br.ufsm.csi.p14.model;

import javax.persistence.*;

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

    @Column(unique = true)
    private Long codigoUC;
    private String tensaoNominal;
    private Float consumo;
    private Float consumoMinimo;
    @Transient
    private RegimeOperacional regime;
    @Transient
    private Custos.BandeiraTarifaria bandeiraTarifaria;
    private String grupoTensao;
    private String classificacao;
    private Double volumeBiogas;
    private String nomePropriedade;

    public Double getVolumeBiogas() {
        return volumeBiogas;
    }

    public void setVolumeBiogas(Double volumeBiogas) {
        this.volumeBiogas = volumeBiogas;
    }

    public String getNomePropriedade() {
        return nomePropriedade;
    }

    public void setNomePropriedade(String nomePropriedade) {
        this.nomePropriedade = nomePropriedade;
    }

    public String getGrupoTensao() {
        return grupoTensao;
    }

    public void setGrupoTensao(String grupoTensao) {
        this.grupoTensao = grupoTensao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Custos.BandeiraTarifaria getBandeiraTarifaria() {
        return bandeiraTarifaria;
    }

    public void setBandeiraTarifaria(Custos.BandeiraTarifaria bandeiraTarifaria) {
        this.bandeiraTarifaria = bandeiraTarifaria;
    }

    public RegimeOperacional getRegime() {
        return regime;
    }

    public void setRegime(RegimeOperacional regime) {
        this.regime = regime;
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

    @Transient
    public Float getCusto() {
        if (getConsumo() > 500f) {
            return ((getConsumo() - 500f) * getRegime().getCustos().getCustoKWhAcima500(getBandeiraTarifaria())) + (500f * getRegime().getCustos().getCustoKWhPrimeiros500(getBandeiraTarifaria()));
        } else {
            return getConsumo() * getRegime().getCustos().getCustoKWhPrimeiros500(getBandeiraTarifaria());
        }
    }

    @Transient
    public Float getCotaParte() {
        return getRegime().getCotaParte() + getCustoDisponibilidade();
    }

    @Transient
    public Float getCustoDisponibilidade() {
        return (getConsumoMinimo() == null ? 0f : getConsumoMinimo()) * getRegime().getCustos().getCustoKWhPrimeiros500(getBandeiraTarifaria());
    }

    @Transient
    public Float getCustoOperacional() {
        return getRegime().getCustoOperacional();
    }

    @Transient
    public Float getCustoOperacionalTotal() {
        return getRegime().getCustoOperacionalTotal();
    }

    public Float getReducao() {
        return getCusto() - getCotaParte();
    }

}
