package com.salescontrol.data.product;

import com.salescontrol.domain.Product;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de tabela para exibir produtos.
 * <p>
 * Esta classe estende AbstractTableModel e fornece a implementação necessária
 * para exibir uma lista de produtos em uma tabela. As colunas da tabela incluem
 * ID, Nome, Categoria, Preço Unitário, Unidade de Medida e Quantidade.
 * </p>
 */
public class ProductTableModel extends AbstractTableModel {

    /**
     * Lista de produtos a serem exibidos na tabela.
     */
    private final List<Product> products;

    /**
     * Nomes das colunas da tabela.
     */
    private final String[] columnNames = {"ID", "Nome", "Categoria", "Preço Unitário", "Unidade de Medida", "Quantidade"};

    /**
     * Construtor para inicializar o modelo de tabela com uma lista de produtos.
     *
     * @param products a lista de produtos a ser exibida na tabela.
     */
    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    /**
     * Retorna o número de linhas na tabela.
     *
     * @return o número de produtos na lista.
     */
    @Override
    public int getRowCount() {
        return products.size();
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
        Product product = products.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                product.getId();
            case 1 ->
                product.getName();
            case 2 ->
                product.getCategory().getTranslation();
            case 3 ->
                product.getUnitPrice();
            case 4 ->
                product.getUnitOfMeasure().getTranslation();
            case 5 ->
                product.getQuantity();
            default ->
                null;
        };
    }

    /**
     * Determina se a célula na posição especificada é editável.
     *
     * @param rowIndex o índice da linha.
     * @param columnIndex o índice da coluna.
     * @return false indicando que nenhuma célula é editável.
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
