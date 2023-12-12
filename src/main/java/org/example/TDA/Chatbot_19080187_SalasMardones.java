package org.example.TDA;

import java.util.List;
/**
 * Esta clase representa un chatbot con sus atributos y funcionalidades asociadas.
 */
public class Chatbot_19080187_SalasMardones {
    private int chatbotId;
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private List<Flow_19080187_SalasMardones> flowList;

    /**
     * Constructor de la clase Chatbot_19080187_SalasMardones.
     *
     * @param chatbotId      El identificador único del chatbot.
     * @param name           El nombre del chatbot.
     * @param welcomeMessage El mensaje de bienvenida que muestra el chatbot.
     * @param startFlowId    El ID del flujo de inicio asociado al chatbot.
     * @param flowList       La lista de flujos disponibles para el chatbot.
     */
    public Chatbot_19080187_SalasMardones(int chatbotId, String name, String welcomeMessage, int startFlowId, List<Flow_19080187_SalasMardones> flowList) {
        this.chatbotId = chatbotId;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flowList = flowList;
    }

    /**
     * Agrega un nuevo flujo al chatbot si el ID del flujo es único en la lista.
     *
     * @param newFlow El nuevo flujo a agregar.
     */
    public void chatbotAddFlow(Flow_19080187_SalasMardones newFlow){
        boolean isUnique = flowList.stream()
                .noneMatch(flow -> flow.getId() == newFlow.getId());

        if(isUnique){
            flowList.add(newFlow);
        } else {
            System.out.println("Un flujo con el ID " + newFlow.getId() + " ya existe.");
        }
    }

    /**
     * Obtiene el identificador único del chatbot.
     *
     * @return El identificador único del chatbot.
     */
    public int getChatbotId() {
        return chatbotId;
    }


    /**
     * Obtiene el nombre del chatbot.
     *
     * @return El nombre del chatbot.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del chatbot.
     *
     * @param name El nuevo nombre del chatbot.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el mensaje de bienvenida del chatbot.
     *
     * @return El mensaje de bienvenida del chatbot.
     */
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    /**
     * Establece el mensaje de bienvenida del chatbot.
     *
     * @param welcomeMessage El nuevo mensaje de bienvenida del chatbot.
     */
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    /**
     * Obtiene el ID del flujo de inicio asociado al chatbot.
     *
     * @return El ID del flujo de inicio del chatbot.
     */
    public int getStartFlowId() {
        return startFlowId;
    }


    /**
     * Obtiene la lista de flujos disponibles para el chatbot.
     *
     * @return La lista de flujos disponibles para el chatbot.
     */
    public List<Flow_19080187_SalasMardones> getFlowList() {
        return flowList;
    }


    /**
     * Sobrescribe el método toString para proporcionar una representación de cadena
     * de la clase Chatbot_19080187_SalasMardones.
     *
     * @return Una cadena que representa la información del chatbot.
     */
    @Override
    public String toString() {
        return "Chatbot_19080187_SalasMardones{" +
                "chatbotId=" + chatbotId +
                ", name='" + name + '\'' +
                ", welcomeMessage='" + welcomeMessage + '\'' +
                ", startFlowId=" + startFlowId +
                ", flowList=" + flowList +
                '}';
    }
}