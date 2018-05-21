/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.tela.models;

import com.poo.entidades.Compra;
import com.poo.entidades.Compra;
import com.poo.entidades.Medicamento;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Rafael Vieira
 */
@AllArgsConstructor
@NoArgsConstructor
public class VendaTableModel extends AbstractTableModel {

    private List<Compra> dados;

    private final String[] colunas = {"ID_Compra", "Nome_Cliente", " Medicamento(s)",
        "Pagamento", "Data", "Total"};

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
                return dados.get(rowIndex).getCliente().getNome();
            case 2:
                int pos = 0;
                String str = "";
                for (Medicamento medicamento : dados.get(rowIndex).getMedicamentos()) {
                    str += medicamento.getDescricao() + " x";
                    str += dados.get(rowIndex).getQtdsMedcsCompra().get(pos++);
                    str += " | ";
                }
                return str;
            case 3:
                if (dados.get(rowIndex).isPagamento()) {
                    return "À VISTA";
                } else {
                    return "A PRAZO";
                }
            case 4:
                Calendar horario = dados.get(rowIndex).getHorario();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String hora = formato.format(horario.getTime());
                return hora;
            case 5:
                return dados.get(rowIndex).getTotal();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 3:
                dados.get(rowIndex).setPagamento((Boolean) aValue);
                break;
        }

        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public Compra removeRow(int rowIndex) {
        Compra compra = dados.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
        return compra;

    }

    public Compra getRow(int rowIndex) {
        Compra compra = dados.get(rowIndex);
        return compra;
    }
}
