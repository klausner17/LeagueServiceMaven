/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.crud;

import com.klausner.data.BancoDeDados;
import com.klausner.model.Championcounter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DesenSoftware
 */
public class ChampionCounterCrud {
        public boolean persistirCounter(Championcounter counter){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        try{
            conexao.getTransaction().begin();
            conexao.persist(counter);
            conexao.getTransaction().commit();
            conexao.close();
            return true;
        }catch(Exception ex){
            if(conexao.isOpen()) conexao.close();
            return false;
        }
    }
    
    public List<Championcounter> findAllCounters(){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        List<Championcounter> retorno = conexao.createNamedQuery("Championcounter.findAll").getResultList();
        conexao.close();
        return retorno;
    }
    
    public Championcounter findCounter(int idCounter){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        Query query =  conexao.createNamedQuery("Championcounter.findByIdCounter");
        query.setParameter("idCounter", idCounter);
        List<Championcounter> retorno = query.getResultList();        
        conexao.close();
        return retorno.get(0);
    }
    
    public List<Championcounter> findBuildsByChampion(int idChampion){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        Query query = conexao.createNamedQuery("Championcounter.findByIdChampion");
        query.setParameter("idChampion", idChampion);
        List<Championcounter> retorno = query.getResultList();
        conexao.close();
        return retorno;
    }
}
