package rpgEStore.repository;

import rpgEStore.model.Produto;

public interface ProdutoRepository {
	//CRUD do Produto
	public void procurarPorID(int iDProduto);
	public void listarTodos();
	public void listarPorCategoria(int categoriaProduto);
	public void cadastrarProduto(Produto produto);
	public void atualizar(Produto produto);
	public void excluir(int iDProduto);
	
}
