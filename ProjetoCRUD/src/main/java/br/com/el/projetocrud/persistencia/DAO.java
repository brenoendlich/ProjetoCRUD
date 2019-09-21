/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.persistencia;

/**
 *
 * @author breno.rodrigues
 */
public interface DAO {
    public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("bd-h2-pu");
}
