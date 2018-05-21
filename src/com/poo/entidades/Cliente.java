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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@ToString(includeFieldNames = false, exclude= "compras")
@EqualsAndHashCode(of = "cpf")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@NamedQueries({
    @NamedQuery(query= "select c from Cliente c", name= "ListarTodosClientes"),
    @NamedQuery(query= "select c from Cliente c where c.id = :pId", name= "ListarClienteId"),
    @NamedQuery(query= "select c from Cliente c where c.nome = :pNome", name= "ListarClienteNome"),
    @NamedQuery(query= "select distinct c from Cliente c join fetch c.compras", name = "ListarClientesCompras")
})
public class Cliente {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    private String telefone;
    private String email;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<Compra> compras;

    public Cliente(String nome, String cpf, Endereco endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    
    
  
    
    

    
    
    
}
