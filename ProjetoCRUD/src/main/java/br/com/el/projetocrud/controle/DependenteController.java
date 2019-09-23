/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.controle;

import br.com.el.projetocrud.modelo.Dependente;
import br.com.el.projetocrud.modelo.Funcionario;
import br.com.el.projetocrud.persistencia.DAO;
import br.com.el.projetocrud.persistencia.h2.DependenteH2DAO;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author breno.rodrigues
 */
public class DependenteController {

    private DAO dao = DependenteH2DAO.GetInstance();
    private Dependente depedente = new Dependente();
    private Collection<Dependente> dependentes;

    public Dependente getDependente() {
        return depedente;
    }

    public Dependente getDependente(Long id) {
        this.depedente = (Dependente) this.dao.buscar(id);
        return depedente;
    }

    public Collection<Dependente> getDependentes() {
        this.dependentes = this.dao.buscarTodos();
        Collections.sort((List) this.dependentes, new Comparator<Dependente>() {
            @Override
            public int compare(Dependente o1, Dependente o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        return dependentes;
    }

    public void adicionaDependente(String nome, String matricula) {
        this.depedente.setNome(nome);

        FuncionarioController fc = new FuncionarioController();
        Funcionario f = fc.getFuncionario(matricula);

        this.depedente.setResponsavel(f);
        this.dao.salvar(depedente);
        this.depedente = new Dependente();
    }

    public void removeDependente() {
        if (this.depedente.getId() != null) {
            this.dao.excluir(this.depedente);
            this.depedente = new Dependente();
        }
    }
}
