package org.SalvandoObjetos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ){
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Endereco end1 = new Endereco("Padre Caetano Vendrami",413,"Vila Carli", "Guarapuava");
		Endereco end2 = new Endereco("Padre Honorino João Muraro",777,"Vila Carli","Guarapuava");
		
		Telefone tel1 = new Telefone("42","998608834","celular");
		Telefone tel2 = new Telefone("42","36296085","fixo");
		
		Cliente cl1 = new Cliente("Marcos Vinicius Boava","07/03/2002","Masculino","08241200943",end1);
		//Cliente cl2 = new Cliente("Henri Clemente","03/07/1980","Masculino","02145633258",end2);
		
		List<Telefone> telefones =  new ArrayList<Telefone>();
		tel1.setCliente(cl1);
		tel2.setCliente(cl1);
		telefones.add(tel1);
		telefones.add(tel2);
		
		cl1.setTelefones(telefones);
		
		Produto p1 = new Produto("xxbr1230000","pacote curso python",65);
		Produto p2 = new Produto("xxbr1234000","refrigerante de guaraná",5);
		Venda v1 = new Venda("brxxav003",cl1);
		
		List<Produto> produtos = new ArrayList<Produto>();
		p1.setVenda(v1);
		p2.setVenda(v1);
		produtos.add(p1);
		produtos.add(p2);
		v1.setProdutos(produtos);
		v1.setValorTotal();
		
		session.save(cl1);
		//session.save(cl2);
		session.save(end1);
		session.save(end2);
		session.save(tel1);
		session.save(tel2);
		session.save(v1);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		sessionFactory.close();
    }
}
