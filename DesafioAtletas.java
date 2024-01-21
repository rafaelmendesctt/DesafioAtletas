package curso;

import java.util.Locale;
import java.util.Scanner;

public class DesafioAtletas {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		String nome = "";
		String salvarNome = "";
		String sexo = "M";
		double altura, peso;
		double mediaPeso = 0;
		double maior = 0;
		double contagemMulheres = 0;
		double mediaAlturaMulheres = 0;
		double contagemHomens = 0;
		
		System.out.print("Qual a quantidade de atletas? ");
		int escolha = scanner.nextInt();
		scanner.nextLine();
		
		for (int cont = 1; cont<=escolha; cont++) {
			System.out.printf("Digite os dados do atleta numero %d: \n", cont);
			System.out.print("Nome: ");
			nome = scanner.nextLine();
			
			System.out.print("Sexo: ");
			sexo = scanner.nextLine();
			while (!sexo.equals("F") && !sexo.equals("M")) {
				System.out.print("Valor invalido! Favor digitar F ou M: ");
				sexo = scanner.nextLine();
			}
			
			System.out.print("Altura: ");
			altura = scanner.nextDouble();
			while (altura<=0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				altura = scanner.nextDouble();
			}
			
			System.out.print("Peso: ");
			peso = scanner.nextDouble();
			scanner.nextLine();
			while (peso<=0) {	
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				peso = scanner.nextDouble();
				scanner.nextLine();
			}
			
			if (sexo.equals("F")) {
				contagemMulheres++;
				mediaAlturaMulheres+=altura;
			}
			if (sexo.equals("M")) {
				contagemHomens++;
			}
			if (altura>maior) {
				maior = altura;
				salvarNome = nome;
			}
			mediaPeso+=peso;
		}
		
		System.out.println("\nRELATÓRIO: ");
		System.out.printf("Peso médio dos atletas: %.2f\n", mediaPeso/escolha);
		System.out.printf("Atleta mais alto: %s\n", salvarNome);
		System.out.printf("Porcentagem de homens: %.1f %% \n", (contagemHomens*100)/escolha);
		
		if (contagemMulheres==0) {
			System.out.printf("Não há mulheres cadastradas");
		} else {
			System.out.printf("Altura média das mulheres: %.2f\n", mediaAlturaMulheres/contagemMulheres);
		}
		
		scanner.close();
	}
}