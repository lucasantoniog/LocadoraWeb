package modelos;

public class Veiculo {
	private int id;
	private String marca;
	private String placa;
	private String modelo;
	private int ano;
	private double precoDiaria;

	public Veiculo(int id, String marca, String placa, String modelo, int ano, double precoDiaria) {
		super();
		this.id = id;
		this.marca = marca;
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.precoDiaria = precoDiaria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}
}
