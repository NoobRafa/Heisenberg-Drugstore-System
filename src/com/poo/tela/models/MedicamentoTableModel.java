/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.tela.models;

import com.poo.entidades.Medicamento;
import java.util.ArrayList;

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
public class MedicamentoTableModel extends AbstractTableModel {

    @Getter
    @Setter
    private List<Medicamento> dados;
                                       //0      1             2         3       4
    private final String[] colunas = {"ID", "Descrição", "Fabricante","Preço", "QTD"};

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
                return dados.get(rowIndex).getDescricao();
            case 2:
                return dados.get(rowIndex).getFabricante();
            case 3:
                return dados.get(rowIndex).getPreco();
            case 4:
                return dados.get(rowIndex).getEstoque().getQuantidade();  
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                dados.get(rowIndex).setDescricao((String) aValue);
                break;
            case 2:
                dados.get(rowIndex).setFabricante((String) aValue);
                break;
            case 3:
                dados.get(rowIndex).setPreco((double) aValue);
                break;
            case 4:
                dados.get(rowIndex).getEstoque().setQuantidade((int) aValue);
                break;
            
        }
        
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public Medicamento removeRow(int rowIndex) {
        Medicamento medicamento = dados.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
        return medicamento;

    }
    
    public Medicamento getRow(int rowIndex){
        Medicamento medicamento = dados.get(rowIndex);
        return medicamento;
    }
    
//    public void atualizar(List<Medicamento> medicamentos){
//        List<Medicamento> listaNova = new ArrayList<>();
//        
//        for (Medicamento medicamento : medicamentos) {
//            listaNova.add(medicamento);
//        }
//        
//        dados = listaNova;
//    }

}
