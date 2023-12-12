package org.example.Vista;

import java.util.*;

import java.util.stream.Collectors;

import org.example.TDA.*;

/**
 * Esta clase representa el menú principal de la aplicación de Chatbots.
 * Proporciona opciones para el inicio de sesión de usuarios, registro y otras operaciones.
 */
public class Menu_19080187_SalasMardones {
    final int LOGIN = 1;
    final int REGISTER = 2;
    final int SALIR = 3;


    /**
     * Ejecuta el menú principal y gestiona las opciones del usuario.
     *
     * @param system El objeto System_19080187_SalasMardones que contiene la lógica del sistema.
     */
    public void ejecutarMenu(System_19080187_SalasMardones system) {

        Scanner input = new Scanner(System.in);

        int opcion = 0;
        do {
            try {
                System.out.println("### Sistema de Chatbots - Inicio ###");
                System.out.println("1. Login de Usuario");
                System.out.println("2. Registro de Usuario");
                System.out.println("3. Salir");
                System.out.println("INTRODUZCA SU OPCION: ");
                opcion = input.nextInt();

                switch (opcion) {
                    case LOGIN:
                        System.out.println("### Sistema de Chatbots - Login ###");
                        System.out.println("Ingrese el nombre de usuario para iniciar sesion: ");
                        String username = input.next();
                        system.systemLogin(username);
                        if (system.loginExitoso() == true) {
                            mostrarMenuPostLogin(system);
                        } else {
                            System.out.println("Inicio de sesion fallido. Por favor, intente de nuevo");
                        }
                        break;

                    case REGISTER:
                        ejecutarMenuRegistro(system);
                        break;

                    case SALIR:
                        System.out.println("Saliendo del sistema...");
                        break;


                    default:
                        System.out.println(opcion + "es una opcion invalida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un numero valido.");
                input.nextLine(); // Limpiar el buffer de entrada
            }
        } while (opcion != SALIR);
    }

    /**
     * Muestra el menú de registro y permite a los usuarios registrarse como usuarios normales o administradores.
     *
     * @param system El objeto System_19080187_SalasMardones que gestiona el sistema de Chatbots.
     */
    private void ejecutarMenuRegistro(System_19080187_SalasMardones system) {
        Scanner input = new Scanner(System.in);
        System.out.println("### Sistema de Chatbots - Registro ###");
        System.out.println("1. Registrar usuario normal");
        System.out.println("2. Registrar usuario administrador");
        System.out.println("INTRODUZCA SU OPCION:");

        int opcionRegistro = input.nextInt();
        input.nextLine(); // Limpiar buffer

        try {
            switch (opcionRegistro) {
                case 1:

                    System.out.println("### Sistema de Chatbots - Registro Usuario Normal ###");
                    System.out.println("INTRODUZCA NOMBRE DEL USUARIO NORMAL:");
                    String nombreUsuarioNormal = input.nextLine();

                    User_19080187_SalasMardones newUser = new CommonUser_19080187_SalasMardones(nombreUsuarioNormal);
                    system.systemAddUser(newUser);
                    break;

                case 2:
                    System.out.println("### Sistema de Chatbots - Registro Usuario Administrador ###");
                    System.out.println("INTRODUZCA NOMBRE DEL USUARIO ADMINISTRADOR:");
                    String nombreAdmin = input.nextLine();
                    // Lógica para registrar usuario administrador
                    User_19080187_SalasMardones newAdminUser = new AdminUser_19080187_SalasMardones(nombreAdmin);
                    system.systemAddUser(newAdminUser);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Por favor, intente registrar con un nombre de usuario diferente.");
        }

    }

    /**
     * Muestra el menú después de que un usuario ha iniciado sesión.
     *
     * @param system El objeto System_19080187_SalasMardones que gestiona el sistema de Chatbots.
     */
    private void mostrarMenuPostLogin(System_19080187_SalasMardones system) {
        if (system.esUsuarioAdmin()) {
            mostrarMenuAdmin(system);
        } else if (!system.esUsuarioAdmin()){
            mostrarMenuNormal(system);
        }
    }

    /**
     * Muestra el menú para usuarios administradores.
     *
     * @param system El objeto System_19080187_SalasMardones que contiene la lógica del sistema.
     */
    private void mostrarMenuAdmin(System_19080187_SalasMardones system) {
        Scanner input = new Scanner(System.in);
        boolean salirMenuAdmin = false;

        while (!salirMenuAdmin) {
            System.out.println("### Sistema de Chatbots - Usuario Administrador ###");
            System.out.println("Bienvenido " + system.getUserOn().getUsername() + ", usted es administrador.");
            System.out.println("1. Crear un Chatbot");
            System.out.println("2. Modificar un Chatbot");
            System.out.println("3. Ejecutar System Talk");
            System.out.println("4. Ejecutar System Synthesis");
            System.out.println("5. Ejecutar System Simulate (METODO NO IMPLEMENTADO)");
            System.out.println("6. Salir y cerrar sesion");
            System.out.println("INTRODUZCA SU OPCION: ");

            try {
                int opcion = input.nextInt();

                switch (opcion) {
                    case 1:
                        // Creación de chatbots: Aqui se incluye los siguientes RF:
                        // 1. TDA Option - Constructor X
                        // 2. TDA Flow - Constructor X
                        // 3. TDA Flow - modificador - flowAddOption X
                        // 4. TDA chatbot - constructor X
                        // 5. TDA chatbot - modificador - chatbotAddFlow X
                        // 8. TDA system - modificador - systemAddChatbot X
                        System.out.println("Chatbots ya existentes en el sistema:");
                        if(system.getChatbotList().size() == 0){
                            System.out.println("no hay chatbots en el sistema");
                        }
                        for (int i = 0; i < system.getChatbotList().size(); i++) {
                            Chatbot_19080187_SalasMardones chatbot = system.getChatbotList().get(i);
                            System.out.println((i + 1) + ". ID: " + chatbot.getChatbotId() + ", Nombre: " + chatbot.getName());
                        }
                        System.out.println("\nPrimero, cuantos chatbots desea crear.");
                        System.out.println("INGRESAR CUANTOS CHATBOTS DESEA CREAR:");
                        int cantidadDeChatbots = input.nextInt();
                        input.nextLine(); // Limpiar buffer después de leer un número
                        List<Chatbot_19080187_SalasMardones> listaDeChatbots = new ArrayList<>();

                        for (int i = 0; i < cantidadDeChatbots; i++) {
                            // Crear y configurar chatbot
                            Chatbot_19080187_SalasMardones chatbot = crearChatbot(input, i);
                            listaDeChatbots.add(chatbot);

                            // Crear y configurar flujos para el chatbot
                            System.out.println("CUANTOS FLUJOS DESEA CREAR PARA EL CHATBOT " + chatbot.getName() + ": ");
                            int cantidadDeFlujos = input.nextInt();
                            input.nextLine(); // Limpiar buffer después de leer un número

                            System.out.println("Aqui se utiliza el metodo chatbotAddFlow (RF. 5)");
                            for (int j = 0; j < cantidadDeFlujos; j++) {
                                Flow_19080187_SalasMardones flujo = crearFlujo(input, j, chatbot);
                                chatbot.chatbotAddFlow(flujo);
                            }
                        }

                        // Añadir chatbots creados al sistema
                        System.out.println("Aqui se utiliza el metodo systemAddChatbot (RF. 8)");
                        listaDeChatbots.forEach(system::systemAddChatbot);

                        System.out.println("Chatbots creados y añadidos al sistema con exito.");
                        System.out.println(system.toString());
                        break;

                    case 2:

                        // Verificar si hay chatbots disponibles para modificar
                        if (system.getChatbotList().isEmpty()) {
                            System.out.println("No hay chatbots disponibles para modificar.");
                            break;
                        }

                        // Mostrar lista de chatbots disponibles
                        System.out.println("Chatbots disponibles:");
                        for (int i = 0; i < system.getChatbotList().size(); i++) {
                            Chatbot_19080187_SalasMardones chatbot = system.getChatbotList().get(i);
                            System.out.println((i + 1) + ". ID: " + chatbot.getChatbotId() + ", Nombre: " + chatbot.getName());
                        }


                        System.out.println("Seleccione el número del chatbot que desea modificar:");
                        int seleccion = input.nextInt();
                        input.nextLine();

                        if (seleccion < 1 || seleccion > system.getChatbotList().size()) {
                            System.out.println("Selección inválida.");
                            break;
                        }

                        Chatbot_19080187_SalasMardones chatbotSeleccionado = system.getChatbotList().get(seleccion - 1);


                        System.out.println("Qué desea modificar del chatbot " + chatbotSeleccionado.getName() + "?");
                        System.out.println("1. Nombre");
                        System.out.println("2. Mensaje de bienvenida");

                        System.out.println("Ingrese su elección:");
                        int modificacion = input.nextInt();
                        input.nextLine();

                        switch (modificacion) {
                            case 1:
                                System.out.println("Ingrese el nuevo nombre:");
                                String nuevoNombre = input.nextLine();
                                chatbotSeleccionado.setName(nuevoNombre);
                                System.out.println("Nombre actualizado exitosamente.");
                                System.out.println(system.getChatbotList());
                                break;
                            case 2:
                                System.out.println("Ingrese el nuevo mensaje de bienvenida:");
                                String nuevoMensaje = input.nextLine();
                                chatbotSeleccionado.setWelcomeMessage(nuevoMensaje);
                                System.out.println("Mensaje de bienvenida actualizado exitosamente.");
                                System.out.println(system.getChatbotList());
                                break;
                            // Agregar más casos si hay más opciones de modificación
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }

                        break;

                    case 3:
                        // Lógica para ejecutar un chatbot
                        System.out.println("INGRESE UN SALUDO INICIAL PARA INTERACTUAR CON CHATBOTS: ");
                        input.nextLine();
                        String saludoInicial = input.nextLine();
                        System.out.println("Para finalizar la ejecucion de systemTalk debe escribir 'terminar', esto se puede realizar en cualquier momento");
                        system.systemTalk(saludoInicial);
                        break;

                    case 4:
                        // SYSTEM SYNTHESIS
                        input.nextLine();
                        System.out.println("Ingrese el nombre del usuario para ver la sintesis: ");
                        String nombreUsuario = input.nextLine();
                        String sintesis = system.systemSynthesis(nombreUsuario);
                        System.out.println("Sintesis de interacciones para " + nombreUsuario + ":\n" + sintesis);
                        break;

                    case 5: //System Simulate

                        System.out.println("METODO NO IMPLEMENTADO");
                        break;

                    case 6:
                        salirMenuAdmin = true;
                        system.systemLogout(); // Opcional: cerrar sesión al salir
                        break;

                    default:
                        System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, ingrese un numero.");
                input.nextLine(); // Limpiar el buffer para eliminar la entrada incorrecta
            }
        }
    }

    // Métodos adicionales para modularizar la creación de chatbots y flujos
    /**
     * Crea un nuevo objeto Chatbot_19080187_SalasMardones con los datos ingresados por el usuario.
     *
     * @param input        Scanner utilizado para la entrada de datos desde el usuario.
     * @param chatbotIndex Indice del chatbot en la secuencia de creacion.
     * @return Un objeto Chatbot_19080187_SalasMardones creado con los datos proporcionados.
     */
    private static Chatbot_19080187_SalasMardones crearChatbot(Scanner input, int chatbotIndex) {
        System.out.println("INGRESE EL ID PARA EL CHATBOT " + (chatbotIndex + 1) + ":");
        int chatbotId = input.nextInt();
        input.nextLine();

        System.out.println("INGRESE EL NOMBRE PARA EL CHATBOT " + (chatbotIndex + 1) + ":");
        String chatbotName = input.nextLine();

        System.out.println("INGRESE EL MENSAJE DE BIENVENIDA DEL CHATBOT " + (chatbotIndex + 1) + ":");
        String welcomeMessage = input.nextLine();

        System.out.println("INGRESE EL ID DEL FLUJO QUE CONECTA CON EL CHATBOT " + (chatbotIndex + 1) + ":");
        int startFlowId = input.nextInt();
        input.nextLine();

        System.out.println("Aqui se utiliza el constructor de chatbot (RF. 4)");
        return new Chatbot_19080187_SalasMardones(chatbotId, chatbotName, welcomeMessage, startFlowId, new ArrayList<>());
    }

    /**
     * Crea un nuevo objeto Flow_19080187_SalasMardones con los datos ingresados por el usuario.
     *
     * @param input     Scanner utilizado para la entrada de datos desde el usuario.
     * @param flujoIndex Indice del flujo en la secuencia de creación.
     * @param chatbot   Chatbot al que se asocia el flujo.
     * @return Un objeto Flow_19080187_SalasMardones creado con los datos proporcionados.
     */
    private static Flow_19080187_SalasMardones crearFlujo(Scanner input, int flujoIndex, Chatbot_19080187_SalasMardones chatbot) {
        System.out.println("INGRESE EL ID PARA EL FLUJO " + (flujoIndex + 1) + " DEL CHATBOT " + chatbot.getName() + ": ");
        int flowId = input.nextInt();
        input.nextLine();

        System.out.println("INTRODUZCA UN MENSAJE PARA EL FLUJO " + (flujoIndex + 1) + ": ");
        String flowMessage = input.nextLine();

        System.out.println("Aqui se utiliza el constructor Flow (RF. 2)");
        Flow_19080187_SalasMardones flujo = new Flow_19080187_SalasMardones(flowId, flowMessage, new ArrayList<>());

        // Crear opciones para el flujo
        crearOpcionesParaFlujo(input, flujo, chatbot);

        return flujo;
    }


    /**
     * Crea opciones para un flujo dado con los datos ingresados por el usuario.
     *
     * @param input    Scanner utilizado para la entrada de datos desde el usuario.
     * @param flujo    Flujo al que se añadirán las opciones.
     * @param chatbot  Chatbot al que pertenece el flujo.
     */
    private static void crearOpcionesParaFlujo(Scanner input, Flow_19080187_SalasMardones flujo, Chatbot_19080187_SalasMardones chatbot) {
        System.out.println("CUANTAS OPCIONES DESEA CREAR PARA EL FLUJO " + flujo.getNameMsg() + " DEL CHATBOT " + chatbot.getName() + ": ");
        int cantidadDeOpciones = input.nextInt();
        input.nextLine();

        for (int k = 0; k < cantidadDeOpciones; k++) {
            System.out.println("INTRODUZCA CODIGO PARA LA OPCION " + (k + 1) + ":");
            int codigoOpcion = input.nextInt();
            input.nextLine();

            System.out.println("INTRODUZCA MENSAJE PARA LA OPCION " + (k + 1) + ":");
            String mensajeOpcion = input.nextLine();

            System.out.println("INTRODUZCA PALABRAS CLAVE PARA LA OPCION " + (k + 1) + ", separadas por comas:");
            String[] keywordsArray = input.nextLine().split(",");
            List<String> keywords = new ArrayList<>(Arrays.asList(keywordsArray));

            System.out.println("Aqui se utiliza el constructor de Option (RF. 1)");
            Option_19080187_SalasMardones opcion = new Option_19080187_SalasMardones(codigoOpcion, mensajeOpcion, chatbot.getChatbotId(), flujo.getId(), keywords);

            System.out.println("Aqui se utiliza el metodo flowAddOption (RF. 3)");
            flujo.flowAddOption(opcion);
        }
    }




    /**
     * Muestra el menú para usuarios normales.
     *
     * @param system El objeto System_19080187_SalasMardones que contiene la lógica del sistema.
     */
    private void mostrarMenuNormal(System_19080187_SalasMardones system) {
        Scanner input = new Scanner(System.in);
        boolean salirMenuNormal = false;
        while (!salirMenuNormal) {
            if (system.getUserOn() != null) {
                System.out.println("### Sistema de Chatbots - Usuario Normal Logueado como: " + system.getUserOn().getUsername() + " ####");
            }

            System.out.println("1. Ejecutar System Talk");
            System.out.println("2. Ejecutar System Synthesis");
            System.out.println("3. Ejecutar una simulacion del sistema de chatbot (NO IMPLEMENTADO)");
            System.out.println("4. Visualizar chatbots del sistema");
            System.out.println("5. Cerrar sesion y Salir");

            try {
                System.out.println("INTRODUZCA SU OPCION: ");
                int opcion = input.nextInt();
                //input.nextLine(); // Limpiar buffer después de leer un número

                switch (opcion) {
                    case 1: //SystemTalk
                        System.out.println("INGRESE UN SALUDO INICIAL PARA INTERACTUAR CON CHATBOTS: ");
                        input.nextLine();
                        String saludoInicial = input.nextLine();
                        System.out.println("Para finalizar la ejecucion de systemTalk debe escribir 'terminar', esto se puede realizar en cualquier momento");
                        system.systemTalk(saludoInicial);
                        break;

                    case 2: //SystemSynthesis
                        input.nextLine();
                        System.out.println("Ingrese el nombre del usuario para ver la sintesis: ");
                        String nombreUsuario = input.nextLine();
                        String sintesis = system.systemSynthesis(nombreUsuario);
                        System.out.println("Sintesis de interacciones para " + nombreUsuario + ":\n" + sintesis);
                        break;

                    case 3:
                        System.out.println("Metodo no implementado");
                        break;
                    case 4:
                        System.out.println(system.getChatbotList());
                        break;
                    case 5:
                        salirMenuNormal = true;
                        system.systemLogout();
                        break;

                    default:
                        System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, ingrese un valor numerico.");
                input.nextLine(); // Limpiar buffer para eliminar la entrada incorrecta
            }
        }
    }
}