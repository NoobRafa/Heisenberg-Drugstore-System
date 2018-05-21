/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.dao;

import com.poo.entidades.Estoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Rafael Vieira
 */
@Getter
@Setter
@AllArgsConstructor
public class EstoqueDAO {

    private EntityManager em;

    public void inserirEstoque(Estoque estoque) {
        em.getTransaction().begin();
        em.persist(estoque);
        em.getTransaction().commit();
    }

    public void atualizarEstoque(Estoque estoque) {
        em.getTransaction().begin();
        em.merge(estoque);
        em.getTransaction().commit();
    }

    public Estoque removerEstoque(Estoque estoque) {
        em.getTransaction().begin();
        em.remove(estoque);
        em.getTransaction().commit();
        return estoque;
    }

    public List<Estoque> listarEstoques() {
        return em.createNamedQuery("ListarTodosEstoques").getResultList();
    }

    public List<Estoque> listarEstoque(int id) {
        Query query = em.createNamedQuery("ListarEstoqueId");
        query.setParameter("pId", id);
        List<Estoque> estoques = query.getResultList();
        return estoques;
    }

}
