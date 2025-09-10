## 1. Objetivo do Projeto e Fluxo do Usuário

### Objetivo
Este projeto é um **conjunto de automação de testes** para uma API REST (especificamente, a API DemoQA BookStore). Seu principal objetivo é verificar automaticamente se os endpoints da API para gerenciamento de usuários e operações da livraria se comportam conforme o esperado, seguindo as regras e requisitos de negócios.

### Fluxo do Usuário Final
- O **Engenheiro de QA** ou **Desenvolvedor** escreve e executa testes automatizados.
- Os testes simulam o uso real da API: criação de usuários, geração de tokens, autorização, listagem e reserva de livros.
- Os resultados são validados automaticamente e quaisquer falhas são reportadas, garantindo que a API atenda aos padrões exigidos.

## 2. Padrões Arquiteturais e Melhores Práticas

### Objetos de API (Objetos de Página para API)
- **Padrão Utilizado:** O código utiliza o padrão "Objeto de API", análogo ao padrão Objeto de Página em testes de IU. Cada endpoint da API é encapsulado em sua própria classe, promovendo:
- **Separação de responsabilidades** (lógica da API vs. lógica de teste)
- **Reusabilidade** (métodos da API podem ser usados ​​em múltiplos testes)
- **Manutenção** (alterações nos endpoints são localizadas)

### Estrutura do Projeto
- **apiobjects/**: Contém classes para interagir com endpoints da API.
- **tests/**: Contém classes de teste que utilizam os objetos da API.


