/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.dao;
import com.poo.entidades.Medicamento;
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
@Getter @Setter
@AllArgsConstructor
public class MedicamentoDAO {
    private EntityManager em;
    
    public void inserirMedicamento(Medicamento medicamento){
        em.getTransaction().begin();
        em.persist(medicamento);
        em.getTransaction().commit();
    }
    
    public void atualizarMedicamento(Medicamento medicamento){
        em.getTransaction().begin();
        em.merge(medicamento);
        em.getTransaction().commit();
    }
    
    public Medicamento removerMedicamento(Medicamento medicamento){
         em.getTransaction().begin();
         em.remove(medicamento);
         em.getTransaction().commit();
         return medicamento;
    }
    
    public List<Medicamento> listarMedicamentos(){
        Query query = em.createNamedQuery("ListarTodosMedicamentos");
        
        List<Medicamento> medicamentos = query.getResultList();
        
        return medicamentos;
    }
    
    public List<Medicamento> listarMedicamento(int id){
        Query query = em.createNamedQuery("ListarMedicamentoId");
        
        query.setParameter("pId", id);
        
        List<Medicamento> medicamentos = query.getResultList();
        
        
        return medicamentos;
    }
    
    public List<Medicamento> listarMedicamento(String descricao){
        Query query = em.createNamedQuery("ListarMedicamentoNome");
        
        query.setParameter("pDescricao", descricao);
        
        List<Medicamento> medicamentos = query.getResultList();
        
        
        return medicamentos;
    }
    
    public List<Medicamento> listarMedicamentosCompras(){
        Query query = em.createNamedQuery("ListarMedicamentosCompras");
        
        List<Medicamento> medicamentos = query.getResultList();
        
        return medicamentos;
    }
    
}
