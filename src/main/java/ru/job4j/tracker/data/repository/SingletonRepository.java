package ru.job4j.tracker.data.repository;

public abstract class SingletonRepository {
    private static SingletonRepository singletonRepository;

    public static SingletonRepository getInstance() {
        if (singletonRepository == null) {
            singletonRepository = new SingletonRepository() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            };
        }
        return singletonRepository;
    }
}
