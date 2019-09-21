/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.visao;

import java.util.Scanner;

/**
 *
 * @author breno.rodrigues
 */
public abstract class TelaCRUD implements Tela{

    protected Scanner scanner = new Scanner(System.in);

    public abstract void exibeOpcaoNovo();

    public abstract void exibeOperacaoNovo();

    public abstract void exibeOpcaoExcluir();

    public abstract void exibeOperacaoExcluir();

    public abstract void exibeOpcaoRecuperar();

    public abstract void exibeOperacaoRecuperar();

    public abstract void exibeOpcaoListarTodos();

    public abstract void exibeOperacaoListarTodos();

    /**
     * abstract method
     */
    @Override
    public void exibeMenu() {
        int opcao = 0;
        do {
            System.out.println("Escolha sua opção ");
            System.out.println("0 = Sair");
            System.out.print("1 = ");
            this.exibeOpcaoListarTodos();
            System.out.print("2 = ");
            this.exibeOpcaoRecuperar();
            System.out.print("3 = ");
            this.exibeOpcaoExcluir();
            System.out.print("4 = ");

            this.exibeOpcaoNovo();

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.exibeOperacaoListarTodos();
                    break;
                case 2:
                    this.exibeOperacaoRecuperar();
                    break;
                case 3:
                    this.exibeOperacaoExcluir();
                    break;
                case 4:
                    this.exibeOperacaoNovo();
                    break;
            }
        } while (opcao != 0);

        this.scanner.close();
    }
}
