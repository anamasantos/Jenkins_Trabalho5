package br.unicamp.ic.inf335.beans.app.MavenProj4;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class AnuncioBeanTest {
	//cria a classe de test de pŕodutos
	public static ProdutoBeanTest test_prod= new ProdutoBeanTest();
	
	//cria o produto do anuncio
	public static String codigo = "CD00001";
	public static String nome = "notebook";
	public static String descricao = "4 GbRam, Preto, GPU";
	public static Double valor =1000.0;
	public static String estado = "Poucos riscos, seminovo.";
	public static ProdutoBean nProg = new ProdutoBean(codigo,nome,descricao,valor,estado);
	
	//cria o vetor de url
	public static ArrayList<URL> fotosUrl = new ArrayList<URL>();
	
	
	//cria o desconto a ser utilizado no produto
	public static Double desconto = 0.1;
	public static AnuncioBean Anuncio = new AnuncioBean();
	
	
	@BeforeAll
	static void SetupTesteAnunciante () throws Exception {
		URL url1 = new URL("https://www.google.com.br");
		fotosUrl.add(url1);
		URL url2 = new URL("https://www.youtube.com.br");
		fotosUrl.add(url2);
		Anuncio.setDesconto(desconto);
		Anuncio.setProduto(nProg);
		Anuncio.setFotosUrl(fotosUrl);		
	}


	@Test
	@DisplayName("Teste de calculo de valor")
	void test_getValor() {
		 Double valor_produto = 900.0;
         assertEquals(valor_produto,(Double)Anuncio.getValor());
	}
}
