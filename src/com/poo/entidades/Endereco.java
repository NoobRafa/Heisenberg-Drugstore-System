/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Rafael Vieira
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Entity
public class Endereco {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String endereco;
    private String cidade;
    private String cep;

    public Endereco(String endereco, String cidade, String cep) {
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
    }
    
    
    
}
