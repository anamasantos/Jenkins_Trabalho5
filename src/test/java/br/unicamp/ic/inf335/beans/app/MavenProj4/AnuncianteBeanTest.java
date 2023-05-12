package br.unicamp.ic.inf335.beans.app.MavenProj4;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(OrderAnnotation.class)
class AnuncianteBeanTest {

	
	public static String nome_anu = "primeiro Anuncio";
	public static String cpf = "01234567890";
	public static AnuncianteBean Anunciante = new AnuncianteBean();
	public static ArrayList<URL> fotosUrl = new ArrayList<URL>();
	public static ArrayList<URL> fotosUrl2 = new ArrayList<URL>();
	public static ArrayList<AnuncioBean> vet_anun = new ArrayList<AnuncioBean>();

	//para iniciar os teste vamos criar 2 produtos:
	public static ProdutoBean prod_anu1 = new ProdutoBean("CD00001","Prod 1 ...", "Bla Bla Bla",1100.0,"Bla Bla Bla");
	public static ProdutoBean prod_anu2 = new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",120.0,"Bla Bla Bla");
		//criamos o anuncio referente ao produtos
	public static Double desconto_prod_1 = 0.1;
	public static Double desconto_prod_2 = 0.15;
	
	
	
	@BeforeAll
	static void SetupTesteAnunciante () throws Exception {
	//definimos os vetores de url:
	URL url1 = new URL("https://www.google.com.br");
	fotosUrl.add(url1);
	URL url2 = new URL("https://www.youtube.com.br");
	fotosUrl.add(url2);
	
	url1 = new URL("https://www.facebook.com.br");
	fotosUrl2.add(url1);
	url2 = new URL("https://www.steam.com.br");
	fotosUrl2.add(url2);
	
	AnuncioBean anun_1 = new AnuncioBean();
	anun_1.setDesconto(desconto_prod_1);
	anun_1.setProduto(prod_anu1);
	anun_1.setFotosUrl(fotosUrl);
	
	AnuncioBean anun_2 = new AnuncioBean();
	anun_2.setDesconto(desconto_prod_2);
	anun_2.setProduto(prod_anu2);
	anun_2.setFotosUrl(fotosUrl2);
		
	//Sertando o Anunciante
	Anunciante.setCPF(cpf);
	Anunciante.setNome(nome_anu);

	//para testar a inserção de aunciante vamos inserir dois anuncios para este anunciante
	vet_anun.add(anun_1);
	vet_anun.add(anun_2);	
	Anunciante.setAnuncios(vet_anun);

	}
	
	@Test
	@DisplayName("Teste de deleção de anuncio")
	@Order(2)
	void test_remove_anunciante() {
		Anunciante.removeAnuncio(2);
		assertAll("produto",
	            () -> { //teste outros elementps do anuncio como desconto e vetor de urls
	                int tam_vet_anu =2;
	                assertEquals(tam_vet_anu,(int)Anunciante.getAnuncios().size());
	            },
	            ()->{
	            	assertEquals(Anunciante.getAnuncios().get(0).getProduto().getCodigo(),"CD00001");
	            	assertEquals(Anunciante.getAnuncios().get(1).getProduto().getCodigo(),"CD00002");
	            	}
	        );
 
	}
			
	@Test
	@DisplayName("Teste de inserção de anuncio")
	@Order(1)
	void test_add_anunciante() throws MalformedURLException {
		AnuncioBean anun_1 = new AnuncioBean();
		anun_1.setDesconto(desconto_prod_1);
		anun_1.setProduto(prod_anu1);
		anun_1.setFotosUrl(fotosUrl);
		Anunciante.addAnuncio(anun_1);
		
		assertAll("produto",
	            () -> { //teste outros elementps do anuncio como desconto e vetor de urls
	                int tam_vet_anu = 3;
	                assertEquals(tam_vet_anu,(int)Anunciante.getAnuncios().size());
	            },
	            ()->{
	            	assertEquals(Anunciante.getAnuncios().get(0).getProduto().getCodigo(),"CD00001");
	            	assertEquals(Anunciante.getAnuncios().get(1).getProduto().getCodigo(),"CD00002");
	            	assertEquals(Anunciante.getAnuncios().get(2).getProduto().getCodigo(),"CD00001");
	            	}
	        );

		System.out.println(Anunciante + "tes3");
		
	}
	
	@Test
	@DisplayName("Teste de media de anuncio")
	@Order(3)
	void test_media_anunciante() throws MalformedURLException {
        Double media = 546.0 ;
        assertEquals(media,(Double)Anunciante.valorMedioAnuncios());
		
	}
		
	@Test 
	@DisplayName("Teste de Média") 
	@Order(4) 
	void test_media_anunciante_empty(){ 
		Anunciante.removeAnuncio(1); 
		Anunciante.removeAnuncio(0); 
		assertEquals(0.0,Anunciante.valorMedioAnuncios()); 

	} 


}