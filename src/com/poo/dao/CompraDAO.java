/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.dao;

import com.poo.entidades.Compra;
import com.poo.entidades.Cliente;
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
public class CompraDAO {

    private EntityManager em;

    public void inserirCompra(Compra compra) {
        em.getTransaction().begin();
        em.persist(compra);
        em.getTransaction().commit();
    }

    public void atualizarCompra(Compra compra) {
        em.getTransaction().begin();
        em.merge(compra);
        em.getTransaction().commit();
    }

    public Compra removerCompra(Compra compra) {
        em.getTransaction().begin();
        em.remove(compra);
        em.getTransaction().commit();
        return compra;
    }

    public List<Compra> listarCompras() {
        Query query = em.createNamedQuery("ListarTodasCompras");

        List<Compra> compras = query.getResultList();

        return compras;
    }

    public List<Compra> listarCompras(Cliente cliente) {
        Query query = em.createNamedQuery("ListarComprasCliente");
        query.setParameter("pCliente", cliente);
        List<Compra> compras = query.getResultList();

        return compras;
    }

    public List<Compra> listarComprasPg(Cliente cliente) {
        Query query = em.createNamedQuery("ListarComprasClientePg");
        query.setParameter("pCliente", cliente);
        List<Compra> compras = query.getResultList();

        return compras;
    }

    public List<Compra> listarComprasPg() {
        Query query = em.createNamedQuery("ListarComprasPg");
        List<Compra> compras = query.getResultList();

        return compras;
    }
    
    public List<Compra> listarComprasNpg() {
        Query query = em.createNamedQuery("ListarComprasNpg");
        List<Compra> compras = query.getResultList();
        return compras;
    }

    public List<Compra> listarCompraNpg(Cliente cliente) {
        Query query = em.createNamedQuery("ListarComprasClienteNpg");
        query.setParameter("pCliente", cliente);
        List<Compra> compras = query.getResultList();

        return compras;
    }

    public List<Compra> listarGeralComprasCliente(Cliente cliente) {
        Query query = em.createNamedQuery("ListarGeralComprasCliente");
        query.setParameter("pCliente", cliente);
        List<Compra> compras = query.getResultList();

        return compras;
    }

    public List<Compra> listarGeralComprasClienteId(int id) {
        Query query = em.createNamedQuery("ListarGeralComprasClienteId");
        query.setParameter("pId", id);
        List<Compra> compras = query.getResultList();

        return compras;
    }

    public List<Compra> listarCompra(int id) {
        Query query = em.createNamedQuery("ListarCompraId");

        query.setParameter("pId", id);

        List<Compra> compras = query.getResultList();

        return compras;
    }

}
