package devops-1;

import org.apache.camel.Processor;
import org.apache.camel.util.component.AbstractApiConsumer;

import devops-1.internal.anjiApiName;

/**
 * The anji consumer.
 */
public class anjiConsumer extends AbstractApiConsumer<anjiApiName, anjiConfiguration> {

    public anjiConsumer(anjiEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
