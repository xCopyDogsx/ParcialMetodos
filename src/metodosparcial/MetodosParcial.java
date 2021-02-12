/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosparcial;

import javax.swing.JOptionPane;

/**
 *
 * @author Brian Cañon
 */
public class MetodosParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dimension=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio "));
        while(dimension<0){
            dimension=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio "));
        }   
        double[] arreglo = new double [dimension+1]; 
           
            double num;
            for(int i=0;i<dimension+1;++i){
                num = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el coeficiente Nro (Nota: El polinomio va ordenado de menor a mayor grado) "+( i + 1 )));
                arreglo[i]=num;
            }
              
            Bairstow Mbair = new Bairstow(dimension);
            Mbair.setBn(arreglo);
            Mbair.Solucionar();
    }
    
}
