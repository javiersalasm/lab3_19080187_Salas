package org.example.TDA;

import java.util.List;

/**
 * Esta clase representa una opción en un flujo de un chatbot, con sus atributos y enlaces asociados.
 */
public class Option_19080187_SalasMardones {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> keywords;


    /**
     * Constructor de la clase Option_19080187_SalasMardones.
     *
     * @param code               El código único de la opción.
     * @param message            El mensaje asociado a la opción.
     * @param chatbotCodeLink    El código del chatbot vinculado a esta opción.
     * @param initialFlowCodeLink El código del flujo inicial vinculado a esta opción.
     * @param keywords           Lista de palabras clave relacionadas con esta opción.
     */
    public Option_19080187_SalasMardones(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = keywords;
    }

    /**
     * Obtiene el código único de la opción.
     *
     * @return El código único de la opción.
     */
    public int getCode() {
        return code;
    }


    /**
     * Obtiene el mensaje asociado a la opción.
     *
     * @return El mensaje asociado a la opción.
     */
    public String getMessage() {
        return message;
    }


    /**
     * Obtiene el código del chatbot vinculado a esta opción.
     *
     * @return El código del chatbot vinculado a esta opción.
     */
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }


    /**
     * Obtiene el código del flujo inicial vinculado a esta opción.
     *
     * @return El código del flujo inicial vinculado a esta opción.
     */
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }


    /**
     * Obtiene la lista de palabras clave relacionadas con esta opción.
     *
     * @return La lista de palabras clave relacionadas con esta opción.
     */
    public List<String> getKeywords() {
        return keywords;
    }



    /**
     * Sobrescribe el método toString para proporcionar una representación de cadena
     * de la clase Option_19080187_SalasMardones.
     *
     * @return Una cadena que representa la información de la opción.
     */
    @Override
    public String toString() {
        return "Option_19080187_SalasMardones{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", chatbotCodeLink=" + chatbotCodeLink +
                ", initialFlowCodeLink=" + initialFlowCodeLink +
                ", keywords=" + keywords +
                '}';
    }
}