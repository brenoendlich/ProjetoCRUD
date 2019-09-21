/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.persistencia.h2;

import br.com.el.projetocrud.modelo.Dependente;
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
public class DependenteH2DAO implements DAO<Dependente> {

    private static DependenteH2DAO instance;

    private DependenteH2DAO() {
    }

    public static DependenteH2DAO GetInstance() {
        if (instance == null) {
            instance = new DependenteH2DAO();
        }
        return instance;
    }

    @Override
    public void salvar(Dependente o) {
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
    public void excluir(Dependente o) {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                Dependente ob = em.find(Dependente.class, o.getId());
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
    public List<Dependente> buscarTodos() {
        List<Dependente> lista = new ArrayList<>();
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select D from Dependente D", Dependente.class);
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
