package com.caps.dev.controller;
import java.util.Scanner;

import com.caps.dev.beans.Person;
import com.caps.dev.Dao.PersonInterface;
import com.caps.dev.Dao.JdbcImpl;

public class DeletePerson {
	public static void main( String[] args )
    {
    	System.out.println("Enter Person Details To Delete ");
		System.out.println("-------------------");
		Person person = new Person();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Person id: ");
		person.setPersonId(Integer.parseInt(in.nextLine()));
		
		PersonInterface impl=new JdbcImpl();
		//DAOimpl impl=new HibernateImpl();
		
		impl.delete(person);
		System.out.println("Person Data Deleted Successfully...!!!");
		
    }
}