package rpgEStore;

import java.io.IOException;
import java.util.*;
import rpgEStore.controller.ProdutoController;
import rpgEStore.model.*;
import rpgEStore.util.*;

public class Menu {

	public static void main(String[] args) {
		ProdutoController produtos = new ProdutoController();
		Scanner ler = new Scanner(System.in);
		String nomeProduto, descricaoProduto;
		int opcao, iDProduto, categoriaProduto, estoqueProduto;
		float precoProduto;
		boolean statusProduto;
		
		//teste da subclasse Miniatura
		Miniatura m1 = new Miniatura(1, "Miniatura Urso coruja", 3, 0, 30f, "Uma encantadora miniatura de urso coruja, combinando a força de um urso com as asas e a cabeça de uma coruja, pintada com detalhes realistas em tons de marrom e cinza. Ideal para adicionar um toque mágico e selvagem à sua coleção de RPG.", false);
		produtos.cadastrarProduto(m1);
		
		Miniatura m2 = new Miniatura(2, "Miniatura Tiamat", 3, 13, 100f, "Uma majestosa miniatura de Tiamat, a deusa dragão de cinco cabeças, exibindo suas escamas detalhadas e vibrantes em tons de vermelho, azul, verde, branco e preto. Perfeita para colecionadores e jogadores de RPG, capturando a imponência e o poder mitológico.", true);
		produtos.cadastrarProduto(m2);
		
		Dados d1 = new Dados(3, "Dados Esmeralda", 1, 8, 15f, "Um deslumbrante conjunto de dados cor esmeralda, cintilando com uma profundidade verde luxuosa e números dourados nítidos. Essenciais para jogadores de RPG, esses dados oferecem uma experiência de jogo elegante e sofisticada.", true);
		produtos.cadastrarProduto(d1);
		
		Dados d2 = new Dados(4, "Dados Celestes", 1, 26, 15f, "Um encantador conjunto de dados azuis com estrelas brilhantes, evocando a beleza de um céu noturno estrelado. Perfeito para jogadores de RPG, esses dados adicionam um toque celestial e mágico às suas aventuras.", true);
		produtos.cadastrarProduto(d2);
		
		Tabuleiro t1 = new Tabuleiro(5, "Catan", 2, 5, 250f, "\"Catan\", um premiado jogo de tabuleiro, desafia os jogadores a colonizar uma ilha, coletando recursos e construindo assentamentos. Estratégia e negociação são essenciais para dominar este clássico envolvente, ideal para encontros familiares e entre amigos.", true);
		produtos.cadastrarProduto(t1);
		
		Livro l1 = new Livro(6, "Guia de Volo para Monstros", 4, 0, 120f, "\"Guia de Volo para Monstros\" é um livro indispensável para fãs de Dungeons & Dragons, oferecendo descrições detalhadas e histórias fascinantes de monstros icônicos. Com ilustrações impressionantes e informações valiosas, é uma ferramenta essencial para mestres e jogadores aprimorarem suas aventuras.", false);
		produtos.cadastrarProduto(l1);
		
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
				System.out.println(Cores.TEXT_BLACK_BOLD+
				                   "_________________________________________________________");
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
						           "                                                         ");
				System.out.println("  Cadastrar Produto                                      ");
				System.out.println(
		                           "_________________________________________________________");
				System.out.println(Cores.TEXT_RESET+"Digite o iD do Produto: " );
				iDProduto = ler.nextInt();
				
				System.out.println("\nDigite o nome do Produto: ");
				ler.skip("\\R?"); //Serve para ignorar o \r para que o programa aceite nomes compostos
				nomeProduto = ler.nextLine();
				
				do {
					System.out.println("\nDigite a categoria (1- Dado, 2- Tabuleiro, 3- Miniatura, 4- Livro)");	
					categoriaProduto = ler.nextInt();
				} while(categoriaProduto < 1 && categoriaProduto > 4);
				
				System.out.println("\nDigite a quantidade em estoque: ");
				estoqueProduto = ler.nextInt();
				
				System.out.println("\nDigite o preço do produto (R$): ");
				precoProduto = ler.nextFloat();
				
				System.out.println("\nQual a descrição do produto: ");
				ler.nextLine();
				descricaoProduto = ler.nextLine();
				
				if (estoqueProduto > 0) {
					statusProduto = true;
				} else {
					statusProduto = false;
				}
				
