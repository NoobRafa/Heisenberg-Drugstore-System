/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.tela.models;

import com.poo.entidades.Cliente;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Rafael Vieira
 */
@AllArgsConstructor
@NoArgsConstructor
public class ClienteTableModel extends AbstractTableModel {

    @Getter
    @Setter
    private List<Cliente> dados;
                                       //0  1       2       3           4       5           6          7
    private final String[] colunas = {"ID", "Nome", "CPF","Telefone", "E-mail","Endereço","Cidade", "CEP"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dados.get(rowIndex).getId();
            case 1:
                return dados.get(rowIndex).getNome();
            case 2:
                return dados.get(rowIndex).getCpf();
            case 3:
                return dados.get(rowIndex).getTelefone();
            case 4:
                return dados.get(rowIndex).getEmail();
            case 5:
                return dados.get(rowIndex).getEndereco().getEndereco();
             case 6:
                return dados.get(rowIndex).getEndereco().getCidade();
             case 7:
                return dados.get(rowIndex).getEndereco().getCep();  
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                dados.get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setCpf((String) aValue);
                break;
            case 3:
                dados.get(rowIndex).setTelefone((String) aValue);
                break;
            case 4:
                dados.get(rowIndex).setEmail((String) aValue);
                break;
            case 5:
                dados.get(rowIndex).getEndereco().setEndereco((String) aValue);
                break;
            case 6:
                dados.get(rowIndex).getEndereco().setCidade((String) aValue);
                break;
             case 7:
                dados.get(rowIndex).getEndereco().setCep((String) aValue);
                break;
        }
        
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public Cliente removeRow(int rowIndex) {
        Cliente cliente = this.dados.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
        return cliente;

    }
    
    public Cliente getRow(int rowIndex){
        Cliente cliente = dados.get(rowIndex);
        return cliente;
    }

}
