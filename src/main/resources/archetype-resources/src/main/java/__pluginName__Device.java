package ${package};

import java.lang.Override;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whizzosoftware.hobson.api.device.AbstractHobsonDevice;
import com.whizzosoftware.hobson.api.device.DeviceType;
import com.whizzosoftware.hobson.api.plugin.HobsonPlugin;
import com.whizzosoftware.hobson.api.variable.HobsonVariable;
import com.whizzosoftware.hobson.api.variable.VariableConstants;

/**
 * This is an example device that has a single variable - "on"
 */
public class ${pluginName}Device extends AbstractHobsonDevice {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ${pluginName}Device(HobsonPlugin plugin, String id, String defaultName) {
        super(plugin, id);
        setDefaultName(defaultName);
    }

    /**
     * Callback invoked when Hobson activates the device.
     */
    @Override
    public void onStartup() {
        // TODO: publish device variables -- for example:
        publishVariable(VariableConstants.ON, true, HobsonVariable.Mask.READ_WRITE);
    }

    /**
     * Callback invoked when Hobson deactivates the device.
     */
    @Override
    public void onShutdown() {
        // TODO: perform any necessary cleanup
    }

    /**
     * Returns the device's type.
     *
     * @return the device type
     */
    @Override
    public DeviceType getType() {
        // TODO: return the appropriate device type
        return DeviceType.LIGHTBULB;
    }

    /**
     * Returns the name of the device's "preferred variable" -- the one variable it deems the most important to expose
     * to the user. The web console will attempt to render this variable on the device list.
     *
     * @return the variable name (or null if it doesn't have one)
     */
    @Override
    public String getPreferredVariableName() {
        return VariableConstants.ON;
    }

    /**
     * Called when a device should set one of its variables. The actual setting of the variable should be performed
     * asynchronously and this method must return as quickly as possible. It is the responsibility of this class
     * to fire a VariableUpdateEvent when the variable change has been confirmed.
     *
     * Note: This method should only be called by the framework and never directly by third-party plugin code. To
     * update a device variable from a plugin, use the VariableManager.setDeviceVariable() method.
     *
     * @param name the name of the variable
     * @param value the value of the variable
     */
    @Override
    public void onSetVariable(String name, Object value) {
        // TODO: update the hardware this device/variable controls
        logger.info("Setting device variable {} to {}", name, value);

        // if the device update was successful, notify the framework of the change
        // for this example, we fire the notification immediately
        fireVariableUpdateNotification(name, value);
    }
}
