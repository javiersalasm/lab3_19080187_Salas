package org.example;
import org.example.TDA.*;
import org.example.Vista.Menu_19080187_SalasMardones;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        // Creación de opciones y flujos para Chatbot1 (Cocina)
        List<Option_19080187_SalasMardones> opcionesFlujo1Chatbot1 = new ArrayList<>(Arrays.asList(
                new Option_19080187_SalasMardones(1, "1) Dulces", 1, 2, Arrays.asList("postres", "dulces", "pasteles")),
                new Option_19080187_SalasMardones(2, "2) Salados", 1, 1, Arrays.asList("salados", "comida salada", "plato salado")),
                new Option_19080187_SalasMardones(3, "3) Tragos", 1, 1, Arrays.asList("copete", "alcohol", "algo para tomar")),
                new Option_19080187_SalasMardones(4, "4) Volver", 0, 0, Arrays.asList("volver", "regresar"))
        ));
        Flow_19080187_SalasMardones flujo1Chatbot1 = new Flow_19080187_SalasMardones(1, "Flujo 1", opcionesFlujo1Chatbot1);

        // Opciones y flujo para el Flujo 2 de Chatbot1 (Cocinero)
        List<Option_19080187_SalasMardones> opcionesFlujo2Chatbot1 = new ArrayList<>(Arrays.asList(
                new Option_19080187_SalasMardones(1, "1) Alfajor de manjar", 1, 2, Arrays.asList("alfajor", "manjar", "alfajor de manjar")),
                new Option_19080187_SalasMardones(2, "2) Torta pompadour", 1, 2, Arrays.asList("torta", "pompadour", "torta pompadour")),
                new Option_19080187_SalasMardones(3, "3) Volver al menú anterior", 1, 1, Arrays.asList("volver", "regresar", "menú anterior"))
        ));
        Flow_19080187_SalasMardones flujo2Chatbot1 = new Flow_19080187_SalasMardones(2, "Recetas específicas", opcionesFlujo2Chatbot1);

        // Creación de Chatbot1 con sus flujos
        Chatbot_19080187_SalasMardones chatbotCocinero = new Chatbot_19080187_SalasMardones(1, "Chatbot Cocinero", "Bienvenido, ¿qué te gustaría cocinar?", 1, new ArrayList<>(Arrays.asList(flujo1Chatbot1, flujo2Chatbot1)));

        // Opciones y flujos para Chatbot2 (Entrenador)
        List<Option_19080187_SalasMardones> opcionesFlujo1Chatbot2 = new ArrayList<>(Arrays.asList(
                new Option_19080187_SalasMardones(1, "1) Cardio", 2, 1, Arrays.asList("cardio", "cardiovascular", "aerobico")),
                new Option_19080187_SalasMardones(2, "2) Fuerza", 2, 1, Arrays.asList("fuerza", "pesas", "musculo")),
                new Option_19080187_SalasMardones(3, "3) Volver", 0, 0, Arrays.asList("volver", "regresar"))
        ));
        Flow_19080187_SalasMardones flujo1Chatbot2 = new Flow_19080187_SalasMardones(1, "Flujo 1", opcionesFlujo1Chatbot2);


        // Creación de Chatbot2 con sus flujos
        Chatbot_19080187_SalasMardones chatbotEntrenador = new Chatbot_19080187_SalasMardones(2, "Chatbot Entrenador", "Bienvenido que te gustaria entrenar?", 1, new ArrayList<>(Arrays.asList(flujo1Chatbot2)));

        // Opciones y flujo para el Chatbot Principal
        List<Option_19080187_SalasMardones> opcionesFlujoPrincipal = new ArrayList<>(Arrays.asList(
                new Option_19080187_SalasMardones(1, "1) Cocinar", 1, 0, Arrays.asList("cocinar", "comida", "comer")),
                new Option_19080187_SalasMardones(2, "2) Ejercitar", 2, 0, Arrays.asList("ejercitar", "ejercicio", "gimnasia"))
        ));
        Flow_19080187_SalasMardones flujoPrincipal = new Flow_19080187_SalasMardones(0, "Flujo principal Chatbot Principal", opcionesFlujoPrincipal);

        // Creación del Chatbot Principal
        Chatbot_19080187_SalasMardones chatbotPrincipal = new Chatbot_19080187_SalasMardones(0, "Chatbot Principal", "Bienvenido, ¿qué deseas hacer?", 0, new ArrayList<>(Arrays.asList(flujoPrincipal)));

        // Inicialización del sistema
        System_19080187_SalasMardones system1 = new System_19080187_SalasMardones("Sistema Chatbots", 0, new ArrayList<>());
        system1.systemAddChatbot(chatbotPrincipal);
        system1.systemAddChatbot(chatbotCocinero);
        system1.systemAddChatbot(chatbotEntrenador);

        // Agregar usuarios al sistema
        system1.systemAddUser(new AdminUser_19080187_SalasMardones("Admin"));
        system1.systemAddUser(new CommonUser_19080187_SalasMardones("Javier"));


        // Ejecución del menú
        Menu_19080187_SalasMardones menu = new Menu_19080187_SalasMardones();

        //System.out.println(system1.toString());
        int opcionUsuario = 0;

        do {

            try {
            System.out.println("Desea interactuar con un sistem vacio o interactuar con el sistema creado por defecto?");
            System.out.println("1. DIGITAR NUMERO (1) PARA SISTEMA CARGADO POR DEFECTO: ");
            System.out.println("2. DIGITAR NUMERO (2) PARA CREAR SISTEMA VACIO (SOLO SE INGRESA NOMBRE Y ENLACE DE CODIGO CON CHATBOT INICIAL): ");
            System.out.println("3. DIGITAR NUMERO (3) PARA TERMINAR EJECUCION");
            System.out.println("INTRODUZCA SU OPCION: ");
            opcionUsuario = input.nextInt();
            input.nextLine();


                switch (opcionUsuario) {
                    case 1:
                        menu.ejecutarMenu(system1);
                        System.out.println(system1.toString());
                        break;
                    case 2:
                        System.out.println("Ingrese nombre para el sistema de prueba: ");
                        String nombreSistema = input.nextLine();
                        System.out.println("Ingrese el codigo para enlazar el chatbot inicial: ");
                        int codigoChatbotLink = input.nextInt();
                        input.nextLine();
                        System_19080187_SalasMardones systemPrueba = new System_19080187_SalasMardones(nombreSistema,codigoChatbotLink, new ArrayList<>());
                        menu.ejecutarMenu(systemPrueba);
                        System.out.println(systemPrueba.toString());
                        break;
                    case 3:
                        System.out.println("Finalizando ejecucion ...");
                        break;
                    default:
                        System.out.println("Ingrese un numero valido (1 o 2)");
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un numero valido.");
                input.nextLine(); // Limpiar el buffer de entrada
            }


        } while(opcionUsuario != 3);
    }
}