package com.mateusvieira.hdb3;

import java.util.Scanner;

public class HDB3 {

    public static void main(String[] args) {

	menu();
    }

    private static void menu() {

	@SuppressWarnings("resource")
	Scanner num = new Scanner(System.in);

	int opcao = 0;

	do {
	    System.out.println("\n\n### Sistema Para Codificar/Decodificar HDB3 ###");
	    System.out.println("\n                  =============================");
	    System.out.println("                  |     1 - Codificar         |");
	    System.out.println("                  |     2 - Decodificar       |");
	    System.out.println("                  |     0 - Sair              |");
	    System.out.println("                  =============================\n");
	    System.out.print("---> Digite uma das opções acima: ");
	    opcao = num.nextInt();
	    System.out.print("\n");

	    switch (opcao) {

		case 1:
		    System.out.println(EncodeHDB3.encode("0101000101"));
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
	} while (opcao != 0);
    }
}
