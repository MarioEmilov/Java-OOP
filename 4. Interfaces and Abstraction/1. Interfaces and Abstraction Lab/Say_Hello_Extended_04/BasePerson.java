package Say_Hello_Extended_04;

public abstract class BasePerson implements Person{
    private String name;

    protected BasePerson(String name) {
        this.setName(name);
    }

    public String getName(){
        return name;
    }

    private void setName(String name){
        this.name = name;
    }

    public abstract String sayHello();
}
