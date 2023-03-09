package view;

import java.util.concurrent.Semaphore;

import controller.CarParkThread;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(3);
		for (int idCarro = 1 ; idCarro <= 10 ; idCarro++) {
			Thread t = new CarParkThread(idCarro, semaforo);
			t.start();
		}
	}

}
