# Sales Control

## Status:
* Em desenvolvimento


## Teconlogias:
- Java
- Swing
- MySQL

## Desenvolvedores:
Maria Eduarda Schwinn

## Objetivo:
Maior controle de estoque e vendas realizadas por uma indústria de comércio

## Funcionalidades:
* ### Login
  * Garantindo maior segurança com diferença de acessos para funcionários e administradores


* ### Registro de produtos
  * Permissão: Apenas administradores
  * Preenchimento de nome, categoria, preço unitário, unidade de medida e quantidade do produto


* ### Registro de vendas
  * Permissão: Administradores e funcionários
  * Seleção de produtos disponíveis, informando a quantidade e adicionando ao carrinho 
    * Cálculo do valor total 
    * Finalização da venda


* ### Edição de produtos
  * Permissão: Apenas administradores
  * Pesquisa por produtos disponíveis
  * Exclusão de produtos
  * Edição de produtos
    * Valor
    * Quantidade


* ### Relatórios de vendas
  * Permissão: Apenas administradores
  * Pesquisa por nome, categoria, datas
  * Exportação dos dados apresentados para arquivo localizado na raiz do projeto em _relatorios/vendas_dataAtualFormatada.csv_
