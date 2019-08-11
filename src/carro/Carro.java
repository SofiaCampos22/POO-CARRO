
package carro;

import java.util.Scanner;
import javax.swing.JOptionPane;


class Carro {
    private String placa;
    private double velActual;
    private double velmax;
    private double velmin;
    private boolean estado;
    
   
 Carro(){
    this.placa = "RD1234";
    this.velActual = 0;
    this.velmax = 150;
    this.velmin = 0;
    this.estado = false;
}

public void setPlaca(String placa){
    this.placa = placa;
}

public void setVelocidadActual(double velActual){
    this.velActual = velActual;
}

public void setVelocidadMaxima(double velmax){
    this.velmax = velmax;
}

public void setVelocidadMinima(double velmin){
    this.velmin = velmin;
}

public void setEstado(boolean estado){
    this.estado = estado;
}

public String getPlaca(){
    return(this.placa);
}

public double getVelocidadActual(){
    return (this.velActual);
}
    
public double getVelocidadMax(){
    return (this.velmax);
}

public double getVelocidadMin(){
    return(this.velmin);
}

public boolean getEstado(){
    return(this.estado);
}

public String devolverEstadoDelAuto(){
    if(getEstado()){
        return "ENCENDIDO";
    }
    return "APAGADO";
}

public void formarMensajeDeSalidaPorConsola(String mensaje){
   
    System.out.print("+");
    
    System.out.println("+");
    System.out.println(":" +mensaje+ ":");
    System.out.print("+");
    
}

public void encenderAuto(){
    if(getEstado()){
        formarMensajeDeSalidaPorConsola("El Auto YA ESTABA encendido");
    }else{
        setEstado(true);
        formarMensajeDeSalidaPorConsola("El Auto HA SIDO encendido con éxito");
    }
}

public void aumentarVel(){
    if(getEstado()){
        Scanner sc = new Scanner(System.in);
        int cantidad;
        
        System.out.println("Velocidad Actual = " +getVelocidadActual() + "\nIngrese la cantidad a aumentar");
        cantidad = sc.nextInt();
        
        setVelocidadActual(getVelocidadActual() +cantidad);
        formarMensajeDeSalidaPorConsola("Velocidad del Auto Actual = " +getVelocidadActual());
        
    }else{
        formarMensajeDeSalidaPorConsola("El Auto esta APAGADO");
}
    
}

public void redVel(){
    Scanner sc = new Scanner(System.in);
    if(getEstado()){
        int cantidad;
        
        System.out.println("Velocidad Actual = " +getVelocidadActual() + "\nIngrese la cantidad a reducir");
        cantidad = sc.nextInt();
        
        setVelocidadActual(getVelocidadActual() -cantidad);
        formarMensajeDeSalidaPorConsola("Velocidad del Auto Actual = " +getVelocidadActual());
        
    }else{
        formarMensajeDeSalidaPorConsola("El Auto esta APAGADO");
    }
}

public void tanque(){
    Scanner sc = new Scanner(System.in);
    int tan;
    
    if(getEstado()){
        System.out.println("Ingrese la cantidad de gasolina que desea cargar: ");
        tan = sc.nextInt();
        
        formarMensajeDeSalidaPorConsola("El tanque ahora tiene: " +tan+ " de gasolina.");
        
    }else{
        formarMensajeDeSalidaPorConsola("El Auto esta APAGADO");
}
}

public void aceite(){
    Scanner sc = new Scanner(System.in);
    int ac;
    
    if(getEstado()){
        System.out.println("Ingrese la cantidad de aceite que desea cargar: ");
        ac = sc.nextInt();
        
        formarMensajeDeSalidaPorConsola("El Vehiculo ahora tiene " +ac+ " de aceite");
    }else{
        formarMensajeDeSalidaPorConsola("El Auto esta APAGADO");
    }
}

public void est(){
    
    System.out.println("La Placa es: " +getPlaca());
    System.out.println("La Velocidad Actual es: " +getVelocidadActual());
    System.out.println("La Velocidad Maxima es: " +getVelocidadMax());
    System.out.println("La Velocidad Minima es: " +getVelocidadMin());
    System.out.println("El Estado Actual es: " +getEstado());
}

public void apagarAuto(){
    if(getEstado()){
        setEstado(false);
    }else{
        formarMensajeDeSalidaPorConsola("El Auto YA Estaba Apagado");
    }
}

public void manejarTableroDeComandosDelAuto(){
    Scanner sc = new Scanner(System.in);
    char r;
    int opcion;
    do{
        System.out.println("********");
        System.out.println("*Tablero de Comando del Auto*");
        System.out.println("********");
        System.out.println("1. Encender Auto \n2. Aumentar Velocidad \n3. Reducir velocidad \n4. Cargar Tanque de Gasolina \n5. Cargar Tanque de Aceite \n6. Mostrar Condiciones del Auto \n7. Apagar Auto \n8. Salir");
        opcion = sc.nextInt();
        
        switch(opcion){
            case 1: 
                encenderAuto();
            break;
            case 2: 
                aumentarVel();
            break;
            case 3: 
                redVel(); 
            break;
            case 4:
                tanque();
            break;
            case 5:
                aceite();
            break;
            case 6:
                est();
            break;
            case 7:
                apagarAuto();
            break;
            case 8:
                System.exit(0);
            break;          
        }
    
        System.out.println("¿Desea volver a realizar el proceso? s/n");
        r = sc.next().charAt(0);
        
        }while(r=='s' || r=='S');
    
}

}