package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T extends Model> {

    public void save(T model) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.getDbFile(), true));
        writer.write(model.toString());
        writer.newLine();
        writer.close();
    }

    public List<T> list() {
        List<T> models = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.getDbFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T model = this.getModelFactory().fromString(line);
                if (model != null) {
                    models.add(model);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return models;
    }

    public int getTotalCount() {
        return this.list().size();
    }

    public void clearDB() {
        try (FileWriter writer = new FileWriter(this.getDbFile())) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract protected String getDbFile();

    abstract protected ModelFactoryInterface<T> getModelFactory();

}
