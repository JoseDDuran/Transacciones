/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.tienda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import pe.com.tienda.conexion.Conexion;

/**
 *
 * @author Sistema
 */
public class PedidoDAO {
    public static boolean insertOrder(int idpedido, Date fecha, double total, int idempleado, int idcliente){
        Connection cn = Conexion.abrir();
        String sql = "INSERT INTO pedido_encabezado (idpedido,fecha,total,idempleado,idcliente) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idpedido);
            ps.setDate(2, fecha);
            ps.setDouble(3, total);
            ps.setInt(4, idempleado);
            ps.setInt(5, idcliente);
            ps.executeUpdate();
            cn.close();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }
    
    public static boolean insertDetailOrder(int idarticulo, int idpedido, double precio, int cantidad, double subtotal){
        Connection cn = Conexion.abrir();
        String sql = "INSERT INTO pedido_detalle (idarticulo,idpedido,precio,cantidad,subtotal) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idarticulo);
            ps.setInt(2, idpedido);
            ps.setDouble(3, precio);
            ps.setInt(4, cantidad);
            ps.setDouble(5, subtotal);
            ps.executeUpdate();
            cn.close();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }
}
