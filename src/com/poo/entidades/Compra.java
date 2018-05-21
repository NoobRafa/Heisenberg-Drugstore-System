/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.entidades;

import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Rafael Vieira
 */
@ToString(includeFieldNames = false, exclude= {"cliente", "medicamentos"})
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@NamedQueries({
    @NamedQuery(query= "select c from Compra c", name= "ListarTodasCompras"),
    @NamedQuery(query= "select c from Compra c where c.id = :pId", name= "ListarCompraId"),
    @NamedQuery(query= "select c from Compra c where c.cliente = :pCliente", name= "ListarComprasCliente"),
    @NamedQuery(query= "select c from Compra c join fetch c.medicamentos", name= "ListarComprasMedicamentos"),
    @NamedQuery(query= "select distinct c from Compra c join fetch c.medicamentos where c.cliente = :pCliente", name= "ListarGeralComprasCliente"),
    @NamedQuery(query= "select distinct c from Compra c join fetch c.medicamentos where c.cliente.id = :pId", name= "ListarGeralComprasClienteId"),
    @NamedQuery(query= "select c from Compra c where c.pagamento= true and c.cliente = :pCliente", name= "ListarComprasClientePg"),
    @NamedQuery(query= "select c from Compra c where c.pagamento= false and c.cliente = :pCliente", name= "ListarComprasClienteNpg"),
    @NamedQuery(query= "select c from Compra c where c.pagamento = false ", name= "ListarComprasNpg"),
    @NamedQuery(query= "select c from Compra c where c.pagamento = true ", name= "ListarComprasPg")

})
public class Compra {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.REMOVE)
    private Cliente cliente;
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "compras_medicamentos")
    private List<Medicamento> medicamentos;
    private boolean pagamento;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar horario;
    private double total;
    
    @ElementCollection
    private List<Integer> qtdsMedcsCompra;
    
}
