package program.calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Klasa Main zawiera menu programu oraz obsluge
 * wczytywania klawiszy i plikow
 * @author Michal Studzinski
 *
 */
public class Main {
		/**
		 * Glowna funkcja aplikacji
		 * @param args tablica lancuchow argumentow
		 * @throws FileNotFoundException  jest wyj¹tkiem 
		 * z grupy wyj¹tków kontrolowanych (dziedzicz¹cych po klasie Exception)
		 */
	public static void main(String[] args) throws FileNotFoundException {


        @SuppressWarnings("resource")   
        Scanner input = new Scanner(System.in);   
        
        /**
         * pierwsza wartosc dla pobieranego ciagu znakow
         */
        String line = "";  
        /** 
         * druga wartosc dla pobieranego ciagu znakow
         */
        String line2 = "";

         /**
          * glowne menu
          */
        do
        {
        System.out.println("\tMenu\t");
        System.out.println("Co chcesz zrobic?");
        System.out.println("1. Obliczenia pobierane z klawiatury.");
        System.out.println("2. Obliczenie pobierane z pliku.");
        System.out.println("3. Wpisz 'koniec' aby zakonczyc dzialanie programu");
        
        line = input.nextLine();
        switch (line) {
		case "1":
				do
				{
					System.out.print("Wpisz dzialanie: "); 
					/**
					 * pobieranie ciagu znakow z klawiatury
					 */
					line2 = input.nextLine();
					if (!line2.equals("koniec")){
					Calculator calc = new Calculator(line2);  
					System.out.println("Wynik: " + calc.Evaluate());
					}
				}while(!line2.equals("koniec"));
			break;
		case "2":
			System.out.print("Podaj nazwe pliku do odczytu: ");
			line2 = input.nextLine();
			/**
			 * pobieranie nazwy pliku do odczytu
			 */
			Scanner in = new Scanner(new File("C:\\" + line2));
			while(in.hasNextLine())
			{
			line2 = in.nextLine();
			Calculator calc = new Calculator(line2);  
			System.out.println("Wynik: " + calc.Evaluate());
			}
			break;
		case "koniec":
			System.out.print("Koniec programu! ");  
			break;
		default:
			break;
			}
        }while(!line.equals("koniec"));  
	}
}
