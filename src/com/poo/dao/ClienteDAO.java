/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.dao;

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
public class ClienteDAO {

    private EntityManager em;

    public void inserirCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public void atualizarCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public Cliente removerCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        return cliente;
    }

    public List<Cliente> listarClientes() {
        Query query = em.createNamedQuery("ListarTodosClientes");

        List<Cliente> clientes = query.getResultList();

        return clientes;
    }

    public List<Cliente> listarCliente(int id) {
        Query query = em.createNamedQuery("ListarClienteId");

        query.setParameter("pId", id);

        List<Cliente> clientes = query.getResultList();

        return clientes;
    }

    public List<Cliente> listarCliente(String nome) {
        Query query = em.createNamedQuery("ListarClienteNome");

        query.setParameter("pNome", nome);

        List<Cliente> clientes = query.getResultList();

        return clientes;
    }

    public List<Cliente> listarClientesCompras() {
        Query query = em.createNamedQuery("ListarClientesCompras");

        List<Cliente> clientes = query.getResultList();

        return clientes;
    }

}
