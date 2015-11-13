package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Date dDate = null;
		try {
			dDate = new SimpleDateFormat("yyyy-MM-dd").parse("1995-04-25");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		per1 = new PersonDomainModel();
		per1.setFirstName("Nihar");
		per1.setLastName("Junagade");
		per1.setBirthday(dDate);
		per1.setCity("Bear");
		per1.setPostalCode(19701);
		per1.setStreet("47 Forsythia Lane");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel p;	
		PersonDAL.deletePerson(per1.getPersonID());
		p = PersonDAL.getPerson(per1.getPersonID());
		assertNull("The Person should not be in the database", per);		
	}

	@Test
	public void test() {
//		PersonDomainModel p = new PersonDomainModel("Nihar", "Junagade", "01 Wall Street", 10005, "New York", new LocalDate(1995, 04, 25));
		PersonDomainModel p = new PersonDomainModel();
		p.setFirstName("Nihar");
		p.setLastName("Junagade");
		p.setStreet("01 Wall Street");
		p.setPostalCode(10005);
		p.setCity("New York");
		p.setBirthday(LocalDate.of(1995, Month.APRIL, 25));
		p.setPersonID(UUID.randomUUID());
		
		p.getFirstName();
		p.getLastName();
		p.getStreet();
		p.getPostalCode();
		p.getCity();
		p.getBirthday();
		p.getPersonID();
		
		System.out.println(p.getFirstName());
		System.out.println(p.getLastName());
		System.out.println(p.getStreet());
		System.out.println(p.getPostalCode());
		System.out.println(p.getCity());
		System.out.println(p.getBirthday());
		System.out.println(p.getPersonID());
		
		assertEquals(p.getFirstName(), "Nihar");
		assertEquals(p.getLastName(), "Junagade");
		assertEquals(p.getStreet(), "01 Wall Street");
		assertEquals(p.getPostalCode(), 10005);
		assertEquals(p.getCity(), "New York");
		assertEquals(p.getBirthday(), LocalDate.of(1995, Month.APRIL, 25));
	}
	
	@Test
	public void AddPersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(per1.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);		
		PersonDAL.addPerson(per1);	
		
		per = PersonDAL.getPerson(per1.getPersonID());
		System.out.println(per1.getPersonID() + " found");
		assertNotNull("The Person should have been added to the database", per);
	}

}
