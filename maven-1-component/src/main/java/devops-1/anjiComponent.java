package devops-1;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.util.component.AbstractApiComponent;

import devops-1.internal.anjiApiCollection;
import devops-1.internal.anjiApiName;

/**
 * Represents the component that manages {@link anjiEndpoint}.
 */
public class anjiComponent extends AbstractApiComponent<anjiApiName, anjiConfiguration, anjiApiCollection> {

    public anjiComponent() {
        super(anjiEndpoint.class, anjiApiName.class, anjiApiCollection.getCollection());
    }

    public anjiComponent(CamelContext context) {
        super(context, anjiEndpoint.class, anjiApiName.class, anjiApiCollection.getCollection());
    }

    @Override
    protected anjiApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return anjiApiName.fromValue(apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, anjiApiName apiName,
                                      anjiConfiguration endpointConfiguration) {
        anjiEndpoint endpoint = new anjiEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(anjiConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
