package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import bbdd.Conexion;
import beans.Cliente;
import beans.Producto;

public class Compra {
	
	public ArrayList<Cliente> refrescarCompra(){
		// TODO: Hacer la peticion a BBDD para recoger los alumnos
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet resultado = Conexion.ejecutarSentencia("SELECT * FROM CLIENTES;");
		
		try {
			while(resultado.next()) {
				int id_clientes = resultado.getInt("id_clientes");
				String nombre = resultado.getString("nombre");
				String dni = resultado.getString("dni");
				String direccion = resultado.getString("direccion");
				int telefono = resultado.getInt("telefono");
				String correo = resultado.getString("correo");
				clientes.add(new Cliente(id_clientes, nombre, dni, direccion, telefono, correo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	//RECOGER DATOS DE PRODUCTOS Y CLIENTES
	public void recogerDatos(Producto producto, Cliente cliente) {
		producto.getId_prod();
		producto.getNombre();
		producto.getPrecio_venta();
		producto.getPrecio_compra();
		producto.getCantidad();
		
	}
	
	//FICHERO
	public void crearFichero() {
		File fichero = new File ("factura.txt");
		try {
			  // A partir del objeto File creamos el fichero f�sicamente
			  if (fichero.createNewFile())
			    System.out.println("El fichero se ha creado correctamente");
			  else
			    System.out.println("No ha podido ser creado el fichero");
			} catch (IOException ioe) {
			  ioe.printStackTrace();
			}
	}
	
	public void borrarFichero() {
		/*File fichero = new File("factura.txt");
		
		//SALDR� MENSAJE POR TERMINAL
		if (fichero.delete())
			   System.out.println("El fichero ha sido borrado satisfactoriamente");
			else
			   System.out.println("El fichero no puede ser borrado");*/
	}
	
	public void escribirFichero() {
		FileWriter fichero = null;
        try {
            // Crear el objeto que va a escribir el fichero
            fichero = new FileWriter("factura.txt");

            fichero.write("#" + " PIXELADA"+"\n\n\n\n");
            fichero.write("-------------------------");

            /*fichero.write("####" +factura.getID()+ "\n\n");
                       
            fichero.write("###" +cliente1.getNombre()+"\\n\\n");
            fichero.write("###" +cliente1.getDni()+"\\n\\n");
            fichero.write("###" +cliente1.getDireccion()+"\\n\\n");
            fichero.write("###" +cliente1.getTelefono()+"\\n\\n");
            fichero.write("###" +cliente1.getCorreo()+"\\n\\n");*/
            

            fichero.write("+cliente.getCorreo()+\n\n");

                    //Developer: Your Name
                    //E-Mail: you-email@domain.com
                    //Skype: your.skype.address
                    //Phone: +1000-000-0000

            fichero.write("###" + " SUMARIO"+"\n\n\n\n");

            fichero.write("Producto                       | Cantidad | Precio venta  | Precio compra");
            fichero.write("------------------------------ | ---------| ---------     | ---------");
            fichero.write("producto.getNombre()           | 2        | $80.00        | $160.00");
                
            fichero.write("*Sub Total*: $200.00 / **Grand Total**: $200.00 (no tax\n\n\n\n");

            fichero.write("## T�rminos\n\n");

            fichero.write("+ Los pagos deben hacerse con el nombre del cliente\n\n");
            fichero.write("El total debe pagarse en un plazo maximo de 30 dias\n\n\n\n");
            fichero.write(" ### Payments");

            fichero.write("        Fecha      | M�todo de pago    | Total");
            fichero.write("------------------ | ----------------- | ------");
            fichero.write("factura.getDate() +  | Paypal     | $100.00");
            fichero.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
	
	
	public void leerFichero() {
		File fichero = new File("/factura.txt");
        int cont = 0;
        try{
            // Asocio el scanner con el fichero
            Scanner lector = new Scanner(fichero);

            // *** Lectura *** //
            while(lector.hasNextLine()){
                cont += 1;
                String linea = lector.nextLine();
                //if(linea.equals("tercera")){
                    System.out.println( cont +"\t"+ linea);
                //}
            }

            // ************** //
            
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        System.out.println("Fin!");
	}
	
}
