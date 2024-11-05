package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {
			System.out.println("											");
			System.out.println("											");
			System.out.println("			BANCO BRASILEIRO				");
			System.out.println("											");
			System.out.println("											");
			System.out.println("		1 - Criar conta						");
			System.out.println("		2 - Listar todas as conta			");
			System.out.println("		3 - Buscar conta por número			");
			System.out.println("		4 - Atualizar dados na conta		");
			System.out.println("		5 - Apagar conta					");
			System.out.println("		6 - Sacar							");
			System.out.println("		7 - Depositar						");
			System.out.println("		8 - Transferir entre contas			");
			System.out.println("		9 - Sair							");
			System.out.println("											");
			System.out.println("Digite a opção desejada:					");
			System.out.println("											");
			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("Banco Brasileiro - O seu futuro começa aqui!");
				sobre();

				leia.close();

				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println("Criar conta\n\n");
				break;
			case 2:
				System.out.println("Listar todas as contas\n\n");
				break;
			case 3:
				System.out.println("Consultar dados da conta - por número\n\n");
				break;
			case 4:
				System.out.println("Atualizar dados da conta\n\n");
				break;
			case 5:
				System.out.println("Apagar a conta\n\n");
				break;
			case 6:
				System.out.println("Saque\n\n");
				break;
			case 7:
				System.out.println("Depósito\n\n");
				break;
			case 8:
				System.out.println("Transferência entre contas\n\n");
				break;
			default:
				System.out.println("\nOpção inválida!\n");
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
