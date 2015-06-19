/*******************************************************************************
 * Copyright (c) 2015 <Your Company Here>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whizzosoftware.hobson.api.plugin.AbstractHobsonPlugin;
import com.whizzosoftware.hobson.api.plugin.PluginStatus;
import com.whizzosoftware.hobson.api.property.PropertyContainer;
import com.whizzosoftware.hobson.api.property.TypedProperty;

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
    public void onStartup(PropertyContainer pluginConfiguration) {
        // TODO: publish devices
        publishDevice(new ${pluginName}Device(this, "one", "Example Light"));

        // set the status to running
        setStatus(PluginStatus.running());
    }

    /**
     * Callback invoked when Hobson deactivates the plugin.
     */
    @Override
    public void onShutdown() {
        // TODO: perform any cleanup
        super.onShutdown();
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
    public void onPluginConfigurationUpdate(PropertyContainer config) {
    }

    protected TypedProperty[] createSupportedProperties() {
        // TODO: change to supported properties needed for this plugin (or null for none)
        return new TypedProperty[] {
            new TypedProperty("myprop", "Example property", "An example string property", TypedProperty.Type.STRING)
        };
    }
}
