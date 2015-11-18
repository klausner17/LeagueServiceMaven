/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.crud;

import com.klausner.data.BancoDeDados;
import com.klausner.model.Championbuild;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DesenSoftware
 */
public class ChampionbuildCrud {
    
    public boolean persistirBuild(Championbuild build){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        try{
            conexao.getTransaction().begin();
            conexao.persist(build);
            conexao.getTransaction().commit();
            conexao.close();
            return true;
        }catch(Exception ex){
            if(conexao.isOpen()) conexao.close();
            return false;
        }
    }
    
    public List<Championbuild> findAllBuilds(){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        List<Championbuild> retorno = conexao.createNamedQuery("Championbuild.findAll").getResultList();
        conexao.close();
        return retorno;
    }
    
    public Championbuild findBuild(int id){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        Query query =  conexao.createNamedQuery("Championbuild.findByIdBuild");
        query.setParameter("idBuild", id);
        List<Championbuild> retorno = query.getResultList();        
        conexao.close();
        return retorno.get(0);
    }
    
    public List<Championbuild> findBuildsByChampion(int idChampion){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        Query query = conexao.createNamedQuery("Championbuild.findByIdChampion");
        query.setParameter("idChampion", idChampion);
        List<Championbuild> retorno = query.getResultList();
        conexao.close();
        return retorno;
    }
}
