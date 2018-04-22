## 1º Trabalho - DCC192
##### Aluno: João Paulo Dias
##### Matrícula: 201576017
##### Curso: Sistemas de Informação

## Objetivo do Sistema
O sistema foi desenvolvido para gerenciar os produtos quanto ao seu nome e valor de venda e gerenciar mesas de um estabelecimento comercial quanto aos produtos 
pedidos na mesa, assim como o valor total da comanda. Oportunizando o fechamento do pedido, quando o cliente pede o total e deixa a mesa e gerando um resumo de 
informações sobre o pedido e seus itens. 

## Modelo de Dados
O modelo de dados está disponível _na raíz do Projeto_ e _no link_: 
[https://drive.google.com/file/d/0B2tDgEVXFkfUVEZRcER3OWVGMWc/view](https://drive.google.com/file/d/0B2tDgEVXFkfUVEZRcER3OWVGMWc/view "Modelo de Dados").

Ele consiste no uso de uma Classe Mesa que possui um id, uma descrição e N Pedidos que, por sua vez, possuem um id, uma descrição e N Itens, formados por um 
Produto(id, descrição e valor) e uma quantidade inteira.

## Campos Necessários para a Construção das Telas
Foram utilizados HTML com especificações de estilo com CSS e o Framework Bootstrap, além de Javascript. Sendo criado tabelas para impressão dos dados e 
formulários para a inclusão de itens no pedido

## Pontos importantes do funcionamento da interface
Para o gerenciamento de mesas é necessário selecionar uma mesa e a partir dela incluir um novo pedido. Dentro da janela do pedido é possível gerenciar 
os produtos pedidos e suas quantidades. Enquanto o pedido não for fechado é possível adicionar itens a ele. Após o pedido fechado, é demonstrado um resumo do pedido e não é mais 
possível adicionar dados a ele.

## Pontos que apresentaram maior dificuldade de implementação
A implementação dos Servlets e as lógicas de mudança de requisições e respostas tiveram certo grau de dificuldade. Assim como a manipulação do JSTL.

## Pontos onde podem ser realizadas melhorias futuras

Devem ser feitas melhorias a cerca dos dados, utilizando um banco de dados para facilitar o uso e também permitir a criação de novas funcionalidades.

A interface necessita de melhorias quanto a implementação de atalhos, a sinalização de pedidos fechados na tabela de pedidos.
