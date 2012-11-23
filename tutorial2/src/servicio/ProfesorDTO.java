package servicio;

public class ProfesorDTO {
  String cedula;
  String nombre;
  String titulo;
  String area;
  String correo;
  String telefono;
  public void setCedula(String ced) {this.cedula = ced;}
  public void setNombre(String nomb) {this.nombre = nomb;}
  public void setTitulo(String tit) {this.titulo = tit;}
  public void setArea(String area) {this.area = area;}
  public void setCorreo(String corr) {this.correo = corr;}
  public void setTelefono(String tel) {this.telefono = tel;}
  public String getCedula() { return cedula; }
  public String getNombre() { return nombre; }
  public String getTitulo() { return titulo; }
  public String getArea() { return area; }
  public String getCorreo() { return correo; }
  public String getTelefono() { return telefono; }
}