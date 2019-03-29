/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.arithmétique;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cardo
 */
public class Cardoso_Viraragavane {
    ///euclide etendu question 1
    public static int[] EuclideEtendue(int a,int b){
    ArrayList<Integer> reste=new ArrayList<Integer>();
    ArrayList<Integer> u=new ArrayList<Integer>();
    ArrayList<Integer> v=new ArrayList<Integer>();
    int i=1;
    reste.add(a);
    reste.add(b);
    u.add(1);
    u.add(0);
    v.add(0);
    v.add(1);
    while(reste.get(i)!=0){
        reste.add(reste.get(i-1)-(reste.get(i-1)/reste.get(i))*reste.get(i));
        u.add(u.get(i-1)-(reste.get(i-1)/reste.get(i))*u.get(i));
        v.add(v.get(i-1)-(reste.get(i-1)/reste.get(i))*v.get(i));
        i++;
    }
    return new int[]{reste.get(i-1), u.get(i-1), v.get(i-1)};
    }
    ///exponentiation modulaire question 2
    public static int ExpMod (int a, int k, int n) { 
        int p=0;
        for ( k=k ; k>0 ; k=k/2 ) 
        {       
            if ( k % 2 != 0 )  
                p = ( p * a ) % n ;      
            a =( a * a ) % n ;    
        }    
        return p;   
    } 
    
    
    /// test de fermat question 3, on teste pour un nombre au hasard entre 1 et 1000;
    public boolean testFermat(int p){
        int a = (int) (1+Math.random()*(999));
        return (Math.pow(a,p-1)-1)%p==0;
    }
    
    
     /// primalite naif question 3, teste si un nombre est devisible par un des entiers 
    ///entre 2 et la racine de ce nombre, si c'est pa le cas alors il est premier
    public static boolean primaliteNaif(int n){
        boolean premier=true;
        for(int i=2; i<=Math.sqrt(n);i++){
            if ( n%i==0){
            premier=false;}
        }
        return premier;
    }
    
    //// fonction qui teste la proportion de nombre premier dans un intervale grace a la fonction
    //// primaliteNaif(int n ) et les affiche question 4 marche pas encore
    
    public static String testeSurIntevaleNaif(int debut, int fin){
        int qteNbPremier=0;
        ArrayList<Double> prop = new ArrayList<Double>();
        ArrayList<ArrayList<Double>> proportion = new ArrayList<ArrayList<Double>>();
        
        for(int i=debut; i<=fin;i++){
            qteNbPremier=0;
            for(int j=(int) Math.pow(2, i);j<Math.pow(2,i+1);j++)
            {
                if(primaliteNaif(i)){qteNbPremier+=1;}
            }
            prop.add(Math.pow(2,i+1)-Math.pow(2,i));
            prop.add((double)qteNbPremier);
            proportion.add(i, prop);
        }
        return proportion.toString();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(EuclideEtendue(120,23)[0]+"  |   "+EuclideEtendue(120,23)[1]+"  |  "+EuclideEtendue(120,23)[2]);
        System.out.println(primaliteNaif(2)+"  |   "+primaliteNaif(7)+"  |  "+primaliteNaif(8) +"   |   "+primaliteNaif(9)+"  |  "+primaliteNaif(11));
        System.out.println(testeSurIntevaleNaif(1,3));
         
         
    }
    
}
