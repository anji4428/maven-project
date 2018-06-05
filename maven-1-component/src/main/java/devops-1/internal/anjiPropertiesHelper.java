package devops-1.internal;

import org.apache.camel.util.component.ApiMethodPropertiesHelper;

import devops-1.anjiConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for anji component.
 */
public final class anjiPropertiesHelper extends ApiMethodPropertiesHelper<anjiConfiguration> {

    private static anjiPropertiesHelper helper;

    private anjiPropertiesHelper() {
        super(anjiConfiguration.class, anjiConstants.PROPERTY_PREFIX);
    }

    public static synchronized anjiPropertiesHelper getHelper() {
        if (helper == null) {
            helper = new anjiPropertiesHelper();
        }
        return helper;
    }
}
