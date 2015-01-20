package starterKids.votingProgram;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import starterKids.votingProgram.Class.PeselVerify;

public class PeselVerifyTest {

	@Test
	public void test() {
	}
	
	@Test
	public void checkControlSumNumber(){
		PeselVerify pesel = new PeselVerify("90122301778");
		int test = pesel.countControlSum();
		assertEquals(8, test);
	}
	
	@Test
	public void checkIfPeselCorrect(){
		PeselVerify pesel = new PeselVerify("90122301778");
		boolean correct = pesel.isControlSumCorrect();
		assertEquals(true, correct);
	}
	
	@Test
	public void checkIfPossibleToGetDateFromPesel(){
		PeselVerify pesel = new PeselVerify("90122301778");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try{
			date1 = fmt.parse(new String("1990-12-23"));
		}
		catch(ParseException exception)
		{
			System.out.println("not possible to get date From Pesel");
		}
		 Date date2 = pesel.getDateOfBirth();
		System.out.println(date2);	
		assertEquals(date1,date2);		
	}
	
	@Test
	public void CurrentDateIsAfterBirth(){
		PeselVerify pesel = new PeselVerify("90122301778");
		boolean test = pesel.isDateAfterBirthDate();
		assertEquals(true, test);
	}
	@Test
	public void CurrentDateIsBeforeBirth(){
		PeselVerify pesel = new PeselVerify("30622301778");
		boolean test = pesel.isDateAfterBirthDate();
		assertEquals(false, test);
	}
	@Test
	public void TypeOfSexMan(){
		PeselVerify pesel = new PeselVerify("90122301778");
		String test = pesel.getSexType();
		assertEquals("man", test);
	}
	@Test
	public void TypeOfSexWoman(){
		PeselVerify pesel = new PeselVerify("90122301788");
		String test = pesel.getSexType();
		assertEquals("woman", test);
	}
	@Test 
	public void haveNotEnoughtAge(){
		PeselVerify pesel = new PeselVerify("9912201778");
		boolean test = pesel.isVoterMature();
		assertEquals(false, test);
	}
	@Test
	public void checkDateIfReal(){
		PeselVerify pesel = new PeselVerify("90023059196");
		boolean test = pesel.isPeselCorrect();
		assertEquals(false, test);
	}
	@Test
	public void checkPrintControValueMethod(){
		PeselVerify pesel = new PeselVerify("90122301778");
		pesel.countControlSum();
		int controlPeselValue = pesel.getControlValue();
		String Value = Integer.toString(controlPeselValue);
	}
}
