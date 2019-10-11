package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Node;
import model.logic.MVCModelo;
import model.logic.ZonaUBER;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	/**
	 * Hilo de ejecución del programa
	 */
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin )
		{
			view.printMenu();

			String in;
			in = lector.next();

			int option;
			try
			{
				option = Integer.parseInt(in);
			}
			catch(NumberFormatException e)
			{
				option = 0;
			}

			switch(option){
			case 1:

				modelo.cargarArchivoZonas();
				System.out.println("Archivos cargados");
				System.out.println("Numero actual de zonas: " + modelo.darTamanoZonas()  + "\n---------");

				break;

			case 2:

				String MID;
				try
				{
					System.out.println("--------- \nDar MOVEMENT ID a buscar: ");
					MID = lector.next();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Debe ingresar valores numéricos\n---------");
					break;
				}

				ZonaUBER zona = modelo.consultarZonaPorID(MID);
				if (zona == null)
				{
					System.out.println("No hay una zona con el MOVEMENT ID ingresado.\n---------");
				}
				else
				{
					System.out.println("--------- \nDatos de la zona: \n");

					System.out.println("Nombre: " + zona.darScanombre() + "\nPerímetro: " + zona.darShape_leng() + "\nÁrea: " + zona.darShape_area() + "\nNúmero de puntos: " + zona.darCoordinates().darNumeroElementos() + "\n---------");
				}
				break;

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}
	}	
}