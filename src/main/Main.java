package main;

import java.util.Scanner;

import model.HashMap;
import model.Max_PriorityQueue;
import model.Min_PriorityQueue;

public class Main {

	private Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Main obj=new Main();
		obj.elevatorBuilding();
	}
	public void elevatorBuilding() {
		Max_PriorityQueue<Integer>maxQ=new Max_PriorityQueue(10);
		Min_PriorityQueue<Integer>minQ=new Min_PriorityQueue(10);
		int numBuilding=sc.nextInt();
		for(int i=0;i<numBuilding;i++) {
			HashMap<String,Integer>person_office=new HashMap();
			HashMap<Integer,String>floorUp=new HashMap();
			HashMap<Integer,String>floorDown=new HashMap();
			String idBuilding=sc.next();
            int numPerson=sc.nextInt();
            int numFloors=sc.nextInt();
            int office=sc.nextInt();
            for(int j=0;j<numPerson;j++) {
            	String name=sc.next();
            	int actualfloor=sc.nextInt();
            	int officeB=sc.nextInt();
            	person_office.put(name,officeB);
            	int arrivefloor=searchFloorArrive(numFloors,office,officeB);
            	if(actualfloor<arrivefloor) {
            		maxQ.add(officeB);
            		floorUp.put(officeB, name);
            	}else {
            		minQ.add(officeB);
            		floorDown.put(officeB, name);
            	}
            }
            System.out.println();
            for(int j=0;j<person_office.size();j++) {
            	System.out.println(person_office.keySet().get(j)+" se mueve a la oficina: "+person_office.values().get(j));
            }
            System.out.println();
            System.out.println("El orden de llegada es ");
            while(maxQ.peek()!=null) {
            	for(int j=0;j<floorUp.size();j++) {
            		if(floorUp.keySet().get(j).equals(maxQ.peek())) {
            			System.out.println(floorUp.get(maxQ.peek()));
            		}
            	}
            	maxQ.poll();
            }
            while(minQ.peek()!=null) {
            	for(int j=0;j<floorDown.size();j++) {
            		if(floorDown.keySet().get(j).equals(minQ.peek())) {
            			System.out.println(floorDown.get(minQ.peek()));
            			
            		}
            	}
            	minQ.poll();
            }
            
		}
	}
	public int searchFloorArrive(int numFloors,int office,int officeB) {
		int[][]building=new int[numFloors][office];
		int numberOffice=numFloors*office;
		int floor=0;
		for(int i=0;i<numFloors;i++) {
			for(int j=0;j<office;j++) {
				building[i][j]=numberOffice;
				numberOffice--;
			}
		}
		for(int i=0;i<numFloors;i++) {
			for(int j=0;j<office;j++) {
             if(building[i][j]==officeB) {
            	 floor=i+1;
             }

			}
		}
		return floor;
	}

}
