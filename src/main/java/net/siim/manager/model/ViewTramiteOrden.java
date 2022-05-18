package net.siim.manager.model;


public class ViewTramiteOrden {

  private String id;
  private String formulario;
  private java.sql.Date fecha;
  private String hora;
  private String orden;
  private String usuario;
  private String nombre;
  private String paterno;
  private String materno;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getFormulario() {
    return formulario;
  }

  public void setFormulario(String formulario) {
    this.formulario = formulario;
  }


  public java.sql.Date getFecha() {
    return fecha;
  }

  public void setFecha(java.sql.Date fecha) {
    this.fecha = fecha;
  }


  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }


  public String getOrden() {
    return orden;
  }

  public void setOrden(String orden) {
    this.orden = orden;
  }


  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
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

}
