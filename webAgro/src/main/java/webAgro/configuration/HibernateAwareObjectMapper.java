package webAgro.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8307282011874787662L;

	public HibernateAwareObjectMapper(){
		System.out.println("spicio me u maper");
		Hibernate4Module module=new Hibernate4Module();
        registerModule(module);

	}
}
