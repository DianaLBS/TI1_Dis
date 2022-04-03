package main;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;

public class HTDebug {

	private static Scanner sc;
	public static String names[];
	private static HT<String, Integer> hashTab;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int peopleNum=sc.nextInt();
		sc.nextLine();
		hashTab = new HT<String, Integer>(peopleNum);
		
		String names []= new String[peopleNum];
		for(int i=0; i<peopleNum;i++) {
			String name=sc.nextLine();
			int floor=sc.nextInt();
			sc.nextLine();
			hashTab.insertData(name, floor);
			names[i]=name;
		}
		menu(names);
	}
	public static void menu(String namesju[]) {
		System.out.println("Choose a option:"
				+ "\n1: Cambiar Piso de una persona"
				+ "\n2: Generar Reporte"
				+ "\n3: Averiguar en que piso esta una persona");
		int opt=sc.nextInt();
		sc.nextLine();
		switch(opt) {
		case 1:
			System.out.println("Escriba el nombre de la persona:");
			String name=sc.nextLine();
			System.out.println("Escriba el numero del nuevo piso");
			int floor=sc.nextInt();
			sc.nextLine();
			cambiarPiso(name,floor);
			break;
		case 2:

			generarReporte(namesju);
			break;
		case 3:
			System.out.println("Escriba el nombre de la persona:");
			String name1=sc.nextLine();
			dondeEstaUnaPersona(name1);
			break;
		default:
			System.out.println("error");
		}
	}
	
	public static void cambiarPiso(String name, int newFloor) {
		
		boolean added=hashTab.insertData(name, newFloor);
		if(added) {
			System.out.println("Piso cambiado");
		}else {
			System.out.println("No se encontró el nombre");
		}
		dondeEstaUnaPersona(name);
	}
	
	public static void generarReporte(String names[]) {
		for(int i=0; i<names.length;i++) {
			Vector<Integer> valor=hashTab.findValue(names[i]);
			System.out.println(names[i]+" Está en el piso: "+valor.get(valor.size()-1));
		}
	}
	
	public static void dondeEstaUnaPersona(String name) {
		Vector<Integer> valor=hashTab.findValue(name);
		System.out.println(name+" Está en el piso: "+valor.get(valor.size()-1));
	}
}
