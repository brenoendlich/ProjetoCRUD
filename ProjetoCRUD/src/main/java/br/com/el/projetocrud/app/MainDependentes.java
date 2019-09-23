/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.app;

import br.com.el.projetocrud.visao.TelaCRUD;
import br.com.el.projetocrud.visao.dependente.TelaCRUDDependente;

/**
 *
 * @author breno.rodrigues
 */
public class MainDependentes {
    public static void main(String[] args) {
        TelaCRUD tcfunc = new TelaCRUDDependente();
        tcfunc.exibeMenu();
    }
}
