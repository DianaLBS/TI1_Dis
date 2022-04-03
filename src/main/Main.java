package main;

import model.Max_PriorityQueue;
import model.Min_PriorityQueue;

public class Main {

	public static void main(String[] args) {
		Main obj=new Main();
		obj.elevatorBuilding();
	}
	public void elevatorBuilding() {
		Max_PriorityQueue<Integer>p=new Max_PriorityQueue(10);
		Min_PriorityQueue<Integer>q=new Min_PriorityQueue(10);
	}

}
