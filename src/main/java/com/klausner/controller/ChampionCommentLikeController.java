/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.crud;

import com.klausner.data.BancoDeDados;
import com.klausner.model.Championcommentlike;
import com.klausner.model.Championcomments;
import com.klausner.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DesenSoftware
 */
public class ChampionCommentLikeCrud {
    private final int GOSTOU = 0;
    private final int NAOGOSTOU = 1;
    
    public void feedback(Championcomments commentario, Usuario user, boolean gostou){
        EntityManager conexao = null;
        try{
            Championcommentlike ccml = new Championcommentlike();
            ccml.setChampioncomments(commentario);
            ccml.setUsuario(user);
            if(gostou)
                ccml.setGostou(GOSTOU);
            else
                ccml.setGostou(NAOGOSTOU);
            conexao = BancoDeDados.getInstance().criarConexao();
            conexao.getTransaction().commit();
            conexao.persist(ccml);
            conexao.close();
        }
        catch(Exception e){
            if(conexao.isOpen()){
                conexao.close();
            }
        }         
    }
    
    public boolean findFeedback(Usuario user, Championcomments comment){
        EntityManager conexao = null;
        try{
            conexao = BancoDeDados.getInstance().criarConexao();
            String queryString = "SELECT c FROM Championcommentlike c "
                    + "WHERE c.idUsuario = :idUser AND c.idComment = :idComment";
            Query query = conexao.createQuery(queryString);
            query.setParameter("idUser", user.getIdUsuario());
            query.setParameter("idComment", comment.getIdComment());
            if(query.getResultList().isEmpty()){
                conexao.close();
                return false;
            }else{
                conexao.close();
                return true;
            }
        }
        catch(Exception e){
            if(conexao.isOpen()){
                conexao.close();
            }
            return false;
        }
    }
    
    
}
