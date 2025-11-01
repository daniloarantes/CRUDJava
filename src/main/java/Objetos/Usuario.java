/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author danilo.asilv10
 */
public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String tipo;
    private String senhaHash;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the senhaHash
     */
    public String getSenhaHash() {
        return senhaHash;
    }

    /**
     * @param senhaHash the senhaHash to set
     */
    public void setSenhaHash(String senha) {
        this.senhaHash = encoder.encode(senha); //faz a criptografia
    }
    
    public boolean verificarSenha(String senhaDigitada){
        return encoder.matches(senhaDigitada, this.senha);
    }
      
}
