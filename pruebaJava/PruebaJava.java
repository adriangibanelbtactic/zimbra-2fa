/*

*/

package com.btactic.pruebajava;

/*import java.io.IOException;*/
import br.com.sampaio.Utils;
import java.util.Date;
import com.zimbra.cs.ldap.LdapDateUtil;

public class PruebaJava {

	private PruebaJava() {
	}
	public static void main(String[] args) {
		System.out.println("Esto es una prueba");
		try {
			Utils utils = new Utils();
			String totpString = utils.getTOTPCode("IQ3SY3QTMFUFGWAS");
			System.out.println("TOTP: " + totpString);
			String hexKeyString = utils.getHexKey("IQ3SY3QTMFUFGWAS");
			System.out.println("HexKey: " + hexKeyString);
			String generateSecretKeyString = utils.generateSecretKey();
			System.out.println("NewSecretKey: " + generateSecretKeyString);
			String newMethodHexKeyString = utils.getNewHexData("IQ3SY3QTMFUFGWAS");
			System.out.println("newMethodHexKey: " + newMethodHexKeyString);
			String newMySecret = utils.getMySecret();
			System.out.println("newMySecret: " + newMySecret);

			String[] mySecretTokens = newMySecret.split("\\|");
			String mySecret1 = mySecretTokens[0];
			String mySecret2 = mySecretTokens[1];
			System.out.println("newMySecret0: " + mySecret1);
			System.out.println("newMySecret1: " + mySecret2);

			Date myDate =  LdapDateUtil.parseGeneralizedTime(mySecret2);
			System.out.println("mySecret DATE: " + myDate.toString());

			String toBeSaved = String.format("%s|%s", mySecret1, mySecret2);
			System.out.println("toBeSaved: " + toBeSaved);



		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
