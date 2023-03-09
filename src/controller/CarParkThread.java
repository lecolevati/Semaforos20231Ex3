package controller;

import java.util.concurrent.Semaphore;

public class CarParkThread extends Thread {

	private int idCarro;
	private Semaphore semaforo;

	public CarParkThread(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroParado();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			carroSaindo();
		}

	}

	private void carroAndando() {
		int distanciaFinal = (int) ((Math.random() * 1001) + 1000); // 1000 a 2000 m.
		int deslocamento = 100;
		int tempo = 100; // 1000 ms = 1 s.
		int distanciaInicial = 0;
		while (distanciaInicial < distanciaFinal) {
			distanciaInicial += deslocamento;
			System.out.println("O carro #" + idCarro + " percorreu " + distanciaInicial + " m.");
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("O carro #" + idCarro + " chegou");
	}

	private void carroParado() {
		System.out.println("O carro #"+idCarro+" estacionou");
		int tempoParado = (int)((Math.random() * 2001) + 1000); //1000 a 3000
		try {
			sleep(tempoParado);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroSaindo() {
		System.out.println("O carro #"+idCarro+" saiu");
	}

}
