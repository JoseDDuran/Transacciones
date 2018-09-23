package pe.com.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.com.tienda.bean.Cliente;
import pe.com.tienda.bean.Empleado;
import pe.com.tienda.conexion.Conexion;

/**
 *
 * @author Jose Duran
 */
public class ClienteDAO {
    public static Cliente getClientByNameAndId(String name, int id){
        Connection cn = Conexion.abrir();
        Cliente client = null;
        try {
            String sql = "SELECT * FROM cliente WHERE idcliente = ? AND nombres like ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name+ "%");
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                client = new Cliente();
                //emp.setIdemp(rs.getInt("idempleado"));
                client.setNombres(rs.getString("nombres"));
                client.setApellidos(rs.getString("apellidos"));
                client.setEmail(rs.getString("email"));
                client.setIdcliente(rs.getInt("idcliente"));
            }
            //cerrar objetos
             rs.close();
             ps.close();
             cn.close();  
             return client;
        } catch (Exception e) {
            System.out.println("Error en listar:"+e);
            return null;
        }
      
    } 
}
