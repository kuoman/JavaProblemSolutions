package ExternalDependencyFacade;

import java.util.ArrayList;

public class ExternalDependencyFacade implements IExternalClassFacade {
    private final DependencyCode dependencyCode;

    public ExternalDependencyFacade(DependencyCode thirdPartyCode){

        this.dependencyCode = thirdPartyCode;
    }

    // simple lightweight method that insulates us from that 3rd party code and
    // does something meaningful in our system...named appropriately of course.
    public Result determineDataType(ArrayList<String> data) {
        return dependencyCode.determineIfTruck(data);
    }
}
