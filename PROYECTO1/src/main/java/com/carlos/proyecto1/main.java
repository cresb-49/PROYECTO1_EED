package com.carlos.proyecto1;

//import com.carlos.proyecto1.ED.*;
import com.carlos.proyecto1.ED.AVL;
import com.carlos.proyecto1.ED.NodoArbol;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;
import com.carlos.proyecto1.UI.FramePrincipal;

public class main {

    public static void main(String[] args) {
        
       //FramePrincipal principal = new FramePrincipal();
       
       try {
            AVL avl = new AVL();
            
            avl.agregar(new NodoArbol("40","40"));
            avl.agregar(new NodoArbol("50","50"));
            avl.agregar(new NodoArbol("7","7"));
            
            
            avl.agregar(new NodoArbol("20","20"));
            avl.agregar(new NodoArbol("5","5"));
            avl.agregar(new NodoArbol("60","60"));
            avl.agregar(new NodoArbol("75","75"));
            avl.agregar(new NodoArbol("6","6"));
            avl.agregar(new NodoArbol("30","30"));
            avl.agregar(new NodoArbol("10","10"));
            avl.agregar(new NodoArbol("15","15"));
            avl.agregar(new NodoArbol("12","12"));
            avl.agregar(new NodoArbol("1","1"));
            avl.agregar(new NodoArbol("14","14"));
            
            
            avl.eliminar("10");
            avl.eliminar("15");
            avl.eliminar("40");

            //avl.eliminar("30");
            
            //avl.eliminar("40");
            
            
            
            
            parametrosGraphviz g = avl.obtenerGrafico();
            String code = g.getModeloNodo()+g.getDeclaraciones()+g.getRelaciones();
            System.out.println(code);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
