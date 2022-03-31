package main;


import java.util.Collections;
import java.util.HashMap;

import java.util.PriorityQueue;
import java.util.Stack;


public class IntegradoraJava {
    public static void main(String[]args){
        HashMap<Floor,String>hash=new HashMap<>();
        hash.put(new Floor(1,3),"Daniel");
        hash.put(new Floor(2,1),"Gabriel");
        hash.put(new Floor(1,2),"Luis");
        PriorityQueue q=new PriorityQueue();
        PriorityQueue r=new PriorityQueue<>(Collections.reverseOrder());
        Stack s=new Stack();
       for(Floor key:hash.keySet()){
           int floora=key.getFlooractual();
           int floorb=key.getFloorarrive();
           if(floora<floorb){
               q.add(floorb);
           }else{
               r.add(floorb);
           }
       }
      while(q.peek()!=null){
         for(Floor key:hash.keySet()){
           Integer floorb=key.getFloorarrive();
           if(floorb.equals(q.peek())){
               System.out.println(hash.get(key));
           }
         }
         q.poll();
        
      }
      while(r.peek()!=null){
          for(Floor key:hash.keySet()){
           Integer floorb=key.getFloorarrive();
           if(floorb.equals(r.peek())){
               System.out.println(hash.get(key));
           }
         }
         r.poll();
      }
    }
}