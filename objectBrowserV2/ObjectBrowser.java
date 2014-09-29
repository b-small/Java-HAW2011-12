package objectBrowserV2;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * @author Charlotte Christophers
 * @author Rene Rahn
 * 
 */
public class ObjectBrowser {

    private Object o;
    private Object[] parameters;


    /**
     * Konstruktor
     * 
     * @param o
     *            Beliebiges Objekt
     */
    public ObjectBrowser(Object o) {
        this.o = o;
    }


    /**
     * Holt Konstruktor von Klasse und erzeugt das Objekt
     * 
     * @param s
     *            Eingabe der Klasse
     * @throws ClassNotFoundException
     */
    public ObjectBrowser(String s) throws ClassNotFoundException {
        Constructor<?>[] constructors = Class.forName(s).getConstructors();
        if (constructors.length > 0) {
            createObject(constructors);
        } else {
            System.out.println("Es gibt keinen greifbaren Konstruktor");
            this.o = null;
        }
    }


    


	/**
     * Erzeugt eine neue Instanz der Klasse, also ein Objekt anhand des Konstruktors
     * 
     * @param constructors
     * @throws ClassNotFoundException
     */
    private void createObject(Constructor<?>[] constructors) throws ClassNotFoundException {
        System.out.println("Greifbare Konstruktoren");
        for (int i = 0; i < constructors.length; i++) {
            System.out.print(i + ": ");
            System.out.println(constructors[i]);
        }

        System.out.println("W�hlen Sie nun bitte einen Konstruktor aus. Bitte Nr. eingeben: ");
        int i = getChoice(constructors.length);

        Constructor<?> constructor = constructors[i];
        Class<?>[] constructorParameters = constructor.getParameterTypes();
        parameters = getParameters(constructorParameters);
        try {
            o = constructor.newInstance(parameters);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public Object getObject() {
        return this.o;
    }


    /**
     * Ausgaben der Informationen. Variablen und Methoden
     * 
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     */
    public void objectInfo() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        System.out.println("Variablen:");
        fieldsInfo();
        System.out.println();
        System.out.println("Methoden:");
        methodInfo();

    }

    /**
     * Ausgabe des Methoden Arrays
     * 
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */

    private void methodInfo() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Method[] methods = o.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.print(i + ": ");
            System.out.println(methods[i]);
        }

