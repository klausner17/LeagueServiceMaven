/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.crud;

import com.klausner.data.BancoDeDados;
import com.klausner.model.Championcomments;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DesenSoftware
 */
public class ChampionscommentsCrud {
    
    public void inserirComentario(Championcomments comentario ){
        EntityManager conexao = null;
        try{
            conexao = BancoDeDados.getInstance().criarConexao();
            conexao.getTransaction().begin();
            conexao.persist(comentario);
            conexao.getTransaction().commit();
            conexao.close();
        }catch(Exception ex){
            if(conexao.isOpen()){
                conexao.close();
            }
        }
    }
    
    public List<Championcomments> findAllComments(){
        EntityManager conexao = null;
        try{
            conexao = BancoDeDados.getInstance().criarConexao();
            Query query = conexao.createNamedQuery("Championcomments.findAll");
            List<Championcomments> retorno = query.getResultList();
            conexao.close();
            return retorno;
        }catch(Exception e){
            if(conexao.isOpen()){
                conexao.close();
            }
            return null;
        }
    }
    
    public Championcomments findById(int id){
        EntityManager conexao = null;
        try{
            conexao = BancoDeDados.getInstance().criarConexao();
            Query query = conexao.createNamedQuery("Championcomments.findByIdComment");
            query.setParameter("idComment", id);
            Championcomments retorno = (Championcomments) query.getResultList().get(0);
            conexao.close();
            return retorno;
        }catch(Exception e){
            if(conexao.isOpen()){
                conexao.close();
            }
            return null;
        }
    }
    
    public List<Championcomments> findCommentsByChampion(int idChampion){
        EntityManager conexao = null;
        try{
            conexao = BancoDeDados.getInstance().criarConexao();
            Query query = conexao.createNamedQuery("Championcomments.findByChampion");
            query.setParameter("idChampion", idChampion);
            List<Championcomments> retorno = query.getResultList();
            conexao.close();
            return retorno;
        }catch(Exception e){
            if(conexao.isOpen()){
                conexao.close();
            }
            return null;
        }
    }
}
