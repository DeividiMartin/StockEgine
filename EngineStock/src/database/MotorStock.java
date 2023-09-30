package database;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class MotorStock {
	
	
	private int id;
    private String modelo;
    private String numeroMotor;
    private String marca;
    private int potencia;

    
    public MotorStock(int id, String modelo, String numeroMotor, String marca, int potencia) {
		
		this.id = id;
		this.modelo = modelo;
		this.numeroMotor = numeroMotor;
		this.marca = marca;
		this.potencia = potencia;
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getNumeroMotor() {
		return numeroMotor;
	}


	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getPotencia() {
		return potencia;
	}


	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
    
	@Override
    public String toString() {
        return "Motor [id=" + id + ", modelo=" + modelo + ", numeroMotor=" + numeroMotor + ", marca=" + marca
                + ", potencia=" + potencia + "]";
    }

	
	

}
