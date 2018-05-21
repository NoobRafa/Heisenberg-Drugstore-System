/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Rafael Vieira
 */
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@NamedQueries({
    @NamedQuery(query= "select e from Estoque e", name= "ListarTodosEstoques"),
     @NamedQuery(query= "select e from Estoque e where e.id = :pId", name= "ListarEstoqueId"),
})
public class Estoque {
    
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int quantidade;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Medicamento medicamento;

    public Estoque(int quantidade, Medicamento medicamento) {
        this.quantidade = quantidade;
        this.medicamento = medicamento;
    }
    
    
    
}
