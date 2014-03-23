package org.greenscape.persistence.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private ModelBundleTracker bundleTracker;

	@Override
	public void start(BundleContext context) throws Exception {
		bundleTracker = new ModelBundleTracker(context);
		bundleTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		bundleTracker.close();
	}
}
