package com.curso.webservice.entidades.enums;

// Falta implementar ainda!
public enum PedidoEstados {
	
	AGUARDANO_PAGAMENTO(1),
	PAGO(2),
	ENVIAOO(3),
	PARA_ENTREGA(4),
	CANCELADO(5);
	
	private int codigo;
	
	// Esse construtor tem que ser privado
	private PedidoEstados(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	// ERRO: PQ o throw estava dentro do for!!!
	public static PedidoEstados estadoDoCodigo(int codigo) {
		for(PedidoEstados valor : PedidoEstados.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}			
		}			
		throw new IllegalArgumentException("Esse codigo nao e valido");
	}

}
