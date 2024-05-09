package model;

public class method {

	public static void main(String[] args) {

		String s= "Hello";
		String s1 = new String(" World");
		String s2 = "HELLO";
//		s+=s1;
//		System.out.println(s);
//		System.out.println(s.length());
//		System.out.println(s.equals(s2));
//		System.out.println(s.equalsIgnoreCase(s2));
//		System.out.println(s.indexOf('e'));
//		System.out.println(s.isBlank());
//		System.out.println(s.isEmpty());
//		System.out.println(s.charAt(3));
//		System.out.println(s.codePointAt(0));
//		System.out.println(s.codePointBefore(2));
//		System.out.println(s.codePointCount(0, 5));
//		System.out.println(s.compareToIgnoreCase(s2));
//		System.out.println(s.concat(s1));
//		System.out.println(s.contains(s2));
		System.out.println(s1.replace(s2, s));
	}

}
