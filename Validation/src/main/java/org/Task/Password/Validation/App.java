package org.Task.Password.Validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main(String[] args) {

		String[] strAr1 = new String[] { "P@sswORDoqq", "20passWORD20", "PASS6word" };

		String checkString = "4dro6";
		List<String> result = checkPassword(strAr1, checkString);

		System.out.println(result);
	}

	private static List<String> checkPassword(String[] strAr1, String checkString) {
		char[] chckString = checkString.toCharArray();
		List<String> result = new ArrayList<String>();
		for (String str : strAr1) {
			int upper = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch >= 'A' && ch <= 'Z')
					upper++;
			}
			boolean chekChar = true;
			if (upper == Integer.parseInt(String.valueOf(chckString[0]))) {
				int chekPoint = 1;

				for (int i = str.length() - 1; i > (str.length() - 4); i--) {
					char ch = str.charAt(i);
					for (int j = chekPoint; j < checkString.length(); j++) {
						char ch1 = checkString.charAt(j);
						if (ch1 == ch && chekChar) {
							chekChar = true;
						} else {
							chekChar = false;
						}

						chekPoint = j + 1;
						break;
					}
				}

			}

			if (chekChar) {
				// Sum of all int in the password
				int counter = 0;
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
						counter += (str.charAt(i) - '0');
				}
				if (counter == Integer.parseInt(String.valueOf(chckString[chckString.length - 1]))) {
					result.add(str);
				}

			}

		}

		return result;
	}

}
