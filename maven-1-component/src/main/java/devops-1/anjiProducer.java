package devops-1;

import org.apache.camel.util.component.AbstractApiProducer;

import devops-1.internal.anjiApiName;
import devops-1.internal.anjiPropertiesHelper;

/**
 * The anji producer.
 */
public class anjiProducer extends AbstractApiProducer<anjiApiName, anjiConfiguration> {

    public anjiProducer(anjiEndpoint endpoint) {
        super(endpoint, anjiPropertiesHelper.getHelper());
    }
}
