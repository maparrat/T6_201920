package view;

public class MVCView 
{
	/**
	 * Metodo constructor
	 */
	public MVCView()
	{}

	/**
	 * M�todo que imprime el men� por consola
	 */
	public void printMenu()
	{
		System.out.println("1. Cargar archivo");
		System.out.println("2. Consultar una zona por id");
		System.out.println("3. Consultar las zonas con un id en un rango espec�fico");
		System.out.println("4. Datos tabla");
		System.out.println("5. Exit");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
	}
}