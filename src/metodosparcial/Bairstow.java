/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosparcial;

/**
 *
 * @author Brian Cañon
 */
public class Bairstow {
     private int dimension;
   private double[] a; //Polinomio inicial
   private double[] b; 
   private  double[] c; 
   private int n;
  

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setBn(double[] a) {
        this.a = a;
    }           
    public Bairstow(){ 
   
    }

    public Bairstow(int dimension) {
        this.dimension = dimension;
        a = new  double [dimension]; //Polinomio inicial
        b =  new double[dimension]; //Guarda la primera division sintetica
        c = new double[dimension];
        n = dimension-1;
    }
    
   public void Solucionar(){
 int i, j;
    double r1, r2, du, dv, u, v, r, dr;
    double sq, det, nu, nv, error;
    double epsilon = 1e-8;
    while (n > 3) {
      u = 0;
      v = 0;
      error = 1;
      c[n] = b[n] = a[n];

      while (error > epsilon) {
        b[n-1] = a[n-1] + u * b[n];
        c[n-1] = b[n-1] + u * c[n];

        for (i = n - 2; i > 0; i--) {
          b[i] = a[i] + u * b[i+1] + v * b[i+2];
          c[i] = b[i] + u * c[i+1] + v * c[i+2];
        }

        b[0] = a[0] + u * b[1] + v * b[2];

        det = (c[2] * c[2]) - c[1] * c[3];

        nu = b[0] * c[3] - b[1] * c[2];
        nv = b[1] * c[1] - b[0] * c[2];
        
        if (det == 0) {
          du = dv = 1;
        } else {
          du = nu / det;
          dv = nv / det;
        }
        
        u += du;
        v += dv;

        error = Math.sqrt(du * du + dv * dv);
      }
      System.out.println("1" + " " + (-1*u) + " "+(-1*v));
      //vis.getBrR().setText("1" + " " + (-1*u) + " "+(-1*v));
      for(int t=n-2;t>=0;t--){
        System.out.print(b[t]+" ");
        //vis.getBrR().setText(b[t]+" ");
      }
      System.out.println();
      sq = u * u + 4 * v;

      if (sq < 0) {
        r1 = u/2;
        r2 = Math.sqrt(-sq)/2;

        System.out.println(r1 + " + " + r2 + "i");
        //vis.getBrR().setText(r1 + " + " + r2 + "i");
        System.out.println(r1 + " - " + r2 + "i");
        //vis.getBrR().setText(r1 + " - " + r2 + "i");
      } else {
        r1 = u/2 + Math.sqrt(sq)/2;
        r2 = u/2 - Math.sqrt(sq)/2;

        System.out.println(r1);
        //vis.getBrR().setText(String.valueOf(r1));
        System.out.println(r2);
        //vis.getBrR().setText(String.valueOf(r2));
      }

      n -= 2;

      for (i = 0; i < n + 1; i++)
        a[i] = b[i+2];
    }
    
    if (n == 3) {
      r = 0;
      error = 1;
      b[n] = a[n];

      while (error > epsilon) {
        b[2] = a[2] + r * b[3];
        b[1] = a[1] + r * b[2];
        b[0] = a[0] + r * b[1];

        double d = a[1] + (2 * a[2] * r) + (3 * a[3] * r * r);

        if (d == 0)
          dr = 1;
        else
          dr = -b[0] / d;

        r -= dr;
        error = Math.abs(dr);
      }

      System.out.println(r);
      //vis.getBrR().setText(String.valueOf(r));
      n--;

      for (i = 0; i < n + 1; i++)
        a[i] = b[i + 1];
    }


    if (n == 2) {
      u = -a[1] / a[2];
      v = -a[0] / a[2];
      sq = u * u + 4 * v;

      if (sq < 0) {
        r1 = u/2;
        r2 = Math.sqrt(-sq)/2;

        System.out.println(r1 + " + " + r2 + "i");
       // vis.getBrR().setText(r1 + " + " + r2 + "i");
        System.out.println(r1 + " - " + r2 + "i");
        //vis.getBrR().setText(r1 + " - " + r2 + "i");
      } else {
        r1 = u/2 + Math.sqrt(sq)/2;
        r2 = u/2 - Math.sqrt(sq)/2;

       System.out.println(r1);
        //vis.getBrR().setText(String.valueOf(r1));
        System.out.println(r2);
        //vis.getBrR().setText(String.valueOf(r2));
      }
    } else if (n == 1) {
      System.out.println(-a[0] / a[1]);
      //vis.getBrR().setText(String.valueOf(-a[0]/a[1]));
    }
    } 
}
