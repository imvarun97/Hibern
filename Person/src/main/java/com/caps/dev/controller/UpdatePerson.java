package com.caps.dev.controller;
import java.util.Scanner;

import com.caps.dev.beans.Person;
import com.caps.dev.Dao.PersonInterface;
import com.caps.dev.Dao.HibernateImpl;
import com.caps.dev.Dao.JdbcImpl;

public class UpdatePerson {

	public static void main( String[] args )
    {
    	System.out.println("Enter Person Id To Update ");
		System.out.println("-------------------");
		Person person = new Person();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Person id: ");
		person.setPersonId(Integer.parseInt(in.nextLine()));
		
		System.out.println("Enter New EmailId: ");
		person.setEmail(in.nextLine());
		
		PersonInterface impl=new JdbcImpl();
		//DAOimpl impl=new HibernateImpl();
		
		impl.update(person);
		
		System.out.println("EmailId has been Updated..!!!");
		
		
    }
}