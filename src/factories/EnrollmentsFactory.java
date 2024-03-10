package factories;

import core.Consts;
import core.ModelFactoryInterface;
import models.Enrollment;

public class EnrollmentsFactory implements ModelFactoryInterface<Enrollment> {
    public Enrollment fromString(String string) {
        String[] components = string.split(Consts.SEPARATOR);
        if (components.length != 2) {
            System.out.println("Falha ao ler inscrição com entrada inválida: " + string);
            return null;
        }
        return new Enrollment(Integer.parseInt(components[0]), Integer.parseInt(components[1]));
    }
}
