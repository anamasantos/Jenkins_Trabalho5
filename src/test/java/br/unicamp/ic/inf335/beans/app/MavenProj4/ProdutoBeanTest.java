package br.unicamp.ic.inf335.beans.app.MavenProj4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ProdutoBeanTest {
	
	private static ArrayList<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
	private static ArrayList<Double> produtos_ord = new ArrayList<Double>();
	//private static ProdutoBean nProd;
	
	@Test
	@DisplayName("Teste de ordenação dos Produtos")
	//Este teste deve verificar o funcionamento da função de oedenação presente na classe ProdutoBean
	void Test_ordenar(){
		ProdutoBean nProg = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
		produtos.add(nProg);
		nProg = new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",1100.0,"Bla Bla Bla");
		produtos.add(nProg);
		nProg = new ProdutoBean("CD00003","Prod 3 ...", "Bla Bla Bla",120.0,"Bla Bla Bla");
		produtos.add(nProg);
		nProg = new ProdutoBean("CD00004","Prod 4 ...", "Bla Bla Bla",1300.0,"Bla Bla Bla");
		produtos.add(nProg);
		nProg = new ProdutoBean("CD00005","Prod 5 ...", "Bla Bla Bla",9400.0,"Bla Bla Bla");
		produtos.add(nProg);
		nProg = new ProdutoBean("CD00006","Prod 6 ...", "Bla Bla Bla",1500.0,"Bla Bla Bla");
		produtos.add(nProg);
		
		int Quant_prod = 6;
        assertEquals(Quant_prod,(int)produtos.size());
		
		produtos_ord.add(120.0);
		produtos_ord.add(1100.0);
		produtos_ord.add(1250.0);
		produtos_ord.add(1300.0);
		produtos_ord.add(1500.0);
		produtos_ord.add(9400.0);
		
		System.out.println(produtos_ord);
		
		//int valor_produto = 1;
        //assertEquals(valor_produto,nProg.compareTo(nProg));
		
		// Ordena produtos
		Collections.sort(produtos);
				
		assertAll("Ordenado",
                () -> assertEquals(produtos_ord.get(0),produtos.get(0).getValor()),
                () -> assertEquals(produtos_ord.get(1),produtos.get(1).getValor()),
                () -> assertEquals(produtos_ord.get(2),produtos.get(2).getValor()),
                () -> assertEquals(produtos_ord.get(3),produtos.get(3).getValor()),
                () -> assertEquals(produtos_ord.get(4),produtos.get(4).getValor()),
                () -> assertEquals(produtos_ord.get(5),produtos.get(5).getValor())
            );
		
		 
		
	}

}
