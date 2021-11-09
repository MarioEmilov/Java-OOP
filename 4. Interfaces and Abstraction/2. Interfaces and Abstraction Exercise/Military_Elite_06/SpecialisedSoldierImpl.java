package Military_Elite_06;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corp corpType;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corp corpType) {
        super(id, firstName, lastName, salary);
        this.corpType = corpType;
    }

    public Corp getCorpType() {
        return this.corpType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Corps: ").append(this.corpType);
        return sb.toString();
    }
}
