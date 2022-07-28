package authenticationsystem;
import java.security.MessageDigest;

//Code provided to hash password
public class MD5Digest {

	public static String hashPassword(String original) throws Exception {
      
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
      StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}

		return sb.toString();
	}

}