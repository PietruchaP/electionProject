package hibernate.Operation;

import hibernate.model.ZipCodes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Zip_CodesOperation{

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
	
	public String retrieveZip(int id){
		String retrieve = null;
		try{
			getConfig();
			tx = session.beginTransaction();
			
			ZipCodes zip = (ZipCodes)session.get(ZipCodes.class,id);
			
			if(zip!=null){
				retrieve = zip.getZipCodes();
			}
			else{
				System.out.println("No zipCode with this id");
			}	
			session.close();
			return retrieve;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null; 
	}
		
	public void insertZipCode(String zipCode){
		System.out.println("Insert zip code");		
		try{
			getConfig();
			
			ZipCodes zip = new ZipCodes();
			zip.setZipCodes(zipCode);
			
			tx = session.beginTransaction();
			int result = (Integer)session.save(zip); //give primary key
			
			System.out.println("zip code has been inserted with ID: "+result);			
			
			tx.commit();			
			session.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		System.out.println("zip code:" + zipCode);
	}
	
	public void retrieveZipCode(int id){
		System.out.println("Retrive zip code : "+id);
		
		try{
			getConfig();
			tx = session.beginTransaction();
			
			ZipCodes zip = (ZipCodes)session.get(ZipCodes.class,id);
			
			if(zip!=null){
				System.out.println("Printing zip code:");
				System.out.println("zip code id: "+zip.getId());
				System.out.println("zip code: "+zip.getZipCodes());
			}
			else{
				System.out.println("No zip code with this id");
			}	
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void updateZipCode(int id, String zipCode){
		System.out.println("Updating zip code: "+id);
		System.out.println("zip code: "+zipCode);
		
		try{
			getConfig();

			ZipCodes zip = (ZipCodes)session.get(ZipCodes.class,id);
			
			if(zip!=null){
				zip.setId(id);
				zip.setZipCodes(zipCode);
				
				tx = session.beginTransaction();
				session.update(zip);
				
				System.out.println("Printing Zip code:");
				System.out.println("Zip Code with id: "+zip.getId()+" was updated");
				System.out.println("zip Code: "+zip.getZipCodes());
				
				tx.commit();
				
				session.close();
			}
			else
				System.out.println("No zip code with this id");
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}
	public void deleteZipCode(int id){
		System.out.println("Deleting zip code: "+id);
		try{
			getConfig();
			
			tx = session.beginTransaction();
			
			ZipCodes zip = new ZipCodes();
			zip.setId(id);
			
			session.delete(zip);
			tx.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public static org.w3c.dom.Document parseConfiguration(String resourcePath) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//Validate DTD only on development environments
		factory.setValidating(false); // Don't validate DTD
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(builder.getClass().getResourceAsStream(resourcePath));
		} 

}
