package com.mycompany.doble;

import javax.swing.JOptionPane;

public class Doble {

    NodoDoble inicio;
    Doble(){
        inicio = null;
    }
    public void insertarInicio(String datos){
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setDatos(datos);
        
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
                JOptionPane.showMessageDialog(null, "Datos: " + temporal.getDatos());
                temporal = temporal.getSiguiente();
            }
        }
    }
    
    public void insertarFinal(String datos){
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setDatos(datos);
        
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
            nuevo.setAnterior(nuevo);
            nuevo.setSiguiente(null);
        }
        //insertar en una posicion dada
        //insertar antes de una posicion dada
        //eliminar un nodo dado
    }
    
}
