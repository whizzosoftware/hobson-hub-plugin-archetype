package ${package};

import java.lang.Override;
import java.util.Dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whizzosoftware.hobson.api.plugin.AbstractHobsonPlugin;
import com.whizzosoftware.hobson.api.config.ConfigurationPropertyMetaData;
import com.whizzosoftware.hobson.api.plugin.PluginStatus;

/**
 * This Hobson plugin was generated from the Hobson Plugin Maven Archetype. Please change this description
 * accordingly.
 */
public class ${pluginName}Plugin extends AbstractHobsonPlugin {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ${pluginName}Plugin(String pluginId) {
        super(pluginId);
    }

    /**
     * Callback invoked when Hobson activates the plugin.
     *
     * @param pluginConfiguration the current plugin configuration (will be empty if the plugin is not configured)
     */
    @Override
    public void onStartup(Dictionary pluginConfiguration) {
        // TODO: add configuration property meta-data here (this is how a plugin exposes user-configurable settings in the web console)
        addConfigurationPropertyMetaData(new ConfigurationPropertyMetaData("myprop", "Example property", "An example string property", ConfigurationPropertyMetaData.Type.STRING));

        // TODO: publish devices
        publishDevice(new ${pluginName}Device(this, "one", "Example Light"));

        // set the status to running
        setStatus(new PluginStatus(PluginStatus.Status.RUNNING));
    }

    /**
     * Callback invoked when Hobson deactivates the plugin.
     */
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
