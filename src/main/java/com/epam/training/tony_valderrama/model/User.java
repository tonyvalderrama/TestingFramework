package com.epam.training.tony_valderrama.model;

/**
 * Clase que es una abstracción de los datos para ingresar a la página
 * Mejora la legibilidad del código y facilita generar diversos usuarios para hacer pruebas
 */
public class User {
    private String username;
    private String password;

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
