
package Controlador;

import Modelo.*;
import Modelo.Sucursal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ComboboxSucursal {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    public ComboboxSucursal() {
    }
    public ArrayList getlistaSucursales(){
        System.out.println("Funcion getlistaSucursales()"); 
        ArrayList mListaSucursales = new ArrayList();
        Sucursal sucursal = null;
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT idSucursal, nombreSucursal FROM sucursal; ");
            while(rs.next()){
                sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombresucursal(rs.getString("nombreSucursal"));
                mListaSucursales.add(sucursal);
                
            }
                
        }catch(SQLException e){
            System.out.println(e);
            
        }
        return mListaSucursales;
        
    }
            
}
