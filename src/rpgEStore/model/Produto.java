package rpgEStore.model;

import rpgEStore.util.Cores;

public abstract class Produto {

	private int iDProduto;
	private String nomeProduto;
	private int categoriaProduto;
	private int estoqueProduto;
	private float precoProduto;
	private String descricaoProduto;
	private boolean statusProduto;
	
	public Produto(int iDProduto, String nomeProduto, int categoriaProduto, int estoqueProduto, float precoProduto,
			String descricaoProduto, boolean statusProduto) {
		this.iDProduto = iDProduto;
		this.nomeProduto = nomeProduto;
		this.categoriaProduto = categoriaProduto;
		this.estoqueProduto = estoqueProduto;
		this.precoProduto = precoProduto;
		this.descricaoProduto = descricaoProduto;
		this.statusProduto = statusProduto;
	}

	public int getiDProduto() {
		return iDProduto;
	}

	public void setiDProduto(int iDProduto) {
		this.iDProduto = iDProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(int categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public int getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(int estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}

	public float getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(float precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public boolean isStatusProduto() {
		return statusProduto;
	}

	public void setStatusProduto(boolean statusProduto) {
		this.statusProduto = statusProduto;
	}
	
	public void visualizar() {
		String categoriaProduto = "";
		String status = "";
		
		if(this.statusProduto == true) {
			status = "Disponível";
		} else if (this.statusProduto == false) {
			status = "Indisponível";
		}

		switch (this.categoriaProduto) {
		case 1:
			categoriaProduto = "Dados";
			break;
		case 2:
			categoriaProduto = "Tabuleiros";
			break;
		case 3:
			categoriaProduto = "Miniaturas";
			break;
		case 4:
			categoriaProduto = "Livros";
			break;
		}

		System.out.println(Cores.TEXT_RESET + Cores.TEXT_BLACK_BOLD + "_________________________________________________");
		System.out.println(Cores.ANSI_WHITE_BACKGROUND +
				           "                                                 ");
		System.out.println(" Dados do Produto                                ");
		System.out.println("_________________________________________________"+Cores.TEXT_RESET);
		System.out.println("                                                         ");
		System.out.println(" ID do Produto: "+this.iDProduto);
		System.out.println(" Nome do Produto: "+this.nomeProduto);
		System.out.println(" Descrição: "+this.descricaoProduto);
		System.out.println(" Categoria: "+categoriaProduto);
		System.out.println(" Quantidade no estoque: "+this.estoqueProduto);
		System.out.println(" Preço: "+this.precoProduto);
		System.out.println(" Disponibilidade: "+status);
	}
	
}
