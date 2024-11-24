package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) throws Exception {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino = 0;
		String titular;
		float saldo, limite, valor;

		while (true) {

			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_CYAN_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO NACIONAL                       ");
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

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_CYAN_BOLD + "Banco Nacional - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Criar conta\n\n");

				System.out.println(Cores.TEXT_BLACK + "Digite o número da agência: ");
				agencia = leia.nextInt();
				System.out.println(Cores.TEXT_BLACK + "Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println(Cores.TEXT_BLACK + "Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println(Cores.TEXT_BLACK + "Digite o saldo da conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println(Cores.TEXT_BLACK + "Digite o limite de crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(
							new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite)
						);
				}
				case 2 -> {
					System.out.println(Cores.TEXT_BLACK + "Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(
									contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario)
						);
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Consultar dados da conta por número\n\n");

				System.out.println(Cores.TEXT_BLACK + "Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Atualizar dados da conta\n\n");

				System.out.println(Cores.TEXT_BLACK + "Digite o número da conta: ");
				numero = leia.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					System.out.println(Cores.TEXT_BLACK + "Digite o número da agência: ");
					agencia = leia.nextInt();
					System.out.println(Cores.TEXT_BLACK + "Digite o nome do titular da conta: ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					System.out.println(Cores.TEXT_BLACK + "Informe o saldo da conta (R$): ");
					saldo = leia.nextFloat();

					tipo = buscaConta.getTipo();

					switch (tipo) {
						case 1 -> {
							System.out.println(Cores.TEXT_BLACK + "Digite o valor de limite de crédito: ");
							limite = leia.nextFloat();

							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
						case 2 -> {
							System.out.println(Cores.TEXT_BLACK + "Digite o dia do aniversário da conta: ");
							aniversario = leia.nextInt();

							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
						default -> {
							System.out.println(Cores.TEXT_RED + "O tipo de conta digitado é inválido.");
					}
					}
				} else
					System.out.println(Cores.TEXT_RED + "Desculpe, a conta informada não foi encontrada.");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Apagar a conta\n\n");

				System.out.println(Cores.TEXT_BLACK + "Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Saque\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Depósito\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				do {
					System.out.println("Digite o valor do depósito (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_CYAN_BOLD + "Transferência entre contas\n\n");
				
				System.out.println("Digite o número da conta de origem: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt();

				do {
					System.out.println("Digite o valor (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção inválida!\n" + Cores.TEXT_RESET);

				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_CYAN_BOLD + "\n\n\n											");
		System.out.println("Projeto desenvolvido por Anna Carolina Vighi");
		System.out.println("Generation Brasil - vighianna@gmail.com		");
		System.out.println("https://github.com/annavighi				");
		System.out.println("											");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println(Cores.TEXT_RED_BOLD + "Você pressionou uma tecla diferente de enter!");

		}
	}
}