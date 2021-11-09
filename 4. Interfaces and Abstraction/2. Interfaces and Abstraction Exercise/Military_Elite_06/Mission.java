package Military_Elite_06;

public interface Mission {
    public void completeMission();

    public String getCodeName();

    public String getState();

    @Override
    public String toString();
}
