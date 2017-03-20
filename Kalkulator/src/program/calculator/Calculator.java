package program.calculator;

import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

/**
 * Klasa Calculator oblicza dane na podstawie
 * pobranego wiersza i zwraca wynik
 * 
 * @author Michal Studzinski
 *
 */
public class Calculator 
{  

	/**
	 * zmienna przechowujaca ciag znakow (tokenow)
	 */
    private StringTokenizer tokenizer;  
    /**
	 * zmienne przechowujaca aktualny token
     */
    private String token;  
    /**
     * zmienna powiadamiajaca o bledach
     */
    private int error;
    
    /**
     * Konstruktor domyslny, pobiera linie z dzialaniem
     * @param line aktualnie pobrana linia 
     */
    public Calculator(String line)  
    {  
        this.tokenizer = new StringTokenizer(line);  
        this.token = tokenizer.nextToken();
        error = 0;
    }  
    
    /**
     * metoda zwracajaca wynik wszystkich operacji matematycznych
     * @return wynik operacji matematycznych
     */
    public double Evaluate()  
    {  
        return Expression();  
    }  
    
    /**
     * metoda zwraca aktualnie przetwarzany token
     * @return zwraca aktualny token
     */
    private double Primary()  
    {  
    	//zmienna z wynikiem ktory zwraca metoda
        double result;  
        if(StringUtils.isAlpha(token)){
        	System.out.println("Blad! Podano litery!");
            this.tokenizer = new StringTokenizer("0");  
            this.token = "0";
            error = 1;
        }
        if(token.equals("")) 
        {  
            token = tokenizer.nextToken();  
            result = Expression();  
        }  
        else  
        {  
            result = Double.valueOf(token).doubleValue();
        }  
       
        //sprawdza czy sa jeszcze jakies tokeny
        if (tokenizer.hasMoreElements())
        {
        	token = tokenizer.nextToken();  
        }
        return result;  
    }  
    
    /**
     * metoda z dzialaniami ktore maja pierszenstwo (mnozenie
     * i dzielenie)
     * @return wynik operacji matematycznej
     */
    private double Priority()  
    {  
        double nextValue;  
        double result;  
       
        result = Primary();  
       
        while(token.equals("*"))  
        {  
            token = tokenizer.nextToken();  
            nextValue = Primary();  
            result *= nextValue;  
        }  
         
        while(token.equals("/"))  
        {  
            token = tokenizer.nextToken();  
            nextValue = Primary();  
            result /= nextValue;  
        }    
        return result; 
    }  
    
    /**
     * metoda z dzialaniami ktore nie maja pierszenstwa
     * (dodawanie i odejmowanie)
     * @return wynik operacji matematycznej lub 0 z komunikatem
     * o bledzie jesli zostaly podane litery zamiast liczb
     */
    private double Expression()  
    {  
        double nextValue;  
        double result;  
      
        result = Priority();  
      
        while(token.equals("+"))  
        {            
            token = tokenizer.nextToken();  
            nextValue = Priority();  
            result += nextValue;  
        }  
         
        while(token.equals("-"))  
        {  
            token = tokenizer.nextToken();  
            nextValue = Priority();  
            result -= nextValue;  
        }  
       if (error == 1)
       	return 0;
  
       else return result;
     }  
}