/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.crud;

import com.klausner.data.BancoDeDados;
import com.klausner.model.Buildstage;
import javax.persistence.EntityManager;

/**
 *
 * @author DesenSoftware
 */
public class BuildstageCrud {
    public boolean persistirBuild(Buildstage bs){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        try{
            conexao.getTransaction().begin();
            conexao.persist(bs);
            conexao.getTransaction().commit();
            conexao.close();
            return true;
        }catch(Exception ex){
            if(conexao.isOpen()) conexao.close();
            return false;
        }
    }
}
