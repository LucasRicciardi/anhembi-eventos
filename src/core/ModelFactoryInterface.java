package core;

public interface ModelFactoryInterface<T extends Model> {
    T fromString(String string);
}
