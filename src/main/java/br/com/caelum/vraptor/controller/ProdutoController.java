package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

//import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Log;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
//import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {

	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
    //private final Mailer mailer;

	@Inject
	//public ProdutoController(Result result, ProdutoDao dao, Validator validator, Mailer mailer) {
	public ProdutoController(Result result, ProdutoDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
        //this.mailer = mailer;
	}

	@Deprecated
	ProdutoController() {
		//this(null, null, null, null);
		this(null, null, null);
	}

	public void inicio() {

	}

	@Log 
	@Get
	public void formulario() {

	}

	@Post
	public void adiciona(@Valid Produto produto) {
		//validator.check(produto.getQuantidade() > 0, new I18nMessage("erro", "produto.quantidade.negativa"));
	    validator.onErrorUsePageOf(this).formulario();

	    System.out.println(produto);
		dao.adiciona(produto);
	    result.include("mensagem", "Produto adicionado com sucesso!");
		result.redirectTo(this).lista();
	}

	@Log
	@Get
	public List<Produto> lista() {
		return dao.lista();
	}

	public void remove(Produto produto) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		ProdutoDao dao = new ProdutoDao(em);
		dao.remove(produto);
		em.getTransaction().commit();
	}

	public void sobre() {

	}

	@Get
	public void listaEmXml() {
		result.use(Results.xml()).from(dao.lista()).serialize();
	}

	@Get
	public void listaEmJson() {
		result.use(Results.json()).from(dao.lista()).serialize();
	}
	
//	@Get
//	public void enviaPedidoDeNovosItens(Produto produto) throws EmailException {
//	    Email email = new SimpleEmail();
//	    email.setSubject("[vraptor-produtos] Precisamos de mais estoque");
//	    email.addTo("rodrigo.turini@caelum.com.br");
//	    email.setMsg("Precisamos de mais itens do produto" + produto.getNome());
//	    mailer.send(email);
//	    result.redirectTo(this).lista();
//	}

}
