package com.caps.dev.controller;
import java.util.Scanner;

import com.caps.dev.beans.Person;
import com.caps.dev.Dao.PersonInterface;
import com.caps.dev.Dao.HibernateImpl;

public class SearchPerson {
	public static void main( String[] args )
    {
    	System.out.println("Enter Person Id To See Details ");
		System.out.println("-------------------");
		Person person = new Person();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Person id: ");
		person.setPersonId(Integer.parseInt(in.nextLine()));
		
		//DAOimpl impl=new JDBCimpl();
		PersonInterface impl=new HibernateImpl();
		
		impl.search(person);
		
		
    }
}