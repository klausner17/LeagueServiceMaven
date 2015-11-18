/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.crud;

import com.klausner.data.BancoDeDados;
import com.klausner.exceptions.FailureLoginException;
import com.klausner.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DesenSoftware
 */
public class UsuarioCrud {
    public boolean inserirUsuario(Usuario user){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        boolean flag;
        try{
            conexao.getTransaction().begin();
            conexao.persist(user);
            conexao.getTransaction().commit();
            flag = true;
        }catch(Exception ex){
            if(conexao.isOpen()){
                conexao.getTransaction().rollback();
            }
            flag = false;
        }finally{
            if(conexao.isOpen()){
                conexao.close();
            }
        }
        return flag;
    }
    
    public Usuario findByLogin(String login){
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        try{
            Query query = conexao.createNamedQuery("Usuario.findByLogin");
            query.setParameter("login", login);
            List<Usuario> resultado = query.getResultList();
            conexao.close();
            return resultado.get(0);
        }catch(Exception ex){
            if(conexao.isOpen())
            conexao.close();
        }
        return null;
    }
    
    public boolean inserirPreCadastro(Usuario user){
        EntityManager conexao = null;
        try {
            conexao = BancoDeDados.getInstance().criarConexao();
            Query query = conexao.createNamedQuery("Usuario.findByLogin");
            query.setParameter("login", user.getLogin());
            conexao.getTransaction().begin();
            conexao.persist(user);
            conexao.getTransaction().commit();
            conexao.close();
            return true;
        } catch (Exception e) {
            if(conexao.isOpen()){
                conexao.close();
            }
            return false;
        }
    }
    
    public void alterarCadastro(Usuario user) throws Exception{
        EntityManager conexao = null;
        try{
            conexao = BancoDeDados.getInstance().criarConexao();
            Query query = conexao.createNamedQuery("Usuario.findByLogin");
            query.setParameter("login", user.getLogin());
            List<Usuario> resultado = query.getResultList();
            if(!resultado.isEmpty()){
                Usuario encontrado = resultado.get(0);
                encontrado.setNome(user.getNome());
                encontrado.setEmail(user.getEmail());
                encontrado.setSexo(user.getSexo());
                encontrado.setDataNasc(user.getDataNasc());
                encontrado.setValidado(user.getValidado());
                encontrado.setValidador(user.getValidador());
                conexao.getTransaction().begin();
                conexao.persist(encontrado);
                conexao.getTransaction().commit();
                conexao.close();
            }else{
                throw new NullPointerException("Esse cadastro não existe.");
            }
        }catch(NullPointerException ex){
            if(conexao.isOpen()){
                conexao.close();
            }
            throw new Exception(ex);
        }catch(Exception ex){
            if(conexao.isOpen()){
                conexao.close();
            }
        }
    }
    
    public void alterarSenha(Usuario user, String senha) throws Exception{
        EntityManager conexao = null;
        try{
            conexao = BancoDeDados.getInstance().criarConexao();
            Query query = conexao.createNamedQuery("Usuario.findByLogin");
            query.setParameter("login", user.getLogin());
            List<Usuario> resultado = query.getResultList();
            if(!resultado.isEmpty()){
                Usuario encontrado = resultado.get(0);
                encontrado.setSenha(senha);
                conexao.getTransaction().begin();
                conexao.persist(encontrado);
                conexao.getTransaction().commit();
                conexao.close();
            }else{
                throw new NullPointerException("Esse cadastro não existe.");
            }
        }catch(NullPointerException ex){
            if(conexao.isOpen()){
                conexao.close();
            }
            throw new Exception(ex);
        }catch(Exception ex){
            if(conexao.isOpen()){
                conexao.close();
            }
        }
    }
    
    public boolean fazerLogin(String login, String senha) throws FailureLoginException{
        EntityManager conexao = BancoDeDados.getInstance().criarConexao();
        Query query = conexao.createNamedQuery("Usuario.findByLogin");
        query.setParameter("login", login);
        List<Usuario> resultado = query.getResultList();
        if(!resultado.isEmpty()){
            if(BCrypt.checkpw(senha, resultado.get(0).getSenha()))
            {
                conexao.close();
                return true;
            }
            else
            {
                conexao.close();
                throw new FailureLoginException("Senha não confere.");
            }
        }else{
            conexao.close();
            throw new FailureLoginException("Esse cadastro não existe.");
        }
    }
}
