/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.persistencia;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author breno.rodrigues
 */
public interface DAO<T> {

    public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("bd-h2-pu");

    public void salvar(T o);

    public void excluir(T o);

    public List<T> buscarTodos();
}
