package com.curso.webservice.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.curso.webservice.entidades.enums.PedidoEstados;
import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;

// ERRO: @Table(name = "tb_order") *Só que como não estou usando a nomeclatura do curso então não tive deu erro!
@Entity
public class Pedido implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private Integer estado;				

		// Anotação para formata o json no ISO(alguma coisa ai)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'", timezone = "GMT" )
		private Instant momento;
		
		// Mapeamento para os dois registro terem o mesmo ID
		@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)		
		private Pagamento pagamento;
		
		// Esse atributo faz relação de 1 para 1 (Banco de dados)
		@ManyToOne
		@JoinColumn(name = "cliente_id")
		private Users cliente;
		
		// Esse atributo vai pertencer a associação entre pedido e itemPedido: Mapeamente passa feito pelos atributos da classes
		@OneToMany(mappedBy = "id.pedidoId")
		private Set<ItemPedido> itens = new HashSet<>();
		
		public Pedido() {
			
		}

		public Pedido(Long id, Instant momento, PedidoEstados estado, Users cliente) {
			super();
			this.id = id;
			this.momento = momento;
			setEstado(estado); // Usando o set dentro do construtor!
			this.cliente = cliente;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Instant getMomento() {
			return momento;
		}

		public void setMomento(Instant momento) {
			this.momento = momento;
		}

		public Users getCliente() {
			return cliente;
		}

		public void setCliente(Users cliente) {
			this.cliente = cliente;
		}
		
		// Metodo get alterado para retorna o nome o estado e não o codigo
		public PedidoEstados getEstado() {
			return PedidoEstados.estadoDoCodigo(estado);
		}
		
		public Set<ItemPedido> getItens(){
			return itens;
		}
		
		// Metodo set alterado para setar um inteiro
		public void setEstado(PedidoEstados estado) {
			if (estado != null) {
				this.estado = estado.getCodigo();
			}
		}
		
		// Esse metodo que vai chamar o pagamento no JPA: Se eu excluisse esse metodo tbm resolveria o bug		
		public Pagamento getPagamento() {
			return pagamento;
		}
		
		// Esse set vai ser usado para salvar o pagamento!!
		public void setPagamento(Pagamento pg) {
			this.pagamento = pg;
		}
		
		// Metodo vai retornar o total do valor do pedido
		public Double getTotal() {
			Double resultado = 0.0;
			for(ItemPedido item : this.itens ) {
				resultado += item.getPreco();
			}
			return resultado;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			Pedido other = (Pedido) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
				
}
