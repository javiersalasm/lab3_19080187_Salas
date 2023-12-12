package org.example.TDA;
/**
 * Esta clase representa un usuario común que hereda de la clase User_19080187_SalasMardones.
 * Un usuario común tiene la capacidad de iniciar sesión y realizar acciones básicas.
 */
public class CommonUser_19080187_SalasMardones extends User_19080187_SalasMardones{
    /**
     * Constructor de la clase CommonUser_19080187_SalasMardones.
     *
     * @param username El nombre de usuario del usuario común.
     */
    public CommonUser_19080187_SalasMardones(String username) {
        super(username);
    }
    /**
     * Método que permite que el usuario común inicie sesión.
     * Establece el estado de inicio de sesión como verdadero y muestra un mensaje de inicio de sesión.
     */
    @Override
    public void login() {
        this.loginStatus = true;
        System.out.println("Usuario comun: " + username + " ha iniciado sesion");
    }
}