package com.curso.webservice.entidades.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.curso.webservice.entidades.Pedido;
import com.curso.webservice.entidades.Produto;

// 
@Embeddable  
public class ItemPedidoPk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Esse vai representar a associação entre ItemPedido e Pedido
	@ManyToOne
	@JoinColumn(name ="id.pedido")
	private Pedido pedidoId;
	
	// Esse aqui vai representar a associação entre ItemPedido e Produto
	@ManyToOne
	@JoinColumn(name ="id_produto") // Será que isso aqui está certo mesmo ????
	private Produto produtoId;
	
	// Não tem construtor nessa classe!!
		
	public Pedido getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Pedido pedidoId) {
		this.pedidoId = pedidoId;
	}
	public Produto getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedidoId == null) ? 0 : pedidoId.hashCode());
		result = prime * result + ((produtoId == null) ? 0 : produtoId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPk other = (ItemPedidoPk) obj;
		if (pedidoId == null) {
			if (other.pedidoId != null)
				return false;
		} else if (!pedidoId.equals(other.pedidoId))
			return false;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		return true;
	}
	
	
	
	

}
