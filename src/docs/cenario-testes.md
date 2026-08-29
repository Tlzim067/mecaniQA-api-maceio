# Cenarios de Teste - MecaniQA

## CT01 - Cadastro de Peca

Dado que o sistema possui uma peca valida,
quando a peca for cadastrada,
entao ela deve aparecer na lista de pecas.

Resultado esperado:
Peca cadastrada com sucesso.

---

## CT02 - Busca de Peca

Dado que existe uma peca com ID 1,
quando o sistema realizar a busca pelo ID 1,
entao a peca deve ser encontrada.

Resultado esperado:
Pastilha de Freio encontrada.

---

## CT03 - Remocao de Estoque

Dado que a Pastilha de Freio possui 10 unidades,
quando forem removidas 2 unidades,
entao o estoque deve ficar com 8 unidades.

Resultado esperado:
Estoque depois: 8.

---

## CT04 - Estoque Insuficiente

Dado que existem 8 unidades no estoque,
quando o sistema tentar remover 100 unidades,
a operacao deve ser recusada.

Resultado esperado:
Nao permitir estoque negativo.