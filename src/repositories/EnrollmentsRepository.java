package repositories;

import core.ModelFactoryInterface;
import core.Repository;
import factories.EnrollmentsFactory;
import models.Enrollment;

public class EnrollmentsRepository extends Repository<Enrollment> {

    protected String getDbFile() {
        return "enrollments.db";
    }

    protected ModelFactoryInterface<Enrollment> getModelFactory() {
        return new EnrollmentsFactory();
    }
}
