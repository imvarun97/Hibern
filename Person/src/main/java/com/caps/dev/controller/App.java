package com.caps.dev.controller;

import java.util.Scanner;

import com.caps.dev.Dao.HibernateImpl;
import com.caps.dev.Dao.JdbcImpl;
import com.caps.dev.Dao.PersonInterface;
import com.caps.dev.beans.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner s=new Scanner(System.in);
    	System.out.println("choose the type of implementation");
    	System.out.println("1.JDBC");
    	System.out.println("2.HIBERNATE");
    	System.out.println("enter your choice");
    	
    	if(s.nextLine().equals("1"))
    	{
        PersonInterface pi=new JdbcImpl();
        
        Person p=new Person();
        
        
        int i=0;
        int c;
        while(i<4)
        {
        	System.out.println("1.Create");
            System.out.println("2.Update");
            System.out.println("3.Search");
            System.out.println("4.Delete");
            System.out.println("enter your choice");
            c=Integer.parseInt(s.next());
        	switch(c)
        	{
        	case 1:
        	{
        		pi.create(p);
        		break;
        	}
        	case 2:
        	{
        		pi.update(p);
        		break;
        	}
        	case 3:{
        		pi.search(p);
        		break;
        	}
        	case 4:{

                pi.delete(p);
                break;
        	}
        	default:System.out.println("Invalid Option");
        	i=5;
        	break;
        	
        	}
        		
        }
    	}
    	else if(s.nextLine().equals("2"))
    	{
    		System.out.println("inside if else");
    	
    		PersonInterface pi=new HibernateImpl();
    		Person p=new Person();

            int i=0;
            int c;
            while(i<4)
            {
            	System.out.println("1.Create");
                System.out.println("2.Update");
                System.out.println("3.Search");
                System.out.println("4.Delete");
                System.out.println("enter your choice");
                c=Integer.parseInt(s.next());
            	switch(c)
            	{
            	case 1:
            	{
            		pi.create(p);
            		break;
            	}
            	case 2:
            	{
            		pi.update(p);
            		break;
            	}
            	case 3:{
            		pi.search(p);
            		break;
            	}
            	case 4:{

                    pi.delete(p);
                    break;
            	}
            	default:System.out.println("Invalid Option");
            	i=5;
            	break;
            	
            	}
            		
            }
    		
    	}
    	
        
    }
        
        
        
    }
