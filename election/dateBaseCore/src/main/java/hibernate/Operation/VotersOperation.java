package hibernate.Operation;

import hibernate.model.Voters;
import hibernate.model.ZipCodes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class VotersOperation {
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
		
		public void insertVoter(String pesel, int zipId){
			System.out.println("Insert Voter: ");		
			try{
				getConfig();
				
				Voters voter = new Voters();
				voter.setPesel(pesel);
		//		voter.setZip_codes_id(zipId);
				tx = session.beginTransaction();
				int result = (Integer)session.save(voter); //give primary key
				
				System.out.println("pesel has been inserted with ID: "+result);			
				
				tx.commit();			
				session.close();				
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			System.out.println("pesel: " + pesel);
		}
		
		public void retrieveVoter(int id){
			System.out.println("Retrive voter : "+id);
			
			try{
				getConfig();
				tx = session.beginTransaction();
				
				Voters voter = (Voters)session.get(ZipCodes.class,id);
				
				if(voter!=null){
					System.out.println("Printing Voter:");
					System.out.println("Voter id: "+voter.getId());
					System.out.println("Pesel: "+voter.getPesel());
				}
				else{
					System.out.println("No voter with this id");
				}	
				session.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		public void updateVoter(int id, String pesel,  int zipId){
			System.out.println("Updating voter: "+id);
			System.out.println("voter: " + pesel);
			
			try{
				getConfig();

				Voters voter = (Voters)session.get(ZipCodes.class,id);
				
				if(voter!=null){
					voter.setId(id);
					voter.setPesel(pesel);
			//		voter.setZip_codes_id(zipId);
					tx = session.beginTransaction();
					session.update(voter);
					
					System.out.println("Printing voter:");
					System.out.println("Voter with id: "+voter.getId()+" was updated");
					System.out.println("Voter pesel: "+voter.getPesel());
					
					tx.commit();
					
					session.close();
				}
				else
					System.out.println("No voter with this id");
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		}
		public void deleteVoter(int id){
			System.out.println("Deleting voter: "+id);
			try{
				getConfig();
				
				tx = session.beginTransaction();
				
				Voters voter = new Voters();
				voter.setId(id);
				
				session.delete(voter);
				tx.commit();
				
				session.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}
