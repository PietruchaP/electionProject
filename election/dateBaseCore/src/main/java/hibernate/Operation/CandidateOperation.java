package hibernate.Operation;

import hibernate.model.Candidates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CandidateOperation {
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
		
		public void insertCandidate(String firstname, String surname, int zipId){
			System.out.println("Insert Candidate: ");		
			try{
				getConfig();
				
				Candidates candidate = new Candidates();
				candidate.setFirstname(firstname);
				candidate.setSurname(surname);
			//	candidate.setZip_codes_id(zipId);
				tx = session.beginTransaction();
				int result = (Integer)session.save(candidate); //give primary key
				
				System.out.println("Candidate has been inserted with ID: "+result);			
				
				tx.commit();			
				session.close();				
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			System.out.println("Candidate: " + firstname +" " + surname);
		}
		
		public void retrieveCandidate(int id){
			System.out.println("Retrive voter : "+id);
			
			try{
				getConfig();
				tx = session.beginTransaction();
				
				Candidates candidate = (Candidates)session.get(Candidates.class,id);
				
				if(candidate!=null){
					System.out.println("Printing Candidate:");
					System.out.println("Candidate id: "+candidate.getId());
					System.out.println("Firstname: "+candidate.getFirstname());
					System.out.println("Surname: " +candidate.getSurname());
				}
				else{
					System.out.println("No candidate with this id");
				}	
				session.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		public void updateCandidate(int id, String firstname, String surname,  int zipId){
			System.out.println("Updating candidate: "+id);
			System.out.println("candidate: " + firstname + " " + surname);
			
			try{
				getConfig();

				Candidates candidate = (Candidates)session.get(Candidates.class,id);
				
				if(candidate!=null){
					candidate.setId(id);
					candidate.setFirstname(firstname);
					candidate.setSurname(surname);
			//		candidate.setZip_codes_id(zipId);
					tx = session.beginTransaction();
					session.update(candidate);
					
					System.out.println("Printing candidate:");
					System.out.println("Candidate with id: "+candidate.getId()+" was updated");
					System.out.println("candidate name: "+candidate.getFirstname() + " "+ candidate.getSurname());
					
					tx.commit();
					
					session.close();
				}
				else
					System.out.println("No candidate with this id");
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		}
		public void deleteCandidate(int id){
			System.out.println("Deleting candidate: "+id);
			try{
				getConfig();
				
				tx = session.beginTransaction();
				
				Candidates candidate = new Candidates();
				candidate.setId(id);
				
				session.delete(candidate);
				tx.commit();
				
				session.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}
