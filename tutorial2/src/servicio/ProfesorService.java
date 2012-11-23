package servicio;
import java.util.*;

public class ProfesorService {

  private Map<String,ProfesorDTO> profesores;

  private static String[][] data = {
    {"101110111","Estadistica","Carlos Perez","Licenciado","carlos@xyz.com","3456-7890"},
    {"202220222","Matematica","Luis Torres","Master","luis@xyz.com","6677-3456"},
    {"303330333","Administracion","Juan Castro","Licenciado","castro@xyz.com","67455-7788"},
    {"404440444","Quimica","Joaquin Soto","Ingeniero","joaquin@xyz.com","3333-7890"}};

  ProfesorService() {
    profesores = new HashMap<String,ProfesorDTO>();
    for (int i=0;i<data.length;i++) {
      ProfesorDTO prof = new ProfesorDTO();
      prof.setCedula(data[i][0]);
      prof.setArea(data[i][1]);
      prof.setNombre(data[i][2]);
      prof.setTitulo(data[i][3]);
      prof.setCorreo(data[i][4]);
      prof.setTelefono(data[i][5]);
      profesores.put(prof.getCedula(),prof);
    }
  }

  protected ProfesorDTO find(String profesorID) {
    if (profesores.containsKey(profesorID))
      return (ProfesorDTO)profesores.get(profesorID);
    else
      return null;
  }

  protected List<ProfesorDTO> findAll() {
    List resultado = new ArrayList();
    for(Iterator<String> it = profesores.keySet().iterator();it.hasNext();) {
      String key = it.next();
      resultado.add(profesores.get(key));
    }
    return resultado;
  }
  
  protected void update(String profesorID,String nombre,String titulo, String area, String correo, String telefono) {
    
	ProfesorDTO prof = find(profesorID);
	
	if (prof != null){
	
	  prof.setArea(area);
      prof.setNombre(nombre);
      prof.setTitulo(titulo);
      prof.setCorreo(correo);
      prof.setTelefono(telefono);
	  
      profesores.put(profesorID,prof); //el prof es una referencia al hashMap ent esta linea puede no ser necesaria
	  
    } 
  }
  
  protected void insert(String profesorID,String nombre,String titulo, String area, String correo, String telefono) {
    
	  ProfesorDTO prof = new ProfesorDTO();
      prof.setCedula(profesorID);
      prof.setArea(area);
      prof.setNombre(nombre);
      prof.setTitulo(titulo);
      prof.setCorreo(correo);
      prof.setTelefono(telefono);
      profesores.put(prof.getCedula(),prof);
  }
  
  protected void delete(String profesorID) {
	
	ProfesorDTO prof = find(profesorID);
	
	if (prof != null)
		profesores.remove(profesorID);    
  }
}