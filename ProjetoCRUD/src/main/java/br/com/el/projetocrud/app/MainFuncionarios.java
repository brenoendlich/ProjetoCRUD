/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.app;

import br.com.el.projetocrud.modelo.Funcionario;
import br.com.el.projetocrud.persistencia.h2.FuncionarioH2DAO;
import java.util.List;

/**
 *
 * @author breno.rodrigues
 */
public class MainFuncionarios {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("5678", null);
        
        FuncionarioH2DAO dao = FuncionarioH2DAO.GetInstance();
        
        dao.salvar(f);
        
        List<Funcionario> funcs = dao.buscarTodos();
        
        for (Funcionario func : funcs) {
            System.out.println("Id: " + func.getId()+ ", Matricula: " + func.getMatricula());
        }
    }
}
