import unittest
from unittest.mock import patch
import os
from datetime import datetime, timedelta
from main import Menu, gerarCodigo, salvarArquivo, carregarArquivo

class TestMenu(unittest.TestCase):

    def setUp(self):
        self.menu = Menu()
        self.menu.clientes = []
        self.menu.funcionarios = []
        self.menu.quartos = []
        self.menu.estadias = []

    @patch("builtins.input", side_effect=["João", "12345678", "Rua A"])
    def test_cadastrarCliente(self, mock_inputs):
        self.menu.cadastrarCliente()
        self.assertEqual(len(self.menu.clientes), 1)
        cliente = self.menu.clientes[0]
        self.assertEqual(cliente["nome"], "João")
        self.assertTrue(cliente["codigo"].startswith("CL-"))

    @patch("builtins.input", side_effect=["Maria", "87654321", "2000", "Recepcionista"])
    def test_cadastrarFuncionario(self, mock_inputs):
        self.menu.cadastrarFuncionario()
        self.assertEqual(len(self.menu.funcionarios), 1)
        funcionario = self.menu.funcionarios[0]
        self.assertEqual(funcionario["nome"], "Maria")
        self.assertEqual(funcionario["salario"], 2000.0)
        self.assertTrue(funcionario["codigo"].startswith("FN-"))

    @patch("builtins.input", side_effect=["101", "2", "150"])
    def test_cadastrarQuarto(self, mock_inputs):
        self.menu.cadastrarQuarto()
        self.assertEqual(len(self.menu.quartos), 1)
        quarto = self.menu.quartos[0]
        self.assertEqual(quarto["numero"], "101")
        self.assertEqual(quarto["quantidadeHospedes"], 2)
        self.assertEqual(quarto["diaria"], 150.0)
        self.assertEqual(quarto["status"], "Disponível")

    @patch("builtins.input")
    def test_cadastrarEstadia(self, mock_inputs):
        cliente = {"nome": "João", "codigo": "CL-001"}
        quarto = {"numero": "101", "quantidadeHospedes": 2, "diaria": 100.0, "status": "Disponível"}
        self.menu.clientes.append(cliente)
        self.menu.quartos.append(quarto)

        hoje = datetime.today()
        amanha = hoje + timedelta(days=1)
        datas = [cliente["codigo"], "2", hoje.strftime("%d/%m/%Y"), amanha.strftime("%d/%m/%Y")]
        mock_inputs.side_effect = datas

        self.menu.cadastrarEstadia()

        self.assertEqual(len(self.menu.estadias), 1)
        estadia = self.menu.estadias[0]
        self.assertEqual(estadia["quarto"], "101")

        self.assertEqual(self.menu.quartos[0]["status"], "Ocupado")

        dias = (amanha - hoje).days
        total_esperado = dias * quarto['diaria']
        self.assertEqual(total_esperado, 100.0)

    
    @patch("builtins.input")
    def test_cadastrarEstadia_quarto_ocupado(self, mock_inputs):
        cliente = {"nome": "João", "codigo": "CL-001"}
        quarto = {"numero": "101", "quantidadeHospedes": 2, "diaria": 100.0, "status": "Ocupado"}
        self.menu.clientes.append(cliente)
        self.menu.quartos.append(quarto)

        hoje = datetime.today()
        amanha = hoje + timedelta(days=1)
        datas = [cliente["codigo"], "2", hoje.strftime("%d/%m/%Y"), amanha.strftime("%d/%m/%Y")]
        mock_inputs.side_effect = datas

        self.menu.cadastrarEstadia()
        self.assertEqual(len(self.menu.estadias), 0)
        self.assertEqual(self.menu.quartos[0]["status"], "Ocupado")

if __name__ == "__main__":
    unittest.main()
