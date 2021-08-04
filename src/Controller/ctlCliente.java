package Controller;

import Classes.clsCliente;
import Model.ModelCliente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JOHN CASTAÑEDA GRUPO 52
 */
public class ctlCliente {

    ModelCliente modelCliente;

    //METODO CONSTRUCTOR
    public ctlCliente() {
        modelCliente = new ModelCliente();
    }

    //METODO CRUD CREAR
    public boolean crear(String idCliente, String fechaNacimiento, int cantidadCompras,
            boolean fidelizacion, String tipoDocumento, String numeroDocumento,
            String nombre, String direccion, String ciudad, String departamento,
            String telefono, String email, List<clsCliente> listaCliente) {
        clsCliente cliente = new clsCliente(idCliente, fechaNacimiento, cantidadCompras,
                fidelizacion, tipoDocumento, numeroDocumento, nombre, direccion, ciudad,
                departamento, telefono, email);
        return modelCliente.crear(cliente, listaCliente);
    }

    //METODO CRUD BUSCAR
        public clsCliente leer(String numeroDocumento, List<clsCliente> listaCliente) {
        return modelCliente.leer(numeroDocumento, listaCliente);
        
        }

    //METODO ACTUALIZAR
    public boolean actualizar(String idCliente, String fechaNacimiento, int cantidadCompras,
            boolean fidelizacion, String tipoDocumento, String numeroDocumento,
            String nombre, String direccion, String ciudad, String departamento,
            String telefono, String email, List<clsCliente> listaCliente) {
        clsCliente cliente = new clsCliente(idCliente, fechaNacimiento, cantidadCompras,
                fidelizacion, tipoDocumento, numeroDocumento, nombre, direccion, ciudad,
                departamento, telefono, email);
        return modelCliente.actualizar(cliente, listaCliente);
    }

    //METODO BORRAR
    public boolean delete(String idCliente, List<clsCliente> listaClientes) {
        //SE DEBE REALIZAR UNA CONFIRMACION CON EL USUARIO QUE ESTE SEGURO DE ELIMINAR
        //0: SI
        //1: NO
        //2: CANCELAR
        int respuesta = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar al cliente con el ID " + idCliente + "?");

        if (respuesta == 0)
        {
            return ModelCliente.delete(idCliente, listaClientes);
        }

        return false;
    }
}
