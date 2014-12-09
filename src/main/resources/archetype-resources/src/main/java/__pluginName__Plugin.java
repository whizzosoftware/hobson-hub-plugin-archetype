package ${package};

import java.lang.Override;
import java.util.Dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whizzosoftware.hobson.api.plugin.AbstractHobsonPlugin;
import com.whizzosoftware.hobson.api.config.ConfigurationPropertyMetaData;
import com.whizzosoftware.hobson.api.plugin.PluginStatus;

public class ${pluginName}Plugin extends AbstractHobsonPlugin {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ${pluginName}Plugin(String pluginId) {
        super(pluginId);

        // TODO: add plugin configuration meta-data here -- for example:
        addConfigurationPropertyMetaData(new ConfigurationPropertyMetaData("myprop", "Example property", "An example string property", ConfigurationPropertyMetaData.Type.STRING));
    }

    @Override
    public void onStartup(Dictionary pluginConfiguration) {
        // TODO: publish devices -- for example:
        publishDevice(new ${pluginName}Device(this, "one", "Example Light"));

        // set the status to running
        setStatus(new PluginStatus(PluginStatus.Status.RUNNING));
    }

    @Override
    public void onShutdown() {
        // TODO: perform any cleanup
    }

    /**
     * Returns the plugin name.
     *
     * @return a String
     */
    @Override
    public String getName() {
        return "Example Plugin";
    }

    /**
     * Callback method when the plugin's configuration changes.
     *
     * @param config the new configuration
     */
    @Override
    public void onPluginConfigurationUpdate(Dictionary config) {
    }
}
