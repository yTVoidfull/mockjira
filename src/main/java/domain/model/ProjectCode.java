package domain.model;

public class ProjectCode {
    private String code;

    public ProjectCode(String code) {
        if(code == null ||
                !code.matches("[A-Za-z]{6}\\d{3}")){
            throw new IllegalArgumentException("Code must be 6 letters and 3 digits");
        }
        this.code = code;
    }

    @Override
    public String toString(){
        return code;
    }

    public boolean equals(Object other){
        return this.code.equals(other.toString());
    }

}
