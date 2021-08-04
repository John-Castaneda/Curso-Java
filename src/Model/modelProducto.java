package Model;

import Classes.clsProducto;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JOHN CASTAÑEDA GRUPO 52
 */
public class modelProducto {

    //SE INSTANCIA UN OBJETO DE TIPO MODELOBD QUE ME CONECTA LA BASE DE DATOS
    modelConexionBD conexionModeloYBD;
    
    ArrayList <clsProducto> listaProducto;
    
    //SE CREA EL CONSTRUCTOR 
    public modelProducto() {
        this.conexionModeloYBD = new modelConexionBD();
        this.listaProducto = new ArrayList();
        
    }

    //SE RECIBE EL OBJETO PARA EL CONTROLADOR
    public boolean crear(clsProducto producto) {
        // SE USA EL OBJETO PARA 

        try
        {
            conexionModeloYBD.conectar();
            String sentencia = "INSERT INTO tablaproducto(Nombre, Descripcion, "
                    + "Cantidad, PrecioUnitario, CodigoProveedor)VALUES (?,?,?,?,?)";

            // se prepara la sentencia para que la base de datos se pueda ingresar
            PreparedStatement statementProducto = conexionModeloYBD.getConexion().prepareStatement(sentencia);

            statementProducto.setString(1, producto.getNombre());
            statementProducto.setString(2, producto.getDescripcion());
            statementProducto.setInt(3, producto.getCantidadInventario());
            statementProducto.setInt(4, producto.getPrecioUnitario());
            statementProducto.setInt(5, producto.getProveedor());

            int res = statementProducto.executeUpdate();
            conexionModeloYBD.desconectar();
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

//BUSCA EL PRODUCTO
    public clsProducto buscar(String codigoProducto) {
        try
        {
            clsProducto producto = null;

            conexionModeloYBD.conectar();
            String sentencia = "SELECT Nombre ,Descripcion,Cantidad,"
                    + "PrecioUnitario,CodigoProveedor "
                    + "FROM tablaproducto WHERE ID = ?";

            PreparedStatement statementProducto = conexionModeloYBD.getConexion().prepareStatement(sentencia);

            statementProducto.setInt(1, Integer.parseInt(codigoProducto));

            ResultSet resultado = statementProducto.executeQuery();

            while (resultado.next())
            {

                String nombre = resultado.getString(1);
                String descripcion = resultado.getString(2);
                int cantidad = resultado.getInt(3);
                int precioUnitario = resultado.getInt(4);
                int codigoProveedor = resultado.getInt(5);

                producto = new clsProducto(codigoProducto, nombre, descripcion, cantidad, precioUnitario, codigoProveedor);

            }

            conexionModeloYBD.desconectar();
            return producto;
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

    //para cambiar el modificar se cambia la sentencia usando el update
    //SE BUSCA EL CODIGO PRODUCTO Y SE MODIFICA LA INFO
    public boolean modificar(clsProducto productoModificar) {

        try
        {
            conexionModeloYBD.conectar();
            String sentencia = "UPDATE tablaproducto SET Nombre = ?,"
                    + "Descripcion = ?,Cantidad = ?,PrecioUnitario = ?,"
                    + "CodigoProveedor = ? WHERE ID = ?";

            //Se prepara la sentencia que se va a usar para actualizar
            PreparedStatement statementProducto = conexionModeloYBD.getConexion().prepareStatement(sentencia);

            statementProducto.setString(1, productoModificar.getNombre());
            statementProducto.setString(2, productoModificar.getDescripcion());
            statementProducto.setInt(3, productoModificar.getCantidadInventario());
            statementProducto.setInt(4, productoModificar.getPrecioUnitario());
            statementProducto.setInt(5, productoModificar.getProveedor());
            statementProducto.setInt(6, Integer.parseInt(productoModificar.getIdProducto()));

            // ejecutamosla sentencia de la linea anterior                    
            int res = statementProducto.executeUpdate();
            conexionModeloYBD.desconectar();

        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


public ArrayList <clsProducto> llenarTabla(){
        try
        {
            clsProducto producto = null;

            conexionModeloYBD.conectar();
            String sentencia = "SELECT * FROM tablaproducto";

            PreparedStatement statementProducto = conexionModeloYBD.getConexion().prepareStatement(sentencia);

            ResultSet resultado = statementProducto.executeQuery();

            while (resultado.next())
            {
                int idProducto = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String descripcion = resultado.getString(3);
                int cantidad = resultado.getInt(4);
                int precioUnitario = resultado.getInt(5);
                int codigoProveedor = resultado.getInt(6);
                //Se crea un producto y cada vez que se llene y encuentre un siguiente, de esta forma sigue ejecutando hasta cuando no encuentre nada más
                producto = new clsProducto(idProducto + "",nombre, descripcion, cantidad, precioUnitario, codigoProveedor);
                listaProducto.add(producto);
                
            }
            conexionModeloYBD.desconectar();
            return listaProducto;
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

}
}


// public boolean delete ()
// statementProducto.setInt(6, Integer.parseInt(productoModificar.getIdProducto()));
