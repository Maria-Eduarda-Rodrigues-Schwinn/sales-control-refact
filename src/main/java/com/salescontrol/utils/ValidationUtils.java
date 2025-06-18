package com.salescontrol.utils;

import com.salescontrol.enuns.Category;
import com.salescontrol.enuns.UnitOfMeasure;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Classe utilitária para validação de entradas.
 * <p>
 * Esta classe fornece métodos para validar entradas de produtos e vendas,
 * garantindo que todas as entradas fornecidas atendam aos critérios esperados.
 * </p>
 */
public class ValidationUtils {

    /**
     * Comprimento máximo do nome do produto.
     */
    private static final int MAX_NAME_LENGTH = 100;

    /**
     * Valida as entradas fornecidas para um produto.
     *
     * @param name o nome do produto.
     * @param category a categoria do produto.
     * @param unitPrice o preço unitário do produto.
     * @param unitOfMeasure a unidade de medida do produto.
     * @param quantity a quantidade do produto.
     * @throws IllegalArgumentException se alguma entrada for inválida.
     */
    public static void validateProductInputs(String name, String category, double unitPrice, String unitOfMeasure, int quantity) {
        if (!isValidName(name)) {
            String message = "Nome inválido. Não deve estar vazio, não deve conter apenas números e deve ter no máximo " + MAX_NAME_LENGTH + " caracteres.";
            JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Nome inválido.");
        }

        if (!isValidCategory(category)) {
            JOptionPane.showMessageDialog(null, "Categoria inválida. Por favor, selecione uma categoria válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Categoria inválida.");
        }

        if (unitPrice <= 0) {
            JOptionPane.showMessageDialog(null, "Preço unitário inválido. Deve ser um valor positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Preço unitário inválido.");
        }

        if (!isValidUnitOfMeasure(unitOfMeasure)) {
            JOptionPane.showMessageDialog(null, "Unidade de medida inválida. Por favor, selecione uma unidade de medida válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Unidade de medida inválida.");
        }

        if (quantity < 0) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida. Não pode ser um valor negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Quantidade inválida.");
        }
    }

    /**
     * Valida o nome do produto.
     *
     * @param name o nome do produto.
     * @return true se o nome é válido, caso contrário false.
     */
    public static boolean isValidName(String name) {
        return !name.isEmpty() && !Pattern.matches("\\d+", name) && name.length() <= MAX_NAME_LENGTH;
    }

    /**
     * Valida a categoria do produto.
     *
     * @param category a categoria do produto.
     * @return true se a categoria é válida, caso contrário false.
     */
    public static boolean isValidCategory(String category) {
        for (Category c : Category.values()) {
            if (c.getTranslation().equals(category)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida a unidade de medida do produto.
     *
     * @param unitOfMeasure a unidade de medida do produto.
     * @return true se a unidade de medida é válida, caso contrário false.
     */
    public static boolean isValidUnitOfMeasure(String unitOfMeasure) {
        for (UnitOfMeasure uom : UnitOfMeasure.values()) {
            if (uom.getTranslation().equals(unitOfMeasure)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida as entradas fornecidas para uma venda.
     *
     * @param saleDate a data da venda.
     * @param totalValue o valor total da venda.
     * @throws IllegalArgumentException se alguma entrada for inválida.
     */
    public static void validateSaleInputs(Date saleDate, double totalValue) {
        if (saleDate == null || !isValidDate(saleDate)) {
            JOptionPane.showMessageDialog(null, "Data de venda inválida. Por favor, insira uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Data de venda inválida.");
        }

        if (totalValue <= 0) {
            JOptionPane.showMessageDialog(null, "Valor total inválido. Deve ser um valor positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Valor total inválido.");
        }
    }

    /**
     * Valida se a data é válida.
     *
     * @param date a data.
     * @return true se a data é válida, caso contrário false.
     */
    public static boolean isValidDate(Date date) {
        return date.before(new Date());
    }
}
