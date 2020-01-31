package rabin_krapp;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import javafx.util.Pair;
public class Rabin_karp {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        Random r =new Random();
        Numerical_pattern np=new Numerical_pattern();
        DecriptPath dp=new DecriptPath();
        HashMap<String,Integer> map=new HashMap();
        map.put("mumbai",r.nextInt(1000));
        map.put("pune",r.nextInt(1000));
        map.put("surat",r.nextInt(1000));
        map.put("nagpur",r.nextInt(1000));
        map.put("bhopal",r.nextInt(1000));
        map.put("ahemdabad",r.nextInt(1000));
        map.put("kerala",r.nextInt(1000));
        map.put("hyderabad",r.nextInt(1000));
        map.put("jaipur",r.nextInt(1000));
        map.put("delhi",r.nextInt(1000));
        System.out.println(map);
        System.out.print("Enter total number of stations to visit :");
        int num=sc.nextInt();
        System.out.println("Enter  stations name :"); 
        String names1[]=new String[num];
        int weight1[]=new int[num];
        int weight2[]=new int[num];
        int pathValue[]=new int[num];
        for(int i=0;i<num;i++){
            names1[i]=sc.next(); //taking input of cities
            if(map.containsKey(names1[i])){
                weight1[i]=map.get(names1[i]);
            }
        }
        Pair <Integer,int[]> pair=np.num_pattern(3, weight1); //converting string to numeric code
        System.out.println("");
        System.out.println("Code for journey is :"+pair.getKey());
        //decript the path 
        pathValue=pair.getValue(); //collecting the individual code of cities
        weight2=dp.city(3,pathValue);               
        System.out.println("Your destinations are ::");
        for(int i=0;i<weight1.length;i++){
            for(Map.Entry<String,Integer> m: map.entrySet()){
                if(m.getValue()== weight1[i])
                    System.out.print(m.getKey()+"  ->"+weight2[i]+" | "); 
            }
        }
    }  
}
