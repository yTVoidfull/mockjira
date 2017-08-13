package enums;

public enum Status {

    OPEN(1),
    CLOSED(0);

    private int id;

    Status(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
