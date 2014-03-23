package org.greenscape.persistence.impl;

import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.util.tracker.BundleTracker;

public class ModelBundleTracker extends BundleTracker<String> {
	private final Map<String, Configuration> configMap = new HashMap<>();

	public ModelBundleTracker(BundleContext context) {
		super(context, Bundle.ACTIVE, null);
	}

	@Override
	public String addingBundle(Bundle bundle, BundleEvent event) {
		Dictionary<String, String> headers = bundle.getHeaders();
		String modelListStr = headers.get("GS-DomainModel");
		if (modelListStr == null) {
			return null;
		}
		ServiceReference<ConfigurationAdmin> configAdminRef = context.getServiceReference(ConfigurationAdmin.class);

		String[] modelArray = modelListStr.split(",");
		if (configAdminRef != null) {
			ConfigurationAdmin confAdmin = context.getService(configAdminRef);
			for (String model : modelArray) {
				try {
					bundle.loadClass(model);
					Configuration configuration = null;
					Dictionary<String, Object> properties = new Hashtable<>();
					properties.put("modelClass", model);
					configuration = confAdmin.createFactoryConfiguration(ModelRegistryEntryImpl.FACTORY_DS, null);
					properties.put("bundleId", bundle.getBundleId());
					configMap.put(model, configuration);
					configuration.update(properties);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, String object) {
		Dictionary<String, String> headers = bundle.getHeaders();
		String modelListStr = headers.get("GS-DomainModel");
		if (modelListStr == null) {
			return;
		}
		String[] modelArray = modelListStr.split(",");
		for (String model : modelArray) {
			try {
				if (configMap.get(model) != null) {
					configMap.get(model).delete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			configMap.remove(model);
		}
	}
}
