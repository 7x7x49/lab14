package com.company;

import java.util.Scanner;
import java.io.*;

class Trigonometry implements Serializable {  //сериализовать можно только те объекты, которые реализуют интерфейс Serializable
    double x;
    double y;
    Trigonometry() { x=0; y=0; }

    void Designer(double x)    {
        this.x = x;
        y = this.x - Math.sin(this.x); //конструктор решения
        System.out.println(y); }           }

public class Main {
    public static void main(String[] args) {
        String enter;
        Scanner in = new Scanner(System.in); //ввод либо числа, либо команды
        Trigonometry y = new Trigonometry();  //присваивание переменной
        System.out.println((char) 27 + "[44mThe example is given: y = x - sinx" + (char)27 + "[0m");
        System.out.println((char) 27 + "[36mEnter the number to be stored in the variable (x). [In this case, you will get the answer (or what is the value (y))]" + (char)27 + "[0m");
        System.out.println((char) 27 + "[44mYou can also:" + (char)27 + "[0m");

        System.out.println((char) 27 + "[36m♡ SAVE the new value using the \"s\" command;\n" +
                "♡ UPLOAD the value using the \"u\" command;\n" +
                "♡ CHECK the current value using the \"c\" command." + (char)27 + "[0m");

        while(true) {
            enter = in.nextLine(); //считывание от начала до конца строки
            try {
                double x = Double.parseDouble(enter); //возврат нового значения double
                y.Designer(x); //решение с помощью конструктора
                }
            catch (Exception ex) {

                if (enter.equalsIgnoreCase("s")) {
                    try (ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("output"))) { //сериализация объектов в поток
                        object.writeObject(y); //считывание состояния объекта
                        System.out.println((char) 27 + "[45mValues saved." + (char)27 + "[0m");                }
                    catch (IOException IOex) { IOex.getMessage(); }
                                                           }
                else if (enter.equalsIgnoreCase("u")){  //сравнение двух строк без учёта регистра

                    try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("output"))) {
                        y = (Trigonometry) obj.readObject();
                        System.out.println((char) 27 + "[45mValues restored." + (char)27 + "[0m");          }
                    catch (Exception IOex)   { IOex.getMessage(); }}
                
                
                else if(enter.equalsIgnoreCase("c")){
                    System.out.println((char) 27 + "[45mThe variables correspond to:" + (char)27 + "[0m");
                    System.out.println("x = " + y.x + " y = "+ y.y);
                                                              }
                else{
                    System.out.println((char) 27 + "[31mError. Make sure that the values are entered correctly." + (char)27 + "[0m");
                   }}}            }         }





