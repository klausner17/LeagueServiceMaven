/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DesenSoftware
 */
public class BancoDeDados {
    private static BancoDeDados instancia = new BancoDeDados();
    private EntityManagerFactory fabrica;
    
    public static BancoDeDados getInstance(){
        return instancia;
    }
    
    private BancoDeDados(){
        fabrica = Persistence.createEntityManagerFactory("conexaoDB");
    }
    
    public EntityManager criarConexao(){
        return fabrica.createEntityManager();
    }
    
    
}
