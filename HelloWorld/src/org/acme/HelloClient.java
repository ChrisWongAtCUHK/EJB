package org.acme;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;
public class HelloClient{
        public static void main(String[] args) throws Exception{ Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.RemoteInitialContextFactory"); 
			props.put(Context.PROVIDER_URL,"ejbd://127.0.0.1:4201"); 
			Context ctx = new InitialContext(props); 
			Object ref = ctx.lookup("HelloBeanRemote"); 
			Hello h = (Hello)PortableRemoteObject.narrow(ref,Hello.class); 
			String result = h.sayHello(); System.out.println(result); 
		} 
}