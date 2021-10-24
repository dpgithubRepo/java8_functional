package functionalintefaceExamples;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateMain {
 public static void main(String[] args) {
	System.out.println(validateMail("hello@gmail.com"));
	System.out.println(validateMail("hello@gmail"));
	System.out.println(validateMail("hellogmail.com"));
	
	Predicate<String> mailValidator = mailId -> mailId.contains("@") && mailId.endsWith(".com");
	
	//using predicate
	System.out.println("//predicates");
	System.out.println(mailValidator.test("hello@gmail.com"));
	System.out.println(mailValidator.test("hello@gmail"));
	System.out.println(mailValidator.test("hellogmail.com"));
	
	 
	BiPredicate<String, String> validatePrimarySecMail = (m1,m2)->( (m1.contains("@") && m1.endsWith(".com")) || (m2.contains("@") && m2.endsWith(".com")) );
	System.out.println("//bipredicates");
	System.out.println(validatePrimarySecMail.test("hello@", "hello@gmail.com"));
	System.out.println(validatePrimarySecMail.test("hello@", "hello@gmail"));
	
	
	
	Predicate<String> mobValidator = mob -> mob.length() >=8;
	Predicate<String> phoneValidator = phone -> phone.startsWith("01");
	
	//check if both mob and phone are valid (has 8 or more digits AND starts with 01)
	System.out.println(mobValidator.and(phoneValidator).test("01233"));
	
	// check if the passed number is either mob or phone
	System.out.println(mobValidator.or(phoneValidator).test("01223"));
}
 
 static boolean validateMail(String mailId) {
	 
	 return mailId.contains("@") && mailId.endsWith(".com");
 }
}
