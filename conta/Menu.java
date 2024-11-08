package conta;

import java.util.Scanner;

import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		        
				// Teste da Classe Conta Corrente
				ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
				cc1.visualizar();
				cc1.sacar(12000.0f);
				cc1.visualizar();
				cc1.depositar(5000.0f);
				cc1.visualizar();
				
		        // Teste da Classe Conta Poupança
				ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f);
				cp1.visualizar();
		        cp1.sacar(1000.0f);
				cp1.visualizar();
				cp1.depositar(5000.0f);
				cp1.visualizar();
				
		Scanner leia = new Scanner(System.in);
		int opcao;

		while (true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO NACIONAL        	         ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_BLUE_BOLD + "Banco Nacional - O seu futuro começa aqui!");
				sobre();

				leia.close();

				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Criar conta\n\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Listar todas as contas\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Consultar dados da conta - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Atualizar dados da conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Apagar a conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Saque\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Depósito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_BLUE_BOLD + "Transferência entre contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção inválida!\n");
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("											");
		System.out.println("Projeto desenvolvido por Anna Carolina Vighi");
		System.out.println("Generation Brasil - vighianna@gmail.com		");
		System.out.println("https://github.com/annavighi				");
		System.out.println("											");
	}
}
