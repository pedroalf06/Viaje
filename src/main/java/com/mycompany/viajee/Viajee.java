/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.viajee;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */

abstract class  Viajero {
    Scanner sc = new Scanner (System.in);
   private String tDoc;
    private int id;
    private String nombre;
    private int edad;
    private String origen;
    private String destino;
    private double duracion;
    protected double cB;
    protected double recargo;
    protected double total; 

public void iDatos(){
    System.out.println("Ingresar Tipo de documento: ");
    tDoc = sc.nextLine();
    
    System.out.println("Ingresar numero de documento: ");
    id = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresar nombre: ");
    nombre = sc.nextLine();
    
    System.out.println("Ingresar edad: ");
    edad = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresar origen del viaje: ");
    origen = sc.nextLine(); 
    
    System.out.println("Ingresar destino del viaje: ");
    destino = sc.nextLine(); 
    
    System.out.println("Ingresar duracion del viaje en horas: ");
    duracion = sc.nextDouble(); 
    
    System.out.println("Ingresar costo del viaje: ");
    cB= sc.nextDouble(); 
    
    
}

public void mDatos(){
    
    System.out.println("tipo de documento: " + tDoc);
    System.out.println("numero de documento: " + id);
    System.out.println("nombre: " + nombre);
    System.out.println("edad: " + edad);
    System.out.println("origen: " + origen);
    System.out.println("destino: " + destino);
    System.out.println("duracion: " + duracion);
}

public abstract double getTotal();
    
}

class Terrestre extends Viajero{
    private int tVehiculo;
    
    public void setvehiculo() {
    
    System.out.println("Ingresar el tipo de vehiculo: 1 - bus, 2 - minibus, 3 - coche ");
    tVehiculo= sc.nextInt();
    
    if (tVehiculo == 1){
        recargo = 0; 
    } else if (tVehiculo == 2){
        recargo = cB * 0.1;
    } else if (tVehiculo == 3){
         recargo = cB * 0.15;
    }
    
}
    @Override
    public double getTotal(){
        total = cB + recargo;
        return(total);
    }
    
    
}

class Aereo extends Viajero {
       
    private int tMaleta; 
    
    public void setMaleta(){
     
    System.out.println("Ingresar el tipo de maleta: 1 - morral, 2 - mediana, 3 - grande ");
    tMaleta= sc.nextInt();
    
    if (tMaleta == 1){
        recargo = 0; 
    } else if (tMaleta == 2){
        recargo = cB * 0.1;
    } else if (tMaleta == 3){
         recargo = cB * 0.15;
    }
        
    }
    
      @Override
    public double getTotal(){
        total = cB + recargo;
        return(total);
    }
}






public class Viajee {

    public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
        Terrestre te = new Terrestre();
        Aereo ae = new Aereo();
        int opc;
        boolean salir = true;
        
        do {
        
        System.out.println("Ingrese la opcion que desea:");
        System.out.print("1 - Viaje terrestre: ");
        System.out.print("2 - Viaje aereo: ");
        System.out.print("3 - Salir: ");
        opc = sc.nextInt();
        switch(opc){
        
            case 1:
               System.out.println("***************Viaje Terrestre******************"); 
                te.iDatos();
                te.setvehiculo();
                te.mDatos();
                System.out.println("Total del viaje terrestre es = "+ te.getTotal()) ;
                break;
            case 2:
                System.out.println("***************Viaje Aereo******************");
                ae.iDatos();
                ae.setMaleta();
                ae.mDatos();
                System.out.println("Total del viaje aereo es = "+ ae.getTotal()) ;
                break;
                
            case 3:
                salir = false;
                System.out.println("Gracias por su compra");
                break;
                
            default:
                System.out.println("Opcion incorrecta, intentelo de nuevo ");
        }
        }while(salir);
    }
}
