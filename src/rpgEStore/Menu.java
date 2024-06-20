package rpgEStore;

import java.io.IOException;
import java.util.*;
import rpgEStore.util.*;

public class Menu {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		String nomeProduto, descricaoProduto;
		int opcao, iDProduto, categoriaProduto, estoqueProduto;
		float precoProduto;
		boolean statusProduto;

		while (true) {

			System.out.println(Cores.TEXT_BLACK_BOLD + 
					           "_________________________________________________________");
			System.out.println(Cores.ANSI_WHITE_BACKGROUND + 
					           "                                                         ");
			System.out.println("             MENU - Role Playing E-Store                 ");
			System.out.println("_________________________________________________________");
			System.out.println("                                                         ");
			System.out.println("      1- Cadastrar produto                               ");
			System.out.println("      2- Listar todos os Produtos                        ");
			System.out.println("      3- Listar Produtos por Categoria                   ");
			System.out.println("      4- Buscar Produtos por ID                          ");
			System.out.println("      5- Atualizar Dados de Produtos                     ");
			System.out.println("      6- Excluir Produto                                 ");
			System.out.println("      7- Sair                                            ");
			System.out.println("_________________________________________________________");
			System.out.println("                                                         ");
			System.out.println("   Entre com a opção desejada:                           ");
			System.out.println("_________________________________________________________" + Cores.TEXT_RESET);
			
			//Captura e aviso do erro caso o usuário não digite um número inteiro
			try {
				opcao = ler.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BRIGHT+"\nDigite valores inteiros!"+Cores.TEXT_RESET);
				ler.nextLine();
				opcao = 0;
			}
			
			//Encerramento do sistema e créditos
			if(opcao == 7) {
				System.out.println(Cores.TEXT_BLACK_BOLD
						          +"_________________________________________________________");
				System.out.println(Cores.ANSI_WHITE_BACKGROUND
						          +"                                                         ");
				System.out.println("     Role Playing E-Store - Trazendo vida aos RPGs       ");
				sobre();
				ler.close();
				System.exit(0); //Método que encerra o programa
			}
			
			switch(opcao){
				
			case 1:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
						           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
						           "  Cadastrar Produto                                      ");
				System.out.println("                                                         ");
				//
				break;
				
			case 2:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
				                   "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
				                   "  Listar Produtos                                        ");
				System.out.println("                                                         ");
				//
				break;
				
			case 3:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
						           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
						           "  Listar por Categoria                                   ");
				System.out.println("                                                         ");
				//
				break;
				
			case 4:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
		                           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
		                           "  Buscar Produto                                         ");
				System.out.println("                                                         ");
				//
				break;
				
			case 5:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
		                           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
		                           "  Atualizar Produto                                      ");
				System.out.println("                                                         ");
				//
				break;
				
			case 6:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
		                           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
		                           "  Excluir Produto                                        ");
				System.out.println("                                                         ");
				//
				break;
				
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT+"Opção inválida!");
				break;
			
			}
		}
	}
	
	public static void sobre() {
		System.out.println("_________________________________________________________");
		System.out.println("                                                         ");
		System.out.println(" Projeto Desenvolvido por: Weida Winy Rodrigues Viana    ");
		System.out.println(" Weida Viana - winnyweida@hotmail.com                    ");
		System.out.println(" https://github.com/Ms-Winny                             ");
		System.out.println("_________________________________________________________");
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET+"\nPressione enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter");
		  }
	}

}
