package com.luv2code.hibernate.demo.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class GetInstructorDetails {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{   session.beginTransaction();
		   
		int theId = 4;
		
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);
		System.out.println("Print tempInstructorDetail: "+tempInstructorDetail);
		System.out.println("Get associated Instructor: " +tempInstructorDetail.getInstructor());	
		
		tempInstructorDetail.getInstructor().setInstructordetail(null);//setting instructor_detail_id to null
		System.out.println("Deleted tempInstructorDetail:");
		session.delete(tempInstructorDetail);
		session.getTransaction().commit();
			
		}
		
		/*catch(Exception exc) {
			exc.printStackTrace();
		}*/
		
		finally {
			
			//session.close();
			factory.close();
			
		}

	}

}
