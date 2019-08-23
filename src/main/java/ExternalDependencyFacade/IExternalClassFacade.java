package ExternalDependencyFacade;


import java.util.ArrayList;

public interface IExternalClassFacade {
    // here we are able to name this method to be something meaningful for us in our system
    // regardless of what the external dependency wants to call it
    public Result determineDataType(ArrayList<String> data);
}
