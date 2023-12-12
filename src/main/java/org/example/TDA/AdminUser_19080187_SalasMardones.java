package org.example.TDA;

/**
 * Esta clase representa un usuario administrador que hereda de la clase User_19080187_SalasMardones.
 * Un usuario administrador tiene la capacidad de iniciar sesión y realizar acciones de administración.
 */
public class AdminUser_19080187_SalasMardones extends User_19080187_SalasMardones{

    /**
     * Constructor de la clase AdminUser_19080187_SalasMardones.
     *
     * @param username El nombre de usuario del administrador.
     */
    public AdminUser_19080187_SalasMardones(String username) {
        super(username);
    }
    /**
     * Método que permite que el administrador inicie sesión.
     * Establece el estado de inicio de sesión como verdadero y muestra un mensaje de inicio de sesión.
     */
    @Override
    public void login() {
        this.loginStatus = true;
        System.out.println("Usuario administrador: " + username + " ha iniciado sesion");

    }
}