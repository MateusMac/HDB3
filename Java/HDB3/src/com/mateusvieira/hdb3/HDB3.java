package com.mateusvieira.hdb3;

import java.util.Scanner;

public class HDB3 {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

	menu();
    }

    private static void menu() {

	int choice = 0;

	do {
	    System.out.println("\n\n### Sistema Para Codificar/Decodificar HDB3 ###");
	    System.out.println("\n                  =============================");
	    System.out.println("                  |     1 - Codificar         |");
	    System.out.println("                  |     2 - Decodificar       |");
	    System.out.println("                  |     0 - Sair              |");
	    System.out.println("                  =============================\n");
	    System.out.print("---> Digite uma das opções acima: ");
	    choice = scan.nextInt();
	    System.out.print("\n");

	    switch (choice) {

		case 1:
		    encode();
		    //System.out.println(EncodeHDB3.encode("101000001100001100000001"));
		    break;
		case 2:
		    DecodeHDB3.decode("050505");
		    break;
		case 0:
		    System.out.println("Fim do programa.");
		    break;
		default:
		    System.out.println("Opção Inválida!");
		    Utils.clearScreen();
		    break;
	    }
	} while (choice != 0);
    }
    
    private static String encode() {
	
	long input = 0;
	
	System.out.print("---> Digite um input para codificar: ");
	input = scan.nextLong();
	System.out.println(new Long(input).toString());
	System.out.println(EncodeHDB3.encode(new Long(input).toString()));
	
	return "";
    }
}
