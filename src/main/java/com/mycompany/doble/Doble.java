package com.mycompany.doble;

import javax.swing.JOptionPane;

public class Doble {

    NodoDoble inicio;
    Doble(){
        inicio = null;
    }
    public void insertarInicio(String nombre, int edad){
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        
        if(inicio != null){
            
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
        }
        inicio = nuevo;
    }
    
    public void imprimir(){
        
        NodoDoble temporal = inicio;
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "No hay nadie en la lista");
        }else{
            while(temporal != null){
                JOptionPane.showMessageDialog(null, "Datos: " + temporal.getNombre() + " " + temporal.getEdad());
                temporal = temporal.getSiguiente();
            }
        }
    }
    
    public void insertarFinal(String nombre, int edad){
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        
        if(inicio == null){
            inicio = nuevo;
            nuevo.setAnterior(nuevo);
            nuevo.setSiguiente(null);
            }else{
            NodoDoble temporal = inicio;
            while(temporal.getSiguiente() != null){
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nuevo);
            nuevo.setAnterior(temporal);
        }
    }
    
    public void position(int position){  
        NodoDoble nuevo = new NodoDoble();
        String siguiente = "";
        String antes = "";
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        int contador = 1;
        if(inicio == null){
        JOptionPane.showMessageDialog(null, "no hay nada en la lista");
        }else if(inicio != null && position>=0){
            NodoDoble temporal = inicio;
            while(temporal.getSiguiente() != null && contador != position){
                temporal = temporal.getSiguiente();
                contador++;
            }
            if(temporal.getSiguiente() == null){
                siguiente = "no hay nadie despues";
            }else{
            siguiente = temporal.getSiguiente().getNombre();
            }
                if(temporal.getAnterior() == null){
            antes = "no hay nadie antes";
            }else{
            antes = temporal.getAnterior().getNombre();
                }
            JOptionPane.showMessageDialog(null,"persona adelantes " + siguiente + " persona atras " + antes);
            
        }else{
            JOptionPane.showMessageDialog(null, "no existe o el valor ingresado no es valido");
        }
        
    }
    
    public void mayores(){
        NodoDoble nuevo = new NodoDoble();
        String posicion = "";
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        int contador = 1;
        if(inicio == null){
        JOptionPane.showMessageDialog(null, "no hay nada en la lista");
        }else{
            NodoDoble temporal = inicio;
            while(temporal != null){
                if(temporal.getEdad()>=18){
                    posicion += "\nedad: " + temporal.getEdad() + " en la posicion " + contador;
                }
                temporal = temporal.getSiguiente();
                contador++;
            }
            JOptionPane.showMessageDialog(null, posicion);
        }
    }

}
