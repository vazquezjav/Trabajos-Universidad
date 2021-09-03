package Controlador;

public class Gestion {
	 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Conexion co = new Conexion();
      Consulta con = new Consulta();
        
        co.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        co.setUsername("hr");
        co.setPassword("hr");
        
        co.Conectar();
        if(co.getConexion() != null){
            System.out.println("La base se ha conectado exitosamente!");
//            con.insertarRegion(co, 9, "Mar");
//            con.borrarRegion(co, 8);
//            con.borrarPais(co, "Zz");
//            con.borrarLocalidad(co, 7474);
//            con.insertarPais(co, "Zr", "ZWZZZZZ", 4);
//            con.insertarLocalidad(co, 1234, "duma", "15", "cuenaa", "azuay", "Zz");
        }
    }
}
