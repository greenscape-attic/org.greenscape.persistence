package org.greenscape.persistence;

public interface ModelRegistryEntry {
	String getModelClass();

	String getModelName();

	long getBundleId();
}
