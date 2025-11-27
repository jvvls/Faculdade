import json
from datetime import datetime
from cliente import Cliente
from funcionarios import Funcionario
from quarto import Quarto
from estadia import Estadia


def carregarArquivo(nomeArquivo):
    try:
        with open(nomeArquivo, "r") as f:
            return json.load(f)
    except FileNotFoundError:
        return []

def salvarArquivo(nomeArquivo, dados):
    with open(nomeArquivo, "w") as f:
        json.dump(dados, f, default=lambda o: o.__dict__, indent=4)

def gerarCodigo(prefixo, listaExistente):
    numeros = [int(item['codigo'].split('-')[1]) for item in listaExistente if 'codigo' in item]
    proximo = max(numeros, default=0) + 1
    return f"{prefixo}-{proximo:03d}"

def lerData(prompt):
    while True:
        dataStr = input(prompt)
        try:
            data = datetime.strptime(dataStr, "%d/%m/%Y")
            return data
        except ValueError:
            print("Data inválida! Use o formato DD/MM/AAAA com 4 dígitos no ano.")

class Menu:
    def __init__(self):
        self.clientes = carregarArquivo("clientes.json")
        self.funcionarios = carregarArquivo("funcionarios.json")
        self.quartos = carregarArquivo("quartos.json")
        self.estadias = carregarArquivo("estadias.json")

    def display(self):
        print("\n--- Menu Principal ---")
        print("1. Cadastrar Cliente")
        print("2. Cadastrar Funcionário")
        print("3. Cadastrar Quarto")
        print("4. Cadastrar Estadia")
        print("5. Listar Cadastros")
        print("6. Sair")

    def getChoice(self):
        while True:
            try:
                choice = int(input("Escolha uma opção: "))
                if 1 <= choice <= 6:
                    return choice
                print("Opção inválida.")
            except ValueError:
                print("Digite um número válido.")

    def run(self):
        while True:
            self.display()
            choice = self.getChoice()
            if choice == 1:
                self.cadastrarCliente()
            elif choice == 2:
                self.cadastrarFuncionario()
            elif choice == 3:
                self.cadastrarQuarto()
            elif choice == 4:
                self.cadastrarEstadia()
            elif choice == 5:
                self.listarCadastros()
            elif choice == 6:
                print("Saindo...")
                break

    def cadastrarCliente(self):
        nome = input("Nome do Cliente: ")
        codigo = gerarCodigo("CL", self.clientes)
        telefone = input("Telefone: ")
        endereco = input("Endereço: ")

        if any(c['codigo'] == codigo for c in self.clientes):
            print("Erro: Cliente com este código já existe.")
            return

        cliente = Cliente(nome, codigo, telefone, endereco)
        self.clientes.append(cliente.__dict__)
        salvarArquivo("clientes.json", self.clientes)
        print(f"Cliente {nome} cadastrado com código {codigo}.")

    def cadastrarFuncionario(self):
        nome = input("Nome do Funcionário: ")
        codigo = gerarCodigo("FN", self.funcionarios)
        telefone = input("Telefone: ")
        salario = float(input("Salário: "))
        cargo = input("Cargo: ")

        if any(f['codigo'] == codigo for f in self.funcionarios):
            print("Erro: Funcionário com este código já existe.")
            return

        funcionario = Funcionario(nome, codigo, telefone, salario, cargo)
        self.funcionarios.append(funcionario.__dict__)
        salvarArquivo("funcionarios.json", self.funcionarios)
        print(f"Funcionário {nome} cadastrado com código {codigo}.")

    def cadastrarQuarto(self):
        numero = input("Número do Quarto: ")
        if any(q['numero'] == numero for q in self.quartos):
            print("Erro: Quarto com este número já existe.")
            return

        quantidadeHospedes = int(input("Quantidade de Hóspedes: "))
        diaria = float(input("Diária: "))
        status = "Disponível"

        quarto = Quarto(numero, quantidadeHospedes, diaria, status)
        self.quartos.append(quarto.__dict__)
        salvarArquivo("quartos.json", self.quartos)
        print(f"Quarto {numero} cadastrado com sucesso.")

    def cadastrarEstadia(self):
        codigoCliente = input("Código do Cliente: ")
        cliente = next((c for c in self.clientes if c['codigo'] == codigoCliente), None)
        if not cliente:
            print("Cliente não encontrado!")
            return

        quantidadeHospedes = int(input("Quantidade de hóspedes: "))
        dataEntrada = lerData("Data de entrada (DD/MM/AAAA): ")
        dataSaida = lerData("Data de saída (DD/MM/AAAA): ")

        dias = (dataSaida - dataEntrada).days
        if dias <= 0:
            print("Data de saída deve ser posterior à entrada.")
            return

        quarto = next((q for q in self.quartos if q['status'] == "Disponível" and q['quantidadeHospedes'] >= quantidadeHospedes), None)
        if not quarto:
            print("Nenhum quarto disponível para esta quantidade de hóspedes.")
            return

        diariaTotal = dias * quarto['diaria']
        codigoEstadia = gerarCodigo("ES", self.estadias)

        estadia = Estadia(codigoEstadia, quarto['numero'], dataEntrada.strftime("%d/%m/%Y"), dataSaida.strftime("%d/%m/%Y"), diariaTotal)
        self.estadias.append(estadia.__dict__)
        salvarArquivo("estadias.json", self.estadias)

        quarto['status'] = "Ocupado"
        salvarArquivo("quartos.json", self.quartos)

        print(f"Estadia cadastrada! Quarto {quarto['numero']} reservado por {dias} dias, total: R${diariaTotal:.2f}")

    def listarCadastros(self):
        print("\n--- Clientes ---")
        for c in self.clientes:
            print(c)
        print("\n--- Funcionários ---")
        for f in self.funcionarios:
            print(f)
        print("\n--- Quartos ---")
        for q in self.quartos:
            print(q)
        print("\n--- Estadias ---")
        for e in self.estadias:
            print(e)
            
if __name__ == "__main__":
    menu = Menu()
    menu.run()
