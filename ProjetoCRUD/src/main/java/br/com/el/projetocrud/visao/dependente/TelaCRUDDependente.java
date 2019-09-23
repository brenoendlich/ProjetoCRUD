/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.visao.dependente;

import br.com.el.projetocrud.controle.DependenteController;
import br.com.el.projetocrud.visao.TelaCRUD;
import br.com.el.projetocrud.visao.funcionario.TelaCRUDFuncionario;

/**
 *
 * @author breno.rodrigues
 */
public class TelaCRUDDependente extends TelaCRUD {

    private DependenteController controller = new DependenteController();

    @Override
    public void exibeOpcaoNovo() {
        System.out.println("Cadastro de dependente");
    }

    @Override
    public void exibeOperacaoNovo() {
        System.out.println("Insira o nome do dependente");
        String nome = scanner.next();
        
        System.out.println("Insira a matrícula funcionário");
        TelaCRUDFuncionario t = new TelaCRUDFuncionario();
        t.exibeOperacaoListarTodos();
        
        String matricula = scanner.next();
        
        controller.adicionaDependente(nome, matricula);
    }

    @Override
    public void exibeOpcaoExcluir() {
        System.out.println("Exclusão de dependente");
    }

    @Override
    public void exibeOperacaoExcluir() {
        System.out.println("Confirma a exclusão do dependente " + controller.getDependente() + " ?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int op = scanner.nextInt();
        if (op == 1) {
            controller.removeDependente();
        }
    }

    @Override
    public void exibeOpcaoRecuperar() {
        System.out.println("Seleção de dependente");
    }

    @Override
    public void exibeOperacaoRecuperar() {
        System.out.println("Insira o ID do dependente");
        Long id = scanner.nextLong();
        System.out.println(controller.getDependente(id));
    }

    @Override
    public void exibeOpcaoListarTodos() {
        System.out.println("Mostrar todos os dependentes");
    }

    @Override
    public void exibeOperacaoListarTodos() {
        controller.getDependentes().forEach(x -> System.out.println(x));
    }
}
