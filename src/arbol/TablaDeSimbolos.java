/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

import java.util.LinkedList;

/**
 * Clase tabla de símbolos, que realiza todas las operaciones habituales de una 
 * tabla de símbolos, hereda de la clase lista enlazada porque básicamente la tabla
 * es una lista de símbolos.
 * @author Erick
 */
public class TablaDeSimbolos extends LinkedList<Simbolo>{
    /**
     * Constructor de la clase que lo único que hace es llamar al constructor de 
     * la clase padre, es decir, el constructor de LinkedList.
     */
    public TablaDeSimbolos() {
        super();
    }
    /**
     * Método que busca una variable en la tabla de símbolos y devuelve su valor.
     * @param id Identificador de la variable que quiere buscarse
     * @return Valor de la variable que se buscaba, si no existe se devuelve nulo
     */
    Object getValor(String id) {
        Object returnValue = getValue(id);
        if (returnValue == "Desconocido") System.out.println("La variable "+id+" no existe en este ámbito.");
        return returnValue;
    }
    /**
     * Método que asigna un valor a una variable específica, si no la encuentra
     * no realiza la asignación y despliega un mensaje de error.
     * @param id Identificador de la variable que quiere buscarse
     * @param valor Valor que quiere asignársele a la variable buscada
     */
    void setValor(String id, Object valor) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                s.setValor(valor);
                return;
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }

    @Override
    public boolean add(Simbolo e) {
        Object valor = getValue(e.getId());
        if (valor == "Desconocido") {
            super.add(e);
            return true;
        }
        System.out.println("La variable "+e.getId()+" no puede declararse porque ya existe en este ámbito");
        return false;
    }

    private Object getValue(String id)
    {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                return s.getValor();
            }
        }
        return "Desconocido";
    }
}