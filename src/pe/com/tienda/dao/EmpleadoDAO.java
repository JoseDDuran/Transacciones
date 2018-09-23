package pe.com.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.com.tienda.bean.Empleado;
import pe.com.tienda.conexion.Conexion;

public class EmpleadoDAO {
//listar todos los empleados
    public static ArrayList<Empleado> listar() {
        // arreglo cuyos elementos son objetos tipo empleado
        ArrayList<Empleado> empleados = new ArrayList<>();
        //conexion a la base de datos
        Connection cn = Conexion.abrir();
        //varible empleado
        Empleado emp;
        try {
            //objeto para ejecutar instrucion sql
            PreparedStatement ps = cn.prepareStatement("select*from empleado");
            //ejecutaR y almacenar resultado en un resultset
            ResultSet rs= ps.executeQuery();
            //leer resultset
            while(rs.next()){
                emp=new Empleado();
                //emp.setIdemp(rs.getInt("idempleado"));
                emp.setIdemp(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setPaterno(rs.getString(3));
                emp.setMaterno(rs.getString(4));
                emp.setCargo(rs.getString(5));
                //asignar objeto empleado al arreglo
                empleados.add(emp);
            }
            //cerrar objetos
             rs.close();
             ps.close();
             cn.close();   
        } catch (Exception e) {
            System.out.println("Error en listar:"+e);
        }
        return empleados;
    }
}
