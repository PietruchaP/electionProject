package hibernate.Operation;

import hibernate.model.Elections;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ElectionsOperation {
	Configuration config;
	SessionFactory factory;
	Session session;
	Transaction tx;
	
	public void getConfig(){
		config = new Configuration().configure();
		factory = buildSessionFactory();
		session = factory.openSession();
	}
		private static SessionFactory buildSessionFactory(){		
			try{
				Configuration configuration = new Configuration().configure();
		        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		        serviceRegistryBuilder.applySettings(configuration.getProperties());
		        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		        return configuration.buildSessionFactory(serviceRegistry);
			}
			catch(Throwable ex){			
				System.err.println("Initial SessionFactory creation failed."+ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		
		public void insertElection(Date date, String type){
			System.out.println("Insert Election: ");		
			try{
				getConfig();
				
				Elections election = new Elections();
				election.setElection_date(date);
				election.setType(type);
				tx = session.beginTransaction();
				int result = (Integer)session.save(election); //give primary key
				
				System.out.println("Election has been inserted with ID: "+result);			
				
				tx.commit();			
				session.close();				
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			System.out.println("Election type: " + type );
			System.out.println("Election date: " + date );
		}
		
		public void retrieveElection(int id){
			System.out.println("Retrive election : "+id);
			
			try{
				getConfig();
				tx = session.beginTransaction();
				
				Elections election = (Elections)session.get(Elections.class,id);
				
				if(election!=null){
					System.out.println("Printing election:");
					System.out.println("election id: "+election.getId());
					System.out.println("election date: "+election.getElection_date());
					System.out.println("election type: " +election.getType());
				}
				else{
					System.out.println("No election with this id");
				}	
				session.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		public void updateElection(int id, Date date, String type){
			System.out.println("Updating election: "+id);
			System.out.println("election: " + date + " " + type);
			
			try{
				getConfig();

				Elections election = (Elections)session.get(Elections.class,id);
				
				if(election!=null){
					election.setId(id);
					election.setElection_date(date);
					election.setType(type);
					tx = session.beginTransaction();
					session.update(election);
					
					System.out.println("Printing election:");
					System.out.println("Election with id: "+election.getId()+" was updated");
					System.out.println("Election date: "+election.getElection_date() + "\nElection type: "+ election.getType());
					
					tx.commit();
					
					session.close();
				}
				else
					System.out.println("No election with this id");
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		}
		public void deleteElection(int id){
			System.out.println("Deleting election: "+id);
			try{
				getConfig();
				
				tx = session.beginTransaction();
				
				Elections election = new Elections();
				election.setId(id);
				
				session.delete(election);
				tx.commit();
				
				session.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}
