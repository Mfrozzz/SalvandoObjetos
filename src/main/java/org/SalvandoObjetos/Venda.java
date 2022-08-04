package org.SalvandoObjetos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private float valorTotal;
	@OneToOne
	private Cliente cliente;
	@OneToMany(mappedBy = "venda", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Venda() {}

	public Venda(String codigo, Cliente cliente) {
		this.codigo = codigo;
		this.cliente = cliente;
		setValorTotal();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal() {
		for(Produto p: produtos) {
			valorTotal+=p.getValor();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
