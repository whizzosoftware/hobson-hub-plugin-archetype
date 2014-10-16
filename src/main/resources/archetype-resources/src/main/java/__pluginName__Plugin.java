package ${package};

import java.lang.Override;
import java.util.Dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whizzosoftware.hobson.api.plugin.AbstractHobsonPlugin;
import com.whizzosoftware.hobson.bootstrap.api.config.ConfigurationMetaData;
import com.whizzosoftware.hobson.bootstrap.api.plugin.PluginStatus;

public class ${pluginName}Plugin extends AbstractHobsonPlugin {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ${pluginName}Plugin(String pluginId) {
        super(pluginId);

        // TODO: add plugin configuration meta-data here -- for example:
        addConfigurationMetaData(new ConfigurationMetaData("myprop", "Example property", "An example string property", ConfigurationMetaData.Type.STRING));
    }

    @Override
    public void init(Dictionary pluginConfiguration) {
        // TODO: publish devices -- for example:
        publishAndStartDevice(new ${pluginName}Device(this, "one", "Example Light"));

        // set the status to running
        setStatus(new PluginStatus(PluginStatus.Status.RUNNING));
    }

    @Override
    public void stop() {
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
     * Returns how frequently the refresh method will be called.
     *
     * @return an interval in seconds (0 means never)
     */
    @Override
    public long getRefreshInterval() {
        return 0;
    }

    /**
     * Callback method to allow the plugin to refresh itself and its devices.
     */
    @Override
    public void onRefresh() {
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
