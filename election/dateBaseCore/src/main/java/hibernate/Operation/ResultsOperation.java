package hibernate.Operation;

import hibernate.model.Candidates;
import hibernate.model.Elections;
import hibernate.model.Results;
import hibernate.model.Voters;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ResultsOperation {
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
		
		public void insertResults(String firstname, String surname, int zipId){
			System.out.println("Insert Result: ");		
			try{
				getConfig();
				
				Results results = new Results();
				Candidates candidates = new Candidates();
				Elections elections = new Elections();
				Voters voters = new Voters();
				
				results.setCandidates(candidates);
				results.setElections(elections);
				results.setVoters(voters);
				tx = session.beginTransaction();
				int result = (Integer)session.save(results); //give primary key
				
				System.out.println("Candidate has been inserted with ID: "+result);			
				
				tx.commit();			
				session.close();				
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			System.out.println("Candidate: " + firstname +" " + surname);
		}
		
}
