# Desafio Técnico - Sistema de Funcionários (Java)

Este projeto foi desenvolvido como solução para um teste técnico de vaga para desenvolvedor Java.

---

## 📌 Descrição do Desafio

O objetivo foi implementar um sistema para gerenciamento de funcionários de uma indústria, seguindo requisitos específicos como:

* Manipulação de listas de funcionários
* Remoção e filtragem de dados
* Ordenação e agrupamento
* Cálculos salariais com precisão
* Exibição formatada de dados

---

## 🧠 Tecnologias e Conceitos Utilizados

* Java
* Programação Orientada a Objetos (POO)

  * Herança
  * Abstração
  * Encapsulamento
* Collections (List, Map)
* `BigDecimal` para cálculos financeiros
* API de datas (`LocalDate`)

---

## 🏗️ Estrutura do Projeto

```
src/
 ├── model
 │    ├── Pessoa.java
 │    ├── Funcionario.java
 │
 ├── service
 │    └── FuncionarioService.java
 │
 ├── util
 │    ├── CalculadoraUtil.java
 │    ├── FormatadorUtil.java
 │
 └── Main.java
```


---

## ⚙️ Funcionalidades Implementadas

* Inserção de funcionários
* Remoção de funcionário específico
* Impressão formatada (datas e valores)
* Aplicação de aumento salarial (10%)
* Agrupamento por função
* Filtragem por mês de aniversário
* Identificação do funcionário mais velho
* Ordenação alfabética
* Cálculo do total de salários
* Cálculo de salários mínimos por funcionário

---

## 💰 Precisão nos Cálculos

Os valores monetários foram tratados com `BigDecimal`, evitando problemas de precisão comuns com `double`.

---

## 🚀 Como Executar

1. Clone o repositório
2. Abra na IDE (IntelliJ IDEA)
3. Execute a classe `Principal`

---

## 📌 Observações

O projeto foi estruturado com separação de responsabilidades (model, service, util), visando melhor organização e manutenção do código.

---

## 👨‍💻 Autor

Carlos Jeferson
