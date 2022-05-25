





package agenda;

//import exceptions.ContactoInexistenteException;
import exceptions.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author loned
 */
public class Agenda {

    private HashMap<String, Contacto> contactos = new HashMap();
    private static int n = 0;
    private static int count = 0; 
    
    
    private static String nombreAgenda="";

    Agenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Agenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getnombreAgenda(Agenda a){
            return this.nombreAgenda;
    }
    public void setnombreAgenda(String name){
            this.nombreAgenda=name;
    }

    public Agenda(String name){
    
        if (name != ""){
            this.nombreAgenda = name;
        }
        else this.nombreAgenda ="Untitled";
    }
 /**
  * Añade contacto a la agenda 
  * @param contacto  contacto que queremos añadir 
  * @return Objeto contacto añadido o genera un excepcion si ya existia
  * @throws ContactoRepetidoException    Excepcion programada , ver paquete excepcion
  */
    
    
    public Contacto addContacto(Contacto contacto) throws ContactoRepetidoException {
        if (contactos.containsKey(contacto.getEmail())) {
            //
            throw new ContactoRepetidoException("Ya existe un contacto con email: " + contacto.getEmail());
        }
        n++;
        contacto.setN(n);
        contactos.put(contacto.getEmail(), contacto);
        count++;
        return contacto;
    }
/**
 * Elimina un contacto de la agenda
 * @param email Contacto que qeuremos eliminar
 * @return Muestra el contacto elimiinado
 */
    public Contacto eliminarContacto(String email) { 
        Contacto contacto = buscarContacto(email);
        if (contacto != null) {
        contactos.remove(email);
        count--;
        }
        return contacto;
    }

    public Contacto buscarContacto(String email) { 
        Contacto contacto = null;
        if (!contactos.containsKey(email)) {

            return null;
        }
        else{
        return contactos.get(email);
        }
    }
/**
 * Buscar al conttacot en la agenda
 * @return  Muestra al cntacto que deseabas encontrar
 */
    public ArrayList<Contacto> getContactos() {
        ArrayList<Contacto> contactosList = new ArrayList<>();
        contactosList.addAll(contactos.values());
        return contactosList;
    }
    
    

}
