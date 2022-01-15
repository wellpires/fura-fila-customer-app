package br.com.furafilapp.customerapp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class CustomerAppUtils {

	public static LocalDate stringToLocalDate(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		return LocalDate.parse(value, DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
	}

	public static String localDateToString(LocalDate localDate) {
		if (Objects.isNull(localDate)) {
			return null;
		}

		return localDate.format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
	}

	public static boolean isCPF(String cpf) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11)) {
			return false;
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (cpf.charAt(i) - 48);
				sm += (num * peso);
				peso -= 1;
			}

			r = 11 - (sm % 11);
			dig10 = '0';
			if ((r != 10) && (r != 11)) {
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico
			}

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm += (num * peso);
				peso -= 1;
			}

			r = 11 - (sm % 11);
			dig11 = '0';
			if ((r != 10) && (r != 11)) {
				dig11 = (char) (r + 48);
			}

			// Verifica se os digitos calculados conferem com os digitos informados.
			return ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)));
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

}
