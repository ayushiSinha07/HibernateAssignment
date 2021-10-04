package com.ty.Activity.bean.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.Activity.ByIdException;
import com.ty.Activity.Student;
import com.ty.hibernateDemo.Employee;

public class StudentImplementation {
	static EntityManagerFactory factory=null;
	 static EntityManager manager=null;
	static Scanner sc=null;
public static void displayAll() {
	try {
		factory=Persistence.createEntityManagerFactory("student");
		manager=factory.createEntityManager();
		String findAll="from Student";
		Query query=manager.createQuery(findAll);
		List<Student> list= query.getResultList();
		System.out.println(list);
			
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		if(manager!=null)
		{
			manager.close();
		}
	if(factory!=null) {
		factory.close();
	}
}
	

}// close of display method
public  static void  getById()  {
	sc=new Scanner(System.in);
	System.out.println("Enter Rollno of which you want to see detail");
	if(sc.nextInt()<1) {
		throw new ByIdException();
	}
	else
	{
		try {
			factory=Persistence.createEntityManagerFactory("student");
			manager=factory.createEntityManager();
			String findById="from Employee where id=:id";
			Query query=manager.createQuery(findById);
			query.setParameter("id",sc.nextInt());
			Student student=(Student) query.getSingleResult();
			System.out.println("----------");
			System.out.println(student.getRollNo());
			System.out.println(student.getName());
			System.out.println(student.getPhno());
			System.out.println(student.getStandard());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(manager!=null)
			{
				manager.close();
			}
		if(factory!=null) {
			factory.close();
		}
	}
}//close of else block
}//close byId method
public static void getUpdate() {
	boolean exit=false;
	boolean b=false;
	sc=new Scanner(System.in);
	do {
	System.out.println("1.enter Rollno");
	System.out.println("2.Exit");
	System.out.println("Select your choice");
	int a=sc.nextInt();
	switch(a) {
	case 1:{
		{System.out.println("Enter the Rollno you want Update");
		int i=sc.nextInt();
		if(i<1) {
			throw new ByIdException();
		}
		else {
		do {
		System.out.println("Select an option ");
		System.out.println("1.update the name");
		System.out.println("2.update the phone no ");
		System.out.println("3.to exit from update");
		switch(sc.nextInt()) {
		case 1:{
			try {
				factory=Persistence.createEntityManagerFactory("student");
				manager=factory.createEntityManager();

				EntityTransaction transaction=manager.getTransaction();
				transaction.begin();
				String update="update Employee set ename=:name where eid=:id";
				Query query=manager.createQuery(update);
				System.out.println("Enter name");
				
				query.setParameter("name",sc.next());
				
				query.setParameter("id",i);
				
				
				int result=query.executeUpdate(); 
				transaction.commit();
				
			
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(manager!=null)
				{
					manager.close();
				}
			if(factory!=null) {
				factory.close();
			}
		}

		}//close case1
		
		break;
		case 2:{
			try {
				factory=Persistence.createEntityManagerFactory("student");
				manager=factory.createEntityManager();

				EntityTransaction transaction=manager.getTransaction();
				transaction.begin();
				String update="update Employee set phno=:phno where eid=:id";
				Query query=manager.createQuery(update);
				System.out.println("Enter phone number");
				
				query.setParameter("phno",sc.nextLong());
				
				query.setParameter("id",i);
				
				
				int result=query.executeUpdate(); 
				transaction.commit();
				
			
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(manager!=null)
				{
					manager.close();
				}
			if(factory!=null) {
				factory.close();
			}
		}
			
		}
		break;
		//close case 2
		case 3:{System.out.println("Do you want to continue the process");
				System.out.println("1.NO");
				System.out.println("2.YES");
				if(sc.nextInt()==1) {
					exit=true;
				}
			
		}
		break;
		default:System.out.println("Enter valid choice");
		
		}//close of Switch block
		
		}// close of do loop
		while(!exit);
		}// close of else
		}
		}
	break;
	case 2:{
		b=true;
	}
	
	}
	
	}
	while(!b);
}//close getUpdate method
public static void getDelete() {
	sc=new Scanner(System.in);
	System.out.println("Enter ID");
	int x=sc.nextInt();
	if(x<1) {
		throw new ByIdException();
	}
	else {
	try {
		factory=Persistence.createEntityManagerFactory("emp");
		manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		String delete="delete from Employee where eid=:id";
		Query query=manager.createQuery(delete);
		
		
		query.setParameter("id",x);
		
		
		int result=query.executeUpdate(); 
		transaction.commit();
		}
	 catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			sc.close();
			factory.close();
			manager.close();
					}
	}
	

	
}



}

