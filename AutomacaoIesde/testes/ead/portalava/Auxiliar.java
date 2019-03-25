package ead.portalava;

import java.util.Random;

public class Auxiliar {
	public static void Pause5sec() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void Pause10sec() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void Pause40sec() {
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void Pause1min() {
		try {
			Thread.sleep(70000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//random name
	public String nomeAluno() {
		Random rnd = new Random();
		String str = "";
		String str1 = "";
		String sob = "";
		int supName = 0;

		for (int i = 0; i < 10; i++) {
			supName = (rnd.nextInt(99));
			String str2 = "Aluno";
			str = String.valueOf(supName);
			str1 = str2.concat(str);
		}
		for (int i = 0; i < 10; i++) {
			supName = (rnd.nextInt(100));
			String str2 = " teste";
			str = String.valueOf(supName);
			sob = str2.concat(str);
		}

		return str1.concat(sob);
	}
	
	//random email
		public String emailGenerator() {
			Random rnd = new Random();
			String str = "";
			String str1 = "";
			String sob = "";
			int supName = 0;

			for (int i = 0; i < 10; i++) {
				supName = (rnd.nextInt(99));
				String str2 = "aluno";
				str = String.valueOf(supName);
				str1 = str2.concat(str);
			}
			for (int i = 0; i < 10; i++) {
				supName = (rnd.nextInt(100));
				String str2 = "@iesde.com.br";
				str = String.valueOf(supName);
				sob = str.concat(str2);
			}

			return str1.concat(sob);
		}
		
		public static class CPF {

			public String generate() {

				Random r = new Random();

				StringBuilder sbCpfNumber = new StringBuilder();

				for (int i = 0; i < 9; i++) {

					sbCpfNumber.append(r.nextInt(9));

				}

				return generateDigits(sbCpfNumber.toString());

			}

			public boolean validateCPF(String cpf) {

				if (cpf.length() == 11) {

					if (cpf.equals(generateDigits(cpf.substring(0, 9)))) {

						return true;
					}
				}
				return false;
			}

			private String generateDigits(String digitsBase) {

				StringBuilder sbCpfNumber = new StringBuilder(digitsBase);

				int total = 0;

				int multiple = digitsBase.length() + 1;

				for (char digit : digitsBase.toCharArray()) {

					long parcial = Integer.parseInt(String.valueOf(digit)) * (multiple--);

					total += parcial;
				}

				int resto = Integer.parseInt(String.valueOf(Math.abs(total % 11)));

				if (resto < 2) {
					resto = 0;
				} else {
					resto = 11 - resto;
				}

				sbCpfNumber.append(resto);

				if (sbCpfNumber.length() < 11) {
					return generateDigits(sbCpfNumber.toString());
				}
				return sbCpfNumber.toString();
			}
		}

		public String CPF() {
			CPF myCPF = new CPF();
			String cpf = myCPF.generate();
			return cpf;
		}

}
