/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.visao.funcionario;

import br.com.el.projetocrud.controle.FuncionarioController;
import br.com.el.projetocrud.visao.TelaCRUD;

/**
 *
 * @author breno.rodrigues
 */
public class TelaCRUDFuncionario extends TelaCRUD {
    private FuncionarioController controller = new FuncionarioController();

    @Override
    public void exibeOpcaoNovo() {
        System.out.println("Cadastro de funcionário");
    }

    @Override
    public void exibeOperacaoNovo() {
        System.out.println("Insira a matricula do funcionario");
        String m = scanner.next();
        controller.adicionaFuncionario(m);
    }

    @Override
    public void exibeOpcaoExcluir() {
        System.out.println("Exclusão de funcionário");
    }

    @Override
    public void exibeOperacaoExcluir() {
        System.out.println("Confirma a exclusão do funcionário " + controller.getFuncionario() + " ?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int op = scanner.nextInt();
        if (op == 1) {
            controller.removeFuncionario();
        }
    }

    @Override
    public void exibeOpcaoRecuperar() {
        System.out.println("Seleção de funcionário");
    }

    @Override
    public void exibeOperacaoRecuperar() {
        System.out.println("Insira a matricula do funcionario");
        String m = scanner.next();
        System.out.println(controller.getFuncionario(m));
    }

    @Override
    public void exibeOpcaoListarTodos() {
        System.out.println("Mostrar todos os funcionários");
    }

    @Override
    public void exibeOperacaoListarTodos() {
        controller.getFuncionarios().forEach(x -> System.out.println(x));
    }
}