				switch(categoriaProduto) {
				case 1:
					produtos.cadastrarProduto(new Dados(iDProduto, nomeProduto, categoriaProduto, estoqueProduto, precoProduto, descricaoProduto, statusProduto));
					break;
					
				case 2:
					produtos.cadastrarProduto(new Tabuleiro(iDProduto, nomeProduto, categoriaProduto, estoqueProduto, precoProduto, descricaoProduto, statusProduto));
					break;
					
				case 3:
					produtos.cadastrarProduto(new Miniatura(iDProduto, nomeProduto, categoriaProduto, estoqueProduto, precoProduto, descricaoProduto, statusProduto));
					break;
					
				case 4:
					produtos.cadastrarProduto(new Livro(iDProduto, nomeProduto, categoriaProduto, estoqueProduto, precoProduto, descricaoProduto, statusProduto));
					break;
				}		
					
				break;
				
			case 2:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
				                   "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
				                   "  Listar Produtos                                        ");
				System.out.println("                                                         "+Cores.TEXT_RESET);
				produtos.listarTodos();
				break;
				
			case 3:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
						           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
						           "  Listar por Categoria                                   ");
				System.out.println("                                                         "+Cores.TEXT_RESET);
				System.out.println("Digite o número da categoria do produto (1- Dado, 2- Tabuleiro, 3- Miniatura, 4- Livro):");
				categoriaProduto = ler.nextInt();
				
				produtos.listarPorCategoria(categoriaProduto);
				
				break;
				
			case 4:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
		                           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
		                           "  Buscar Produto                                         ");
				System.out.println("                                                         "+Cores.TEXT_RESET);

				System.out.println("Digite o ID do produto:");
				iDProduto = ler.nextInt();
				
				produtos.procurarPorID(iDProduto);
				
				break;
				
			case 5:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
		                           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
		                           "  Atualizar Produto                                      ");
				System.out.println("                                                         "+Cores.TEXT_RESET);
				System.out.println("Digite o ID do produto para busca:");
				iDProduto = ler.nextInt();
				
				var buscaProduto = produtos.buscarNaCollection(iDProduto);
				
				if(buscaProduto != null) {
					System.out.println(Cores.TEXT_RESET+"Digite novo iD do Produto: " );
					iDProduto = ler.nextInt();
					
					System.out.println("\nDigite o novo nome do Produto: ");
					ler.skip("\\R?"); //Serve para ignorar o \r para que o programa aceite nomes compostos
					nomeProduto = ler.nextLine();
					
					do {
						System.out.println("\nDigite a categoria (1- Dado, 2- Tabuleiro, 3- Miniatura, 4- Livro)");	
						categoriaProduto = ler.nextInt();
					} while(categoriaProduto < 1 && categoriaProduto > 4);
					
					System.out.println("\nDigite a quantidade em estoque: ");
					estoqueProduto = ler.nextInt();
					
					System.out.println("\nDigite o preço do produto (R$): ");
					precoProduto = ler.nextFloat();
					
					System.out.println("\nQual a descrição do produto: ");
					ler.nextLine();
					descricaoProduto = ler.nextLine();
					
					if (estoqueProduto > 0) {
						statusProduto = true;
					} else {
						statusProduto = false;
					}
					
					switch(categoriaProduto) {
					case 1:
						produtos.atualizar(new Dados(iDProduto, nomeProduto, categoriaProduto, estoqueProduto, precoProduto, descricaoProduto, statusProduto));
						break;
						
					case 2:
						produtos.atualizar(new Tabuleiro(iDProduto, nomeProduto, categoriaProduto, estoqueProduto, precoProduto, descricaoProduto, statusProduto));
						break;
						
					case 3:
						produtos.atualizar(new Miniatura(iDProduto, nomeProduto, categoriaProduto, estoqueProduto, precoProduto, descricaoProduto, statusProduto));
						break;
						
					case 4:
						produtos.atualizar(new Livro(iDProduto, nomeProduto, categoriaProduto, estoqueProduto, precoProduto, descricaoProduto, statusProduto));
						break;
					}	
					
				} else {
					System.out.println(Cores.TEXT_RED_BOLD_BRIGHT+"Produto não encontrado!");
				}
				
				break;
				
			case 6:
				System.out.println(Cores.ANSI_WHITE_BACKGROUND +
		                           "                                                         ");
				System.out.println(Cores.TEXT_BLACK_BOLD+
		                           "  Excluir Produto                                        ");
				System.out.println("                                                         "+Cores.TEXT_RESET);
				System.out.println("Digite o ID do produto a ser deltado:");
				iDProduto = ler.nextInt(); 
				produtos.excluir(iDProduto);
				
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
