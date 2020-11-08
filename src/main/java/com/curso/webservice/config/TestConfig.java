package com.curso.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.webservice.entidades.Categoria;
import com.curso.webservice.entidades.ItemPedido;
import com.curso.webservice.entidades.Pagamento;
import com.curso.webservice.entidades.Pedido;
import com.curso.webservice.entidades.Produto;
import com.curso.webservice.entidades.Users;
import com.curso.webservice.entidades.enums.PedidoEstados;
import com.curso.webservice.retositories.CategoriaRepository;
import com.curso.webservice.retositories.ItemPedidoRepository;
//import com.curso.webservice.retositories.PagamentoRepository;
import com.curso.webservice.retositories.PedidoRepository;
import com.curso.webservice.retositories.ProdutoRepository;
import com.curso.webservice.retositories.UserRepository;

// CommadLineRunner é para instanciar o objeto assim que o spring boot startar!
// Ajustando a classe de acordo com o perfil criado para testes
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	// INJETANDO DEPENDENCIA COM O ATUTOWIRED DO SPRING BOOT
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	//@Autowired
	//private PagamentoRepository pagamentoRepository;

	@Override
	public void run(String... args) throws Exception {
		// Tudo que colocar aqui vai ser instanciado assim que a aplicação iniciar
		
		Categoria cat1 = new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Livos");
		Categoria cat3 = new Categoria(null, "Computadores"); 
		
		Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		// Está dando erro para criar a tabela "produto_categoria"
		produto1.getCategorias().add(cat1);
		produto2.getCategorias().add(cat2);
		produto2.getCategorias().add(cat3);
		produto3.getCategorias().add(cat3);
		produto4.getCategorias().add(cat3);
		produto5.getCategorias().add(cat2);
		
		// Para salvar os registros da tabela "produto_categoria" tenho que salvar novamente todos os produtos!!!
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Users u1 = new Users(null, "Alessandro França", "ALE@gmail.com", "988888888", "123456");
		Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoEstados.AGUARDANO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoEstados.ENVIAOO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoEstados.PARA_ENTREGA, u1);
				
		// chamando o metodo de salvar registro no banco de dados metodo já vem pronto pra usar!
		userRepository.saveAll(Arrays.asList(u1, u2));	
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		// Instaciando o ItemPedido
		ItemPedido oi1 = new ItemPedido(p1, produto1, 2, produto1.getPreco());
		ItemPedido oi2 = new ItemPedido(p1, produto3, 1, produto3.getPreco());
		ItemPedido oi3 = new ItemPedido(p2, produto3, 2, produto3.getPreco());
		ItemPedido oi4 = new ItemPedido(p3, produto5, 2, produto5.getPreco()); 

		itemPedidoRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		// Instaciando um Pagamento como só tem um pedido pago : 
		Pagamento pg1 = new Pagamento(null, Instant.parse("2019-06-21T19:53:07Z"), p1);
		p1.setPagamento(pg1);
		
		pedidoRepository.save(p1);
		
		
		//Pagamento pg2 = new Pagamento(null, Instant.parse("2019-07-09T20:53:07Z"), p2);
		//Pagamento pg3 = new Pagamento(null, Instant.parse("2019-07-23T19:00:07Z"), p3);
		
		//pagamentoRepository.saveAll(Arrays.asList(pg1, pg2, pg3));
		
		
		
	}
	
	

}
