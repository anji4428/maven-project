package devops-1;

import java.util.Map;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriPath;
import org.apache.camel.util.component.AbstractApiEndpoint;
import org.apache.camel.util.component.ApiMethod;
import org.apache.camel.util.component.ApiMethodPropertiesHelper;

import devops-1.api.anjiFileHello;
import devops-1.api.anjiJavadocHello;
import devops-1.internal.anjiApiCollection;
import devops-1.internal.anjiApiName;
import devops-1.internal.anjiConstants;
import devops-1.internal.anjiPropertiesHelper;

/**
 * Represents a anji endpoint.
 */
@UriEndpoint(firstVersion = "1.0-SNAPSHOT", scheme = "s", title = "anji", syntax="s:name", 
             consumerClass = anjiConsumer.class, label = "custom")
public class anjiEndpoint extends AbstractApiEndpoint<anjiApiName, anjiConfiguration> {

    @UriPath @Metadata(required = "true")
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public anjiEndpoint(String uri, anjiComponent component,
                         anjiApiName apiName, String methodName, anjiConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, anjiApiCollection.getCollection().getHelper(apiName), endpointConfiguration);

    }

    public Producer createProducer() throws Exception {
        return new anjiProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final anjiConsumer consumer = new anjiConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<anjiConfiguration> getPropertiesHelper() {
        return anjiPropertiesHelper.getHelper();
    }

    protected String getThreadProfileName() {
        return anjiConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO_FILE:
                apiProxy = new anjiFileHello();
                break;
            case HELLO_JAVADOC:
                apiProxy = new anjiJavadocHello();
                break;
            default:
                throw new IllegalArgumentException("Invalid API name " + apiName);
        }
    }

    @Override
    public Object getApiProxy(ApiMethod method, Map<String, Object> args) {
        return apiProxy;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
