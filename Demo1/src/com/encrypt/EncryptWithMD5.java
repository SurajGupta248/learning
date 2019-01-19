package com.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptWithMD5 {
	public static MessageDigest md;
	public static String EncryptWithMD5(String pass){
		
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passByte= pass.getBytes();
			md.reset();
			byte[] digest=md.digest(passByte);
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<digest.length;i++)
				sb.append(Integer.toHexString(0xff & digest[i]));
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		String pass="suraj";
		String pass1="suraj";
		System.out.println("Entered Password : "+pass);
		String encryptedPass1=EncryptWithMD5(pass);
		System.out.println("Encrypted Password : "+encryptedPass1);
		String encryptedPass2=EncryptWithMD5(pass1);
		System.out.println("Encrypted Password : "+encryptedPass2);
		if(encryptedPass1.equals(encryptedPass2))
			System.out.println("same");
		else
			System.out.println("not same");
		
	}

}
