## . Casos de Teste

### 5.1 Cadastro de Cliente
| Caso | Entrada | Resultado Esperado |
|------|---------|------------------|
| 1 | Nome: João<br>Telefone: 12345678<br>Endereço: Rua A | Cliente adicionado à lista, código gerado `CL-001` |

### 5.2 Cadastro de Funcionário
| Caso | Entrada | Resultado Esperado |
|------|---------|------------------|
| 1 | Nome: Maria<br>Telefone: 87654321<br>Salário: 2000<br>Cargo: Recepcionista | Funcionário adicionado à lista, código gerado `FN-001`, salário convertido para float |

### 5.3 Cadastro de Quarto
| Caso | Entrada | Resultado Esperado |
|------|---------|------------------|
| 1 | Número: 101<br>Quantidade de hóspedes: 2<br>Diária: 150 | Quarto adicionado à lista, status inicial `Disponível` |
| 2 | Número já existente | Mensagem de erro, nenhum quarto adicionado |

### 5.4 Cadastro de Estadia
| Caso | Entrada | Resultado Esperado |
|------|---------|------------------|
| 1 | Código de cliente existente, quarto disponível, datas válidas | Estadia cadastrada, quarto reservado, status atualizado para `Ocupado`, cálculo do total da diária validado indiretamente |
| 2 | Quarto já ocupado | Nenhuma estadia cadastrada, status do quarto permanece `Ocupado`, mensagem de aviso exibida |
| 3 | Código de cliente inexistente | Nenhuma estadia cadastrada, mensagem de erro: "Cliente não encontrado!" |
| 4 | Data de saída anterior à entrada | Nenhuma estadia cadastrada, mensagem de erro: "Data de saída deve ser posterior à entrada" |
| 5 | Nenhum quarto disponível para a quantidade de hóspedes | Nenhuma estadia cadastrada, mensagem de aviso exibida |

## . Resultados de Teste
Todos os testes automatizados foram executados com sucesso:
- Cadastro de clientes: ✅ Passou  
- Cadastro de funcionários: ✅ Passou  
- Cadastro de quartos: ✅ Passou, incluindo tentativa de duplicidade  
- Cadastro de estadias: ✅ Passou, incluindo casos de erro  

Observações:
- O valor total da estadia é calculado temporariamente e verificado de forma indireta.  
- A persistência em arquivos JSON foi simulada para não alterar dados reais.
