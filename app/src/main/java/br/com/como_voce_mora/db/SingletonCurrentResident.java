package br.com.como_voce_mora.db;

public class SingletonCurrentResident {
    private static SingletonCurrentResident mInstance;
    private long currentResident;

    public static SingletonCurrentResident getInstance() {
        return (mInstance == null) ? mInstance = new SingletonCurrentResident() : mInstance;
    }

    public long getCurrentResident() {
        return currentResident;
    }

    public void setCurrentResident(long currentResident) {
        this.currentResident = currentResident;
    }
}
