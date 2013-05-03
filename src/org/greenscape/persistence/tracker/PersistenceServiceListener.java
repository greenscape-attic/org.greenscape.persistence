package org.greenscape.persistence.tracker;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import org.greenscape.persistence.PersistenceService;

public class PersistenceServiceListener {
	private Collection<PersistenceService> services = new CopyOnWriteArrayList<>();

	public PersistenceServiceListener() {
		System.out.println("Persistence Listener instantiated");
	}

	public void addPersistenceService(PersistenceService persistence) {
		System.out.println("---------------------"
				+ persistence.getProvider().getName());
		services.add(persistence);
	}

	public void removePersistenceService(PersistenceService persistence) {
		services.remove(persistence);
	}

	public Collection<PersistenceService> getAll() {
		return services;
	}

	public void activate() {
		System.out.println("----------" + services.size());
	}
}
