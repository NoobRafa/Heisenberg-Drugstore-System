/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Rafael Vieira
 */
@ToString(includeFieldNames = false, exclude= {"compras", "estoque"})
@EqualsAndHashCode(of = "descricao")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@NamedQueries({
    @NamedQuery(query= "select m from Medicamento m", name = "ListarTodosMedicamentos"),
    @NamedQuery(query= "select m from Medicamento m where m.id = :pId", name = "ListarMedicamentoId"),
    @NamedQuery(query= "select m from Medicamento m where m.descricao = :pDescricao", name = "ListarMedicamentoNome"),
    @NamedQuery(query= "select m from Medicamento m join fetch m.compras", name= "ListarMedicamentosCompras")
})
public class Medicamento {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String fabricante;
    private double preco;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "medicamentos", cascade = CascadeType.REMOVE)
    private List<Compra> compras;
    
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "medicamento")
    private Estoque estoque;

    public Medicamento(String descricao, String fabricante, double preco) {
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.preco = preco;
    }
    
    

}
