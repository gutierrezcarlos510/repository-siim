package net.siim.manager.model;


import java.math.BigDecimal;

public class ViewConstruccion {

  private String id;
  private String idInmu;
  private String idConst;
  private BigDecimal tpConst;
  private BigDecimal supConst;
  private BigDecimal antConst;
  private BigDecimal calidad;
  private String usuario;
  private BigDecimal estado;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIdInmu() {
    return idInmu;
  }

  public void setIdInmu(String idInmu) {
    this.idInmu = idInmu;
  }

  public String getIdConst() {
    return idConst;
  }

  public void setIdConst(String idConst) {
    this.idConst = idConst;
  }

  public BigDecimal getTpConst() {
    return tpConst;
  }

  public void setTpConst(BigDecimal tpConst) {
    this.tpConst = tpConst;
  }

  public BigDecimal getSupConst() {
    return supConst;
  }

  public void setSupConst(BigDecimal supConst) {
    this.supConst = supConst;
  }

  public BigDecimal getAntConst() {
    return antConst;
  }

  public void setAntConst(BigDecimal antConst) {
    this.antConst = antConst;
  }

  public BigDecimal getCalidad() {
    return calidad;
  }

  public void setCalidad(BigDecimal calidad) {
    this.calidad = calidad;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public BigDecimal getEstado() {
    return estado;
  }

  public void setEstado(BigDecimal estado) {
    this.estado = estado;
  }
}
