package servicio;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService (targetNamespace ="http://service", name="universidad")
public class Universidad {

  private static ProfesorService profesor;

  @WebMethod (action="urn:findProfesor", operationName="findProfesor")
  public ProfesorDTO findProfesor(@WebParam (partName = "profesorId") String profesorId) {
    checkProfesor();
    return profesor.find(profesorId);
  }

  @WebMethod (action="urn:findAllProfesor", operationName="findAllProfesor")
  public List<ProfesorDTO> findAllProfesor() {
    checkProfesor();
    return profesor.findAll();
  }

  private void checkProfesor() {
    if (profesor == null)
      profesor = new ProfesorService();
  }
  
  @WebMethod (action="urn:updateProfesor", operationName="updateProfesor")
  public void updateProfesor(
	  @WebParam (partName = "profesorId") String cedula, 
	  @WebParam (partName = "nombre") String nombre,
	  @WebParam (partName = "titulo") String titulo,
	  @WebParam (partName = "area") String area,
	  @WebParam (partName = "correo") String correo,
	  @WebParam (partName = "telefono") String telefono
  ) {
    checkProfesor();
    profesor.update(cedula,nombre,titulo,area,correo,telefono);
  }
  
  @WebMethod (action="urn:insertProfesor", operationName="insertProfesor")
  public void insertProfesor(
	  @WebParam (partName = "profesorId") String cedula, 
	  @WebParam (partName = "nombre") String nombre,
	  @WebParam (partName = "titulo") String titulo,
	  @WebParam (partName = "area") String area,
	  @WebParam (partName = "correo") String correo,
	  @WebParam (partName = "telefono") String telefono
  ) {
    checkProfesor();
    profesor.insert(cedula,nombre,titulo,area,correo,telefono);
  }
  
  @WebMethod (action="urn:deleteProfesor", operationName="deleteProfesor")
  public void deleteProfesor(@WebParam (partName = "profesorId") String profesorId) {
    checkProfesor();
    profesor.delete(profesorId);
  }
    
}