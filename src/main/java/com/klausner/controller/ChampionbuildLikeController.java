/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.crud;

import com.klausner.data.BancoDeDados;
import com.klausner.model.Championbuild;
import com.klausner.model.Championbuildlike;
import com.klausner.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DesenSoftware
 */
public class ChampionbuildLikeCrud {
    public final int GOSTOU = 0;
    public final int NAOGOSTOU = 1;
    
    public void feedback(Championbuild build, Usuario user, boolean gostou){
        EntityManager conexao = null;
        try{
            Championbuildlike cbl = new Championbuildlike();
            cbl.setChampionbuild(build);
            cbl.setUsuario(user);
            if(gostou)
                cbl.setGostou(GOSTOU);
            else
                cbl.setGostou(NAOGOSTOU);
            conexao = BancoDeDados.getInstance().criarConexao();
            conexao.getTransaction().commit();
            conexao.persist(cbl);
            conexao.close();
        }
        catch(Exception e){
            if(conexao.isOpen()){
                conexao.close();
            }
        }         
    }
    
    public boolean findFeedback(Usuario user, Championbuild build){
        EntityManager conexao = null;
        try{
            conexao = BancoDeDados.getInstance().criarConexao();
            String queryString = "SELECT b FROM Championbuildlike b "
                    + "WHERE b.idUsuario = :idUser AND b.idComment = :idBuild";
            Query query = conexao.createQuery(queryString);
            query.setParameter("idUsuario", user.getIdUsuario());
            query.setParameter("idBuild", build.getIdBuild());
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
