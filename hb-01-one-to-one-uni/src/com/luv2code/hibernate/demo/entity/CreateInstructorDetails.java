package com.luv2code.hibernate.demo.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class CreateInstructorDetails {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{   int theId;
		    session.beginTransaction();
			Instructor tempInstructor = new Instructor("Cold","Play","Robert10@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("PoetryExpress","Poetry");
			tempInstructorDetail.getInstructor();
			theId = tempInstructor.getId();
			if(theId != 0)
			{
			InstructorDetail tempInstructor1 = session.get(InstructorDetail.class,theId);
			System.out.println("Printing tempInstructor1"+tempInstructor1.getInstructor());
			}
			
			else {
				System.out.println("No data fouund");
			    }
			
		    
			
			
			session.save(tempInstructor);
			
			System.out.println("printing the value"+tempInstructor);
			
			
			
		
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
			
		}

	}

}
