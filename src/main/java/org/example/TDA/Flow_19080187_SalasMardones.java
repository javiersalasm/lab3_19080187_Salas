package org.example.TDA;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Esta clase representa un flujo en una aplicación de chatbot con sus atributos y opciones asociadas.
 */
public class Flow_19080187_SalasMardones {
    private int id;
    private String nameMsg;
    private List<Option_19080187_SalasMardones> optionList;

    /**
     * Constructor de la clase Flow_19080187_SalasMardones.
     *
     * @param id         El identificador único del flujo.
     * @param nameMsg    El nombre o mensaje asociado al flujo.
     * @param optionList La lista de opciones disponibles en el flujo.
     */
    public Flow_19080187_SalasMardones(int id, String nameMsg, List<Option_19080187_SalasMardones> optionList) {
        this.id = id;
        this.nameMsg = nameMsg;
        this.optionList = optionList;
    }

    /**
     * Agrega una nueva opción al flujo si el código de la opción es único en la lista.
     *
     * @param newOption La nueva opción a agregar.
     */
    public void flowAddOption(Option_19080187_SalasMardones newOption) {
        // Verificar que el código de la opción sea único en la lista de opciones
        boolean isUnique = optionList.stream()
                .noneMatch(option -> option.getCode() == newOption.getCode());

        if (isUnique) {
            // Añadir la nueva opción a la lista si el código es único
            optionList.add(newOption);
        } else {
            // Manejar el caso de que el código de la opción no sea único
            System.out.println("Una opcion con el codigo " + newOption.getCode() + " ya existe.");
        }
    }

    /**
     * Obtiene el identificador único del flujo.
     *
     * @return El identificador único del flujo.
     */
    public int getId() {
        return id;
    }


    /**
     * Obtiene el nombre o mensaje asociado al flujo.
     *
     * @return El nombre o mensaje asociado al flujo.
     */
    public String getNameMsg() {
        return nameMsg;
    }


    /**
     * Obtiene la lista de opciones disponibles en el flujo.
     *
     * @return La lista de opciones disponibles en el flujo.
     */
    public List<Option_19080187_SalasMardones> getOptionList() {
        return optionList;
    }

    /**
     * Sobrescribe el método toString para proporcionar una representación de cadena
     * de la clase Flow_19080187_SalasMardones.
     *
     * @return Una cadena que representa la información del flujo.
     */
    @Override
    public String toString() {
        return "Flow_19080187_SalasMardones{" +
                "id=" + id +
                ", nameMsg='" + nameMsg + '\'' +
                ", optionList=" + optionList +
                '}';
    }
}