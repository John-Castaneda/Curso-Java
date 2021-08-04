package Controller;

import Classes.clsProducto;
import Model.modelProducto;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author JOHN CASTAÑEDA 52
 */
public class ctlProducto {

    //ATRIBUTO QUE CONECTA EL CONTROLADOR Y EL MODELO
    modelProducto modelProducto;

    //SE INSTANCIA EL OBJETO QUE VA A CONECTAR
    public ctlProducto() {
        modelProducto = new modelProducto();
    }

    //creo el metodo para recibir el array list de la clase lista producto y 
    //se va a llamar lista producto
    public String[][] matriz() {
        
        ArrayList <clsProducto> listaProducto = modelProducto.llenarTabla();
        // se crea un entero que me dara el tamaño de la lista
        int tamañoLista = listaProducto.size();
        // se crea la matriz que va acontener la información de la lista del producto
        // se debe tener en cuenta la cantidad de columnas para no generar campos vacios
        String[][] matrizProducto = new String[tamañoLista][6];

        //se crea una variable para que tengamos un indice y poder inicializar la matriz
        int indice = 0;

        //se crea un for de tipo for each donde esta buscando una variable llamada producto
        //dentro de la clase producto y que tiene el tamaño de la lista producto
        for (clsProducto producto : listaProducto) {

            matrizProducto[indice][0] = producto.getIdProducto();
            matrizProducto[indice][1] = producto.getNombre();
            matrizProducto[indice][2] = producto.getDescripcion();
            //se castea a STRING agregandole una cadena vacia con ""
            //matrizProducto[indice][3] = producto.getCantidadInventario()+ "";
            // se convierte de un entero a cadena con el uso de Integer.toString
            matrizProducto[indice][3] = Integer.toString(producto.getCantidadInventario());
            matrizProducto[indice][4] = Integer.toString(producto.getPrecioUnitario());
            matrizProducto[indice][5] = Integer.toString(producto.getProveedor());
            indice++;
        }
        listaProducto.clear();
        
        return matrizProducto;
    }

    //METODO CRUD CREAR
    public boolean crear(String codigoProducto, String nombre, String descripcion,
            int cantidad, int precioUnitario, int proveedor) {
        clsProducto producto = new clsProducto(codigoProducto, nombre, descripcion,
                cantidad, precioUnitario, proveedor);
        return modelProducto.crear(producto);
    }

    //METODO CRUD BUSCAR
    public clsProducto buscar(String codigoProducto) {
        clsProducto producto = modelProducto.buscar(codigoProducto);
        return producto;
    }
    
        //METODO CRUD MODIFICAR
    public boolean modificar (String codigoProducto, String nombre, String descripcion,
            int cantidad, int precioUnitario, int proveedor) {
        clsProducto producto = new clsProducto(codigoProducto, nombre, descripcion,
                cantidad, precioUnitario, proveedor);
        return modelProducto.modificar(producto);    
    }
    
    
    
}
