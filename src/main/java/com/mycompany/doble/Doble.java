package com.mycompany.doble;

import javax.swing.JOptionPane;

public class Doble {

    NodoDoble inicio;
    int contador = 0;
    Doble(){
        inicio = null;
    }
    public void insertarInicio(String nombre, int edad){
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(nuevo);
        nuevo.setSiguiente(nuevo);
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        contador++;
        if(inicio == null){
            inicio = nuevo;
        }else{
            NodoDoble temporal = inicio.getAnterior();
            nuevo.setSiguiente(inicio);
            nuevo.setAnterior(temporal);
            temporal.setSiguiente(nuevo);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }
    
    public void imprimir(){
        
        NodoDoble temporal = inicio;
        int conteo = 0;
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "No hay nadie en la lista");
        }else{
            while(contador!=conteo){
                JOptionPane.showMessageDialog(null, "Datos: " + temporal.getNombre() + " " + temporal.getEdad());
                temporal = temporal.getSiguiente();
                conteo++;
            }
        }
    }
    
    public void insertarFinal(String nombre, int edad){
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(nuevo);
        nuevo.setSiguiente(nuevo);
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        contador++;
        if(inicio == null){
            inicio = nuevo;
            inicio.setAnterior(inicio);
            inicio.setSiguiente(inicio);
        }else{
            NodoDoble temporal = inicio.getAnterior();
            temporal.setSiguiente(nuevo);
            nuevo.setAnterior(temporal);
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
        }
    }
    
    public void position(int position){  
        NodoDoble nuevo = new NodoDoble();
        String siguiente = "";
        String antes = "";
        if(inicio == null){
        JOptionPane.showMessageDialog(null, "no hay nada en la lista");
        }else if(inicio != null && position>=0){
            NodoDoble temporal = inicio;
            int cont = 0;
            
            while(cont < position-1){
                temporal = temporal.getSiguiente();
                cont++;
            }
            
            siguiente = temporal.getSiguiente().getNombre();
            antes = temporal.getAnterior().getNombre();
                
            JOptionPane.showMessageDialog(null,"persona adelantes " + siguiente + " persona atras " + antes);
            
        }else{
            JOptionPane.showMessageDialog(null, "no existe o el valor ingresado no es valido");
        }
    }
    
    public void mayores(){
        NodoDoble nuevo = new NodoDoble();
        String posicion = "";
        int conteo = 1;
        if(inicio == null){
        JOptionPane.showMessageDialog(null, "no hay nada en la lista");
        }else{
            NodoDoble temporal = inicio;
            while(conteo<=contador){
                if(temporal.getEdad()>=18){
                    posicion += "\nedad: " + temporal.getEdad() + " en la posicion " + conteo;
                }
                temporal = temporal.getSiguiente();
                conteo++;
            }
            JOptionPane.showMessageDialog(null, posicion);
        }
    }
    
    public void eliminar(){
        NodoDoble temporal = inicio;
        int conteo = 0;
        if(inicio == null){
        JOptionPane.showMessageDialog(null, "no hay nada en la lista");
        }else{
            do{
                if(temporal.getEdad()<18){
                    if(temporal == inicio){
                    inicio = temporal.getSiguiente();
                    }
                    temporal.getAnterior().setSiguiente(temporal.getSiguiente());
                    temporal.getSiguiente().setAnterior(temporal.getAnterior());
                    contador--;
                }else{
                conteo++;
                }
                temporal = temporal.getSiguiente();
            }while(temporal != inicio && conteo<contador);
        }
    }
}
