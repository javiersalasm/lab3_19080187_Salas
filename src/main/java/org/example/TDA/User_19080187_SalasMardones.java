package org.example.TDA;

/**
 * Clase abstracta que representa un usuario genérico.
 */
public abstract class User_19080187_SalasMardones {
    protected String username;
    protected boolean loginStatus = false;


    /**
     * Constructor de la clase User_19080187_SalasMardones.
     *
     * @param username El nombre de usuario del usuario.
     */
    public User_19080187_SalasMardones(String username) {
        this.username = username;
        this.loginStatus = false;
    }

    /**
     * Método abstracto que debe ser implementado por las clases derivadas para realizar
     * el proceso de inicio de sesión del usuario.
     */
    public abstract void login();

    /**
     * Cierra la sesión del usuario y actualiza el estado de inicio de sesión.
     * Imprime un mensaje indicando que el usuario ha cerrado sesión.
     */
    public void logout(){
        this.loginStatus = false;
        System.out.println(username + " ha cerrado sesion");
    }


    /**
     * Obtiene el nombre de usuario del usuario.
     *
     * @return El nombre de usuario del usuario.
     */
    public String getUsername() {
        return username;
    }


    /**
     * Verifica el estado de inicio de sesión del usuario.
     *
     * @return true si el usuario está en sesión, false en caso contrario.
     */
    public boolean isLoginStatus() {
        return loginStatus;
    }


    /**
     * Representación en forma de cadena de caracteres del objeto User_19080187_SalasMardones.
     *
     * @return Una cadena que contiene los atributos de la clase en formato legible.
     */
    @Override
    public String toString() {
        return "User_19080187_SalasMardones{" +
                "username='" + username + '\'' +
                ", loginStatus=" + loginStatus +
                '}';
    }
}