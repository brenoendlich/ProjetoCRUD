/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.persistencia.h2;

import br.com.el.projetocrud.modelo.Funcionario;
import br.com.el.projetocrud.persistencia.DAO;
import static br.com.el.projetocrud.persistencia.DAO.EMF;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author breno.rodrigues
 */
public class FuncionarioH2DAO implements DAO<Funcionario> {

    private static FuncionarioH2DAO instance;

    private FuncionarioH2DAO() {
    }

    public static FuncionarioH2DAO GetInstance() {
        if (instance == null) {
            instance = new FuncionarioH2DAO();
        }
        return instance;
    }

    @Override
    public void salvar(Funcionario o) {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Funcionario o) {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                Funcionario ob = em.find(Funcionario.class, o.getId());
                em.remove(ob);
            } else {
                em.remove(o);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Funcionario> buscarTodos() {
        List<Funcionario> lista = new ArrayList<>();
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select F from Funcionario F", Funcionario.class);
            lista = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lista;
    }
}
