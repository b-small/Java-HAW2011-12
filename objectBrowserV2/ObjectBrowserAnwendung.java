package objectBrowserV2;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ObjectBrowserAnwendung {
	


	    public static void main(String[] args) {
	        
	        Scanner sc = new Scanner(System.in);
	        String eingabe;
	        ObjectBrowser objectBrowserObj;
	        try {
	            System.out.println("Bitte Klasse oder Objekt eingeben: ");
	            eingabe = sc.next();

	            objectBrowserObj = new ObjectBrowser(eingabe);
	            objectBrowserObj.objectInfo();
	        } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (InvocationTargetException e) {
	            e.printStackTrace();
	        } finally {
	            sc.close();
	        }

	    }
	}


