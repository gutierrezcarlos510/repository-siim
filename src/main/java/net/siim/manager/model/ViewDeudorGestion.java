package net.siim.manager.model;


import java.math.BigDecimal;

public class ViewDeudorGestion {

  private String id;
  private BigDecimal persona;
  private String nombre;
  private String paterno;
  private String materno;
  private String documento;
  private BigDecimal tipodocum;
  private String zona;
  private String barrio;
  private String xzona;
  private String xbarrio;
  private String idInmu;
  private String xtipoInmueble;
  private BigDecimal ultimaGestion;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BigDecimal getPersona() {
    return persona;
  }

  public void setPersona(BigDecimal persona) {
    this.persona = persona;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPaterno() {
    return paterno;
  }

  public void setPaterno(String paterno) {
    this.paterno = paterno;
  }

  public String getMaterno() {
    return materno;
  }

  public void setMaterno(String materno) {
    this.materno = materno;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public BigDecimal getTipodocum() {
    return tipodocum;
  }

  public void setTipodocum(BigDecimal tipodocum) {
    this.tipodocum = tipodocum;
  }

  public String getZona() {
    return zona;
  }

  public void setZona(String zona) {
    this.zona = zona;
  }

  public String getBarrio() {
    return barrio;
  }

  public void setBarrio(String barrio) {
    this.barrio = barrio;
  }

  public String getXzona() {
    return xzona;
  }

  public void setXzona(String xzona) {
    this.xzona = xzona;
  }

  public String getXbarrio() {
    return xbarrio;
  }

  public void setXbarrio(String xbarrio) {
    this.xbarrio = xbarrio;
  }

  public String getIdInmu() {
    return idInmu;
  }

  public void setIdInmu(String idInmu) {
    this.idInmu = idInmu;
  }

  public BigDecimal getUltimaGestion() {
    return ultimaGestion;
  }

  public void setUltimaGestion(BigDecimal ultimaGestion) {
    this.ultimaGestion = ultimaGestion;
  }

  public String getXtipoInmueble() {
    return xtipoInmueble;
  }

  public void setXtipoInmueble(String xtipoInmueble) {
    this.xtipoInmueble = xtipoInmueble;
  }
}
