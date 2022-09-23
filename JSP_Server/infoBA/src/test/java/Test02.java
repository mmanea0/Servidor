import com.daw2.infoba.model.dao.HabitacionesDao;
import com.daw2.infoba.model.dao.impl.HabitacionesDaoImpl;
import com.daw2.infoba.model.entity.Habitacion;

import java.util.Date;

public class Test02 {
    public static void main(String[] args) {
        HabitacionesDao habitacionesDao= new HabitacionesDaoImpl();
        Habitacion habitacion=new Habitacion(0,"32",3,false,"es de matrimonio",new Date(),new Date());
        habitacionesDao.add(habitacion);

        for (Habitacion habi : habitacionesDao.listAll()){
            System.out.println(habi);
        }
    }
}
