package ExternalDependencyFacade;

public class Result {
    private final String type;

    public Result(String type){

        this.type = type;
    }

    public boolean isOfType(String type) {
        return this.type.equals(type);
    }
}
