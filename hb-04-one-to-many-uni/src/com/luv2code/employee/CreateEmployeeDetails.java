package com.luv2code.employee;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class CreateEmployeeDetails {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{
			System.out.println("Inserting into Table Employee");
			
			Employee emp1 = new Employee("Pragya","Verma","xyz","30k","Lucknow");
			Employee emp2 = new Employee("Raghav","Rana","abc","30k","Noida");
			Employee emp3 = new Employee("Abhinav","Chaudhary","Unknown","Roxie","NCR");
			Employee emp4 = new Employee("Ross","geller","Dianasour","50k","NewYork");
			Employee emp5 = new Employee("Rachel","Green","Ralph Lauren","30k","Paris");
			Employee emp6 = new Employee("Chandler","Bing","GolMan Sacks","66","USA");
			session.beginTransaction();
			
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			session.save(emp5);
			session.save(emp6);
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
			
		}

	}

}
