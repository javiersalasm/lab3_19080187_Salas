package org.example.TDA;

import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Esta clase representa un sistema de gestión de chatbots y usuarios.
 */
public class System_19080187_SalasMardones {
    private String name;
    private int initialChatbotCodeLink;
    private List<Chatbot_19080187_SalasMardones> chatbotList;
    private List<User_19080187_SalasMardones> userList;
    private Date creationDate;
    private List<String> chatHistory;
    private User_19080187_SalasMardones userOn;

    /**
     * Constructor de la clase System_19080187_SalasMardones que inicializa el sistema con los parámetros especificados.
     * Utiliza una fecha de creación predeterminada.
     *
     * @param name                   El nombre del sistema.
     * @param initialChatbotCodeLink El código del chatbot inicial vinculado al sistema.
     * @param chatbotList            La lista de chatbots en el sistema.
     */
    public System_19080187_SalasMardones(String name, int initialChatbotCodeLink, List<Chatbot_19080187_SalasMardones> chatbotList) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbotList = chatbotList;
        this.userList = new ArrayList<>();
        this.creationDate = new Date();
        this.chatHistory = new ArrayList<>();
        this.userOn = null;
    }

    /**
     * Agrega un nuevo chatbot al sistema, el código del chatbot es único en la lista de chatbots.
     *
     * @param newChatbot El nuevo chatbot a agregar.
     */
    public void systemAddChatbot(Chatbot_19080187_SalasMardones newChatbot){
        boolean isUnique = chatbotList.stream()
                .noneMatch(chatbot -> chatbot.getChatbotId() == newChatbot.getChatbotId());

        if(isUnique){
            chatbotList.add(newChatbot);
        } else {
            System.out.println("Un chatbot con el ID " + newChatbot.getChatbotId() + " ya existe.");
        }
    }

    /**
     * Agrega un nuevo usuario al sistema y el nombre de usuario es único en la lista de usuarios.
     *
     * @param newUser El nuevo usuario a agregar.
     */
    public void systemAddUser(User_19080187_SalasMardones newUser){
        boolean isUnique = userList.stream()
                .noneMatch(user -> user.getUsername().equals(newUser.getUsername()));

        if(isUnique){
            userList.add(newUser);
            System.out.println("Usuario " + newUser.getUsername() + " registrado con exito.");
        } else {
            System.out.println("Un usuario de nombre " + newUser.getUsername() + " ya existe.");
        }
    }
    /**
     * Inicia sesión de un usuario en el sistema utilizando su nombre de usuario.
     *
     * @param username El nombre de usuario del usuario que desea iniciar sesión.
     */
    public void systemLogin(String username) {
        // Verificar si ya hay un usuario conectado
        if (userOn != null) {
            System.out.println("Ya hay un usuario conectado: " + userOn.getUsername());
            return; // Salir del método si ya hay una sesión activa
        }

        // Buscar al usuario por el nombre de usuario
        User_19080187_SalasMardones user = userList.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        // Si el usuario existe y no está ya conectado, iniciar sesión
        if (user != null && !user.isLoginStatus()) {
            user.login(); // Iniciar sesión del usuario
            this.userOn = user; // Establecer como usuario actual
            System.out.println("Inicio de sesión exitoso para " + username);
        } else if (user != null) {
            System.out.println("El usuario " + username + " ya esta conectado.");
        } else {
            System.out.println("Usuario " + username + " no encontrado.");
        }
    }

    /**
     * Cierra la sesión del usuario actualmente conectado al sistema.
     */
    public void systemLogout() {
        // Verificar si hay un usuario conectado
        if (userOn != null) {
            userOn.logout(); // Llamar al método logout del usuario actual
            System.out.println("El usuario " + userOn.getUsername() + " ha cerrado sesion.");
            userOn = null; // Limpiar la referencia al usuario actual
        } else {
            System.out.println("Ningun usuario esta actualmente conectado.");
        }
    }
    /**
     * Inicia una conversación en el sistema, permitiendo que el usuario interactúe con los chatbots.
     *
     * @param message El mensaje inicial del usuario.
     */
    public void systemTalk(String message) {
        // Verificar si hay una sesión activa
        if (this.userOn == null) {
            System.out.println("Ningún usuario ha iniciado sesión. Por favor, inicia sesión primero.");
            return;
        }

        // Registrar el mensaje inicial del usuario en chatHistory
        chatHistory.add("Usuario: " + message);

        // Encuentra el chatbot con ID 0 (el chatbot de bienvenida)
        Chatbot_19080187_SalasMardones currentChatbot = findChatbotByCode(0);
        if (currentChatbot == null) {
            System.out.println("Chatbot de bienvenida no encontrado.");
            return;
        }

        // Muestra y registra el mensaje de bienvenida del chatbot
        String welcomeMessage = currentChatbot.getWelcomeMessage();
        System.out.println("Chatbot responde: " + welcomeMessage);
        chatHistory.add("Chatbot: " + welcomeMessage);

        // Iniciar con el flujo principal del chatbot
        int currentFlowId = currentChatbot.getStartFlowId();

        while (true) {
            presentOptions(currentChatbot, currentFlowId);

            // Leer y registrar la elección del usuario
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione una opción (ingrese el código o una palabra clave):");
            String userInput = scanner.nextLine();
            chatHistory.add("Usuario " + getUserOn().getUsername() + ": " + userInput);


            // Verificar si el usuario desea terminar la conversación
            if (userInput.equalsIgnoreCase("terminar")) {
                System.out.println("Saliendo de la interacción con el chatbot.");
                return; // Sale del bucle y termina la ejecución del método
            }

            // Encuentra y ejecuta la opción elegida
            Option_19080187_SalasMardones selectedOption = findOptionInFlow(currentChatbot, currentFlowId, userInput);
            if (selectedOption != null) {
                String optionMessage = "Has seleccionado: " + selectedOption.getMessage();
                System.out.println(optionMessage);
                chatHistory.add("Chatbot: " + optionMessage);

                // Determinar si es necesario cambiar el flujo o el chatbot
                if (selectedOption.getInitialFlowCodeLink() != currentFlowId) {
                    currentFlowId = selectedOption.getInitialFlowCodeLink();
                }
                if (selectedOption.getChatbotCodeLink() != currentChatbot.getChatbotId()) {
                    currentChatbot = findChatbotByCode(selectedOption.getChatbotCodeLink());
                    currentFlowId = currentChatbot.getStartFlowId(); // Reiniciar al flujo de inicio del nuevo chatbot
                }
            } else {
                System.out.println("Opción no válida o no reconocida.");
                return;
            }
        }
    }


    /**
     * Genera un resumen de las interacciones del usuario especificado en el sistema.
     *
     * @param username El nombre de usuario del usuario cuyas interacciones se desean resumir.
     * @return Un resumen de las interacciones del usuario.
     */
    public String systemSynthesis(String username) {
        StringBuilder synthesis = new StringBuilder();
        boolean userFound = false;

        // Formato de fecha y hora
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

        for (String entry : chatHistory) {
            if (entry.startsWith("Usuario " + username + ":") || (userFound && entry.startsWith("Usuario:"))) {
                // Agregar fecha y hora actual a la entrada
                synthesis.append(chatHistory.get(0));
                synthesis.append(dateFormat.format(new Date())).append(" - ").append(entry).append("\n");
                userFound = true;
            } else if (userFound && !entry.startsWith("Usuario:")) {
                // Agregar fecha y hora actual a la entrada
                synthesis.append(dateFormat.format(new Date())).append(" - ").append(entry).append("\n");
            } else if (userFound) {
                break;
            }
        }

        if (synthesis.length() == 0) {
            return "No se encontraron interacciones para el usuario: " + username;
        }

        return synthesis.toString();
    }



    private void presentOptions(Chatbot_19080187_SalasMardones chatbot, int currentFlowId) {
        Flow_19080187_SalasMardones currentFlow = chatbot.getFlowList().stream()
                .filter(flow -> flow.getId() == currentFlowId)
                .findFirst()
                .orElse(null);

        if (currentFlow != null) {
            System.out.println("Opciones disponibles:");
            currentFlow.getOptionList().forEach(option -> {
                String keywords = String.join(", ", option.getKeywords());
                String optionInfo = "Codigo: " + option.getCode() + ", Mensaje: " + option.getMessage() + " (Palabras Clave: " + keywords + ")";
                System.out.println(optionInfo);
            });
        }
    }


    private Chatbot_19080187_SalasMardones findChatbotByCode(int chatbotCode) {
        return this.chatbotList.stream()
                .filter(chatbot -> chatbot.getChatbotId() == chatbotCode)
                .findFirst()
                .orElse(null);
    }
    private Option_19080187_SalasMardones findOptionInFlow(Chatbot_19080187_SalasMardones chatbot, int flowId, String userInput) {
        // Encuentra el flujo especificado en el chatbot
        Flow_19080187_SalasMardones flow = chatbot.getFlowList().stream()
                .filter(f -> f.getId() == flowId)
                .findFirst()
                .orElse(null);

        if (flow == null) {
            // Si el flujo no se encuentra, retorna null
            return null;
        }

        // Busca la opción que coincida con el userInput
        return flow.getOptionList().stream()
                .filter(option ->
                        String.valueOf(option.getCode()).equals(userInput) ||
                                option.getKeywords().contains(userInput.toLowerCase())
                )
                .findFirst()
                .orElse(null);
    }



    /**
     * Verifica si el usuario actualmente conectado al sistema es un usuario administrador.
     *
     * @return `true` si el usuario es un administrador, `false` en caso contrario.
     */
    public boolean esUsuarioAdmin(){
        if(getUserOn() != null && getUserOn().getClass() == AdminUser_19080187_SalasMardones.class){
            return true;
        } else {
            return false;
        }
    }
    /**
     * Verifica si hay un usuario conectado al sistema.
     *
     * @return `true` si hay un usuario conectado, `false` en caso contrario.
     */
    public boolean loginExitoso(){
        if(this.userOn != null){
            return true;
        } else {
            return false;
        }
    }

    // Métodos de acceso (Getters y Setters)


    /**
     * Obtiene la fecha de creación del sistema en formato de cadena (dd/MM/yy).
     *
     * @return La fecha de creación formateada.
     */
    public String getFormattedCreationDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        return dateFormat.format(this.creationDate);
    }


    /**
     * Obtiene la lista de chatbots disponibles en el sistema.
     *
     * @return La lista de chatbots.
     */
    public List<Chatbot_19080187_SalasMardones> getChatbotList() {
        return chatbotList;
    }



    /**
     * Obtiene el usuario actualmente conectado al sistema.
     *
     * @return El usuario actualmente conectado o null si no hay ningún usuario conectado.
     */
    public User_19080187_SalasMardones getUserOn() {
        return userOn;
    }


    /**
     * Convierte el objeto `System_19080187_SalasMardones` a una representación de cadena (String).
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        return "System_19080187_SalasMardones{" +
                "name='" + name + '\'' +
                ", initialChatbotCodeLink=" + initialChatbotCodeLink +
                ", chatbotList=" + chatbotList +
                ", userList=" + userList +
                ", creationDate=" + getFormattedCreationDate() +
                ", chatHistory=" + chatHistory +
                ", userOn=" + userOn +
                '}';
    }
}