


import java.sql.*;
import java.sql.ResultSet;




public class ConsultaPostgre {
    
        
    
    
void  test(String Dato){
   
     Connection BaseDatos = null;
    Statement st = null;
  
    //Donde se localiza la base de datos
    String url="jdbc:postgresql://192.168.1.33:5432/adverp";
  
    //Credenciales de la base de datos
    String usuario="postgres";
    String contrasena="aaaa";
     
    
        try {
        //Conexion con la base de datos
        BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
  
       
        st = BaseDatos.createStatement();
      
       String consulta = "SELECT * FROM gen.contactocliente where codcli='" + Dato + "'";
        
        PreparedStatement ps = null;
        ps = BaseDatos.prepareStatement(consulta);
       
       // ps.setString(1,Dato);
        
        try (ResultSet rs = ps.executeQuery()) {
           
         
            while    ( rs.next() ) {
              String  email =rs.getString("email");
              // String email= rs.getString("email");
                System.out.println( "Correo : " + email ); 
                Inicio.TxtCorreo.setText(email);
                
            }
        }
        st.close();
        BaseDatos.close();
        
    } catch (SQLException e) {
        System.err.println( e.getMessage() );
        }
       
   }
  
    
}

//}
