package br.com.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;
	
	@NotBlank(message = "O nome do produto não pode ser branco nem nulo!")
	@Size(min = 4, max = 30, message = "O nome do produto deve ter entre 4 e 30 caracteres.")
	private String nome;
	
	@NotBlank(message = "A descrição do produto não pode ser branca nem nula!")
	@Size(min = 4, max = 30, message = "A descrição do produto deve ter entre 4 e 30 caracteres.")
	private String descricao;
	
	@NotBlank(message = "O laboratório do produto não pode ser branco nem nulo!")
	@Size(min = 3, max = 30, message = "O laboratório do produto deve ter entre 3 e 30 caracteres.")
	private String laboratorio;
	
	@Positive(message = "O preço do produto dever ser maior que zero!")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private double preco;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	@JoinColumn(name = "fk_id_categoria")
	private CategoriaModel categoria;

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
}
