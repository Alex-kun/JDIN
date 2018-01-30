package pac;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NamingException;

public class Funciones {
	public static ArrayList miArray = new ArrayList();
	final static String ruta = "file:///Users/alejandroquiros/Documents/";

	Ventana ventana = new Ventana();

	public static void RutasFicheros(String fich1, String fich2, String fich3) {
		miArray.add(ruta);
		miArray.add(fich1);
		miArray.add(fich2);
		miArray.add(fich3);
		for (int i = 1; i < miArray.size(); i++) {
			System.out.println(miArray.get(i));
		}

	}

	public static void main(String[] args) throws NamingException {

		RutasFicheros(args[0], args[1], args[2]);

		if (args.length < 2) {
			System.out.println("Indique <directorio> <ficheros...> a buscar");
			return;
		}

		// creamos el initial context

		Properties p = new Properties();
		// definimos la clase del driver

		p.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

		p.put(Context.PROVIDER_URL, ruta);
		Context ctx = new InitialContext(p);

		// busca los ficheros dentro del contexto

		for (int i = 1; i < args.length; i++) {
			try {
				ctx.lookup(args[i]);
				System.out.println(args[i] + "  ENCONTRADO!!");
			} catch (NamingException ex) {
				System.out.println(args[i] + "  NO EXISTE");
			}
		}
	}// fin main

}
