package com.salescontrol.data.sale;

import com.salescontrol.domain.Sale;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de tabela para exibir vendas.
 * <p>
 * Esta classe estende AbstractTableModel e fornece a implementação necessária
 * para exibir uma lista de vendas em uma tabela. As colunas da tabela incluem
 * ID, Data da Venda e Valor Total.
 * </p>
 */
public class SaleTableModel extends AbstractTableModel {

    /**
     * Lista de vendas a serem exibidas na tabela.
     */
    private final List<Sale> sales;

    /**
     * Nomes das colunas da tabela.
     */
    private final String[] columnNames = {"ID", "Data da Venda", "Valor Total"};

    /**
     * Construtor para inicializar o modelo de tabela com a lista de vendas.
     *
     * @param sales a lista de vendas.
     */
    public SaleTableModel(List<Sale> sales) {
        this.sales = sales;
    }

    /**
     * Retorna o número de linhas na tabela.
     *
     * @return o número de vendas na lista.
     */
    @Override
    public int getRowCount() {
        return sales.size();
    }

    /**
     * Retorna o número de colunas na tabela.
     *
     * @return o número de colunas da tabela.
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Retorna o nome da coluna para o índice fornecido.
     *
     * @param column o índice da coluna.
     * @return o nome da coluna correspondente ao índice.
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Retorna o valor da célula na posição especificada.
     *
     * @param rowIndex o índice da linha.
     * @param columnIndex o índice da coluna.
     * @return o valor da célula correspondente ao índice da linha e coluna.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sale sale = sales.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                sale.getId();
            case 1 ->
                sale.getSaleDate();
            case 2 ->
                sale.getTotalValue();
            default ->
                null;
        };
    }
}
