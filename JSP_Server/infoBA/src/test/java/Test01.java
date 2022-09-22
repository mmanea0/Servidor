import com.daw2.infoba.model.dao.ProveedoresDao;
import com.daw2.infoba.model.dao.impl.ProveedoresDaoImpl;
import com.daw2.infoba.model.entity.Proveedor;

import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        ProveedoresDao proveedoresDao= new ProveedoresDaoImpl();

        Proveedor proveedor=new Proveedor();
        proveedor.setNif("123");
        proveedor.setNombre("Pepito");
        proveedor.setApellido1("Perez");
        proveedor.setApellido2("Lopez");
        proveedor.setCreatedAt(new Date());
        proveedor.setModifiedAt(new Date());
        proveedoresDao.add(proveedor);

        //listado de proveedores
        for (Proveedor proveedor1: proveedoresDao.listAll()){
            System.out.println(proveedor1);
        }
    }
}