        chooseMethod(methods);
    }
    
    /**
     * Gibt die Informationen �ber Variablen aus
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
        private void fieldsInfo() throws IllegalArgumentException, IllegalAccessException {
            for (Field f : o.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                System.out.print(f + " : ");
                if (f.getType().isPrimitive()) {
                    System.out.println(f.get(o));
                } else if (f.getType().isArray()) {
                    Object array = f.get(o);
                    int length = Array.getLength(array);
                    System.out.println("L�nge des Arrays: " + length);
                } else if (f.getType().equals(String.class)) {
                    System.out.println(f.get(o));
                } else if (f.getType().isEnum()) {
                    System.out.print("{ ");
                    for (Object obj : f.get(o).getClass().getEnumConstants()) {
                        System.out.printf("%s ", obj.toString());
                    }
                    System.out.println("}");
                } else {
                    System.out.println();
                    System.out.println("Variablen von" + f.get(o).getClass());
                    new ObjectBrowser(f.get(o)).fieldsInfo();

                }
            }
        }
    
    
    /**
     * �bergibt die Parameter zur �berpr�fung ins Object Array. Gepr�ft wird auf Primitiv, Array, Enum und Referenztyp. Bei Refernztyp wird eine neue
     * Instanz erzeugt
     * 
     * @param parameterArray
     *            das Array der Paramter
     * @return Der Parameter
     * @throws ClassNotFoundException
     */
    private Object[] getParameters(Class<?>[] parameterArray) throws ClassNotFoundException {
        this.parameters = new Object[parameterArray.length];
        for (int i = 0; i < parameterArray.length; i++) {
            System.out.println("Bitte geben Sie nun Ihre Paramter ein:");
            if (parameterArray[i].isPrimitive() || parameterArray[i].getName().equals(String.class.getName())) {
                System.out.println("Der n�chste Parameter ist ein : " + parameterArray[i]);
                parameters[i] = getPrimitiveParameter(parameterArray[i]);
            } else if (parameterArray[i].isArray()) {
                System.out.println("Ein Array als Parameter kann leider nicht vern�nftig eingeben werden");
                parameters[i] = null;

            } else if (parameterArray[i].isEnum()) {
                System.out.println("Ein Enum kann nicht einfach so eingegeben werden");
                parameters[i] = null;
            } else {
                System.out.println("Der Parameter ist ein Refernztyp. Hiervon wird nun eine Instanz erzeugt.");
                parameters[i] = new ObjectBrowser(parameterArray[i].getName()).getObject();
            }
        }
        return parameters;
    }


    /**
     * W�hlt den richtigen Scanner f�r den jeweiligen Typen aus
     * 
     * @param toCheck
     *            , der jeweilige Typ
     * @return Der jeweilige Typ mit Wert
     */
    private Object getPrimitiveParameter(Class<?> toCheck) {
        Object input = null;
        Scanner sc = new Scanner(System.in);
        try {
            if (toCheck.equals(Integer.TYPE))
                input = sc.nextInt();
            if (toCheck.getName().equals(String.class.getName()))
                input = sc.next();
            if (toCheck.equals(Double.TYPE))
                input = sc.nextDouble();
            if (toCheck.equals(Boolean.TYPE))
                input = sc.nextBoolean();
            if (toCheck.equals(Character.TYPE))
                input = sc.next().trim().charAt(0);
            if (toCheck.equals(Float.TYPE))
                input = sc.nextFloat();
            if (toCheck.equals(Byte.TYPE))
                input = sc.nextByte();
            if (toCheck.equals(Long.TYPE))
                input = sc.nextLong();
            if (toCheck.equals(Short.TYPE))
                input = sc.nextShort();
        } catch (InputMismatchException e) {
            System.out.println("Da ging was schief!");
            input = getPrimitiveParameter(toCheck);
        }
        return input;
    }


    /**
     * Eine Methode wird zum Ausf�hren ausgew�hlt
     * 
     * @param methods
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void chooseMethod(Method[] methods) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        System.out.println("Bitte w�hlen Sie eine Methode");
        int i = getChoice(methods.length);
        Class<?>[] methodParameters = methods[i].getParameterTypes();
        this.parameters = getParameters(methodParameters);
        executeMethod(methods[i], parameters);
    }


    /**
     * Die ausgew�hlte Methode wird ausgef�hrt, es werden die Paramter eingegeben und ggf. das Objekt neu ausgegeben
     * 
     * @param m
     *            ist die ausgew�hlte Methode
     * @param parameters
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     */
    private void executeMethod(Method m, Object[] parameters) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            ClassNotFoundException {
        Object obj = m.invoke(o, parameters);
        System.out.println("R�ckgabetyp: " + m.getReturnType().getName());
        if (m.getReturnType().getName().equals("void")) {
            System.out.println("M�glicherweise wurden Werte ver�ndert. Sie werden nun neu ausgeben");
            fieldsInfo();
        } else if (m.getReturnType().isPrimitive() || m.getReturnType().getName().equals(String.class.getName())) {
            System.out.println("Wert der Methode " + m.getName() + ": " + obj);
            System.out.println();
        } else if (m.getReturnType().isArray()) {
            System.out.println("R�ckgabetyp ist ein Array mit den folgenden Werten");
            for (int i = 0; i < Array.getLength(obj); i++) {
                System.out.print(Array.get(obj, i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("Es wurde ein Objekt zur�ckgebeben. Die Objektinformationen: ");
            new ObjectBrowser(obj).objectInfo();
        }
    }



/**
 * Es wird eine Zahl eingegeben, die die Methodenauswahl ist
 * @param arrayLength
 * @return
 */
    private int getChoice(int arrayLength) {
        Scanner sc = new Scanner(System.in);
        int i = -1;
        try {
            i = sc.nextInt();
            if (i < 0 || i >= arrayLength) {
                System.out.println("Bitte versuchen Sie es nocheinmal");
                i = getChoice(arrayLength);
            }

        } catch (InputMismatchException e) {
            System.out.println("Das ging schief!Bitte Eingabe �berpr�fen!");
            i = getChoice(arrayLength);
        }
        return i;
    }
}

