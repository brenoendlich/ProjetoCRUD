/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.controle;

import br.com.el.projetocrud.modelo.Funcionario;
import br.com.el.projetocrud.persistencia.DAO;
import br.com.el.projetocrud.persistencia.h2.FuncionarioH2DAO;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author breno.rodrigues
 */
public class FuncionarioController {
    private DAO dao = FuncionarioH2DAO.GetInstance();
    private Funcionario funcionario = new Funcionario();
    private Collection<Funcionario> funcionarios;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Funcionario getFuncionario(String matricula) {
        this.funcionario = (Funcionario) this.dao.buscar(matricula);
        return funcionario;
    }

    /**
     * a lista retornada aqui é ordenada pela matrícula do funcionario usando
     * uma classe anônima
     *
     * @return uma List de Funcionario
     */
    public Collection<Funcionario> getFuncionarios() {
        this.funcionarios = this.dao.buscarTodos();
        Collections.sort((List) this.funcionarios, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario o1, Funcionario o2) {
                return o1.getMatricula().compareTo(o2.getMatricula());
            }
        });
        return funcionarios;
    }

    public void adicionaFuncionario(String matricula) {
        this.funcionario.setMatricula(matricula);
        this.dao.salvar(funcionario);
        this.funcionario = new Funcionario();
    }

    public void removeFuncionario() {
        if (this.funcionario.getMatricula() != null) {
            this.dao.excluir(this.funcionario);
            this.funcionario = new Funcionario();
        }
    }
}
