package rpgEStore.controller;

import java.util.ArrayList;

import rpgEStore.model.Produto;
import rpgEStore.repository.ProdutoRepository;
import rpgEStore.util.Cores;

public class ProdutoController implements ProdutoRepository{
	
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	@Override
	public void procurarPorID(int iDProduto) {
		Produto produtoEncontrado = null;
		for (var produto: listaProdutos) {
			if(produto.getiDProduto() == iDProduto) {
				produtoEncontrado = produto;
			} 
		}
		
		if(produtoEncontrado != null) {
			produtoEncontrado.visualizar();
		} else {
			System.out.println(Cores.TEXT_RED_BRIGHT+"\nProduto não encontrado!");
		}
		
	}

	@Override
	public void listarTodos() {
		for (var produto: listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void listarPorCategoria(int categoriaProduto) {
		for (var produto: listaProdutos) {
			if(produto.getCategoriaProduto() == categoriaProduto) {
				produto.visualizar();
			}
		}
		
	}

	@Override
	public void cadastrarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT+"\nProduto cadastrado com sucesso!");
		
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getiDProduto());
		
		if(buscaProduto != null) {
			listaProdutos.remove(buscaProduto);
			listaProdutos.add(produto);
			System.out.println(Cores.TEXT_GREEN_BRIGHT+"Produto atualizado com sucesso!");
		} else {
			System.out.println(Cores.TEXT_RED_BRIGHT+"\nProduto não encontrado!");
		}
		
	}

	@Override
	public void excluir(int iDProduto) {
		var produto = buscarNaCollection(iDProduto);
		
		if (produto != null) {
			if (listaProdutos.remove(produto) == true) {
				System.out.println(Cores.TEXT_GREEN_BRIGHT+"Produto deletado com sucesso!");
			} 
		} else {
			System.out.println(Cores.TEXT_RED_BRIGHT+"\nProduto não encontrado!");
		}
		
	}
	
	public Produto buscarNaCollection(int idProduto) {
		for(var produto: listaProdutos) {
			if (produto.getiDProduto() == idProduto) {
				return produto;
			}
		}
		return null;
	}

}
