package it.polito.tdp.numero.model;

import java.security.InvalidParameterException;

public class NumeroModel {
	
	private final int NMAX = 100;
	private final int TMAX = 8;

	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;

	public NumeroModel() {
		inGioco = false;
	}
	
	/**
	 * 		Avvia una nuova partita:
	 */
	
	
	public void newGame() {
		inGioco = true;
		this.segreto = (int) (Math.random() * NMAX) + 1;
		this.tentativiFatti = 0;
	}
	
	public int tentativo(int t) {
		//controllo se la partita è in corso
		
		if(!inGioco) {
			//lancio un'eccezione
			throw new IllegalStateException("La partita è terminata");
		}
		
		//controllo se l'input è nel range corretto
		if(!tentativoValido(t)) {
			throw new InvalidParameterException(String.format("Devi inserire un numero "+"tra %d e %d", 1, NMAX));
		}
		
		//gestisci tentativo
		this.tentativiFatti++;
		if(this.tentativiFatti==this.TMAX) {
			this.inGioco = false;
		}
		
		
		if(t == this.segreto) {
			//ho indovinato
			this.inGioco = false;
			return 0;
		}
		if(t>this.segreto) {
			return 1;
		}
				
		return -1;
		
	}
	
	public boolean isInGioco() {
		return inGioco;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public void setTentativiFatti(int tentativiFatti) {
		this.tentativiFatti = tentativiFatti;
	}

	public int getSegreto() {
		return segreto;
	}

	public boolean tentativoValido(int t) {
		if(t<1||t<TMAX) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
}
