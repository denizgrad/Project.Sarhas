package com.metu.sarhas.endpoint;

import java.util.Collection;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.metu.sarhas.model.Incident;
import com.metu.sarhas.repo.IncidentRepo;

@Api(name = "incident", version = "v1")//${sarhas}.appspot.com/_ah/api/incident/v1 ??
public class IncidentEndpoint {

	 @ApiMethod(name = "list", httpMethod = ApiMethod.HttpMethod.GET, path="list")
	 public Collection<Incident> getIncidents() {
	  return IncidentRepo.getInstance().findIncidents();
	 }

	 @ApiMethod(name = "create", httpMethod = ApiMethod.HttpMethod.POST, path="create")
	 public Incident create(Incident Incident) {
	  return IncidentRepo.getInstance().create(Incident);
	 }

	 @ApiMethod(name = "update", httpMethod = ApiMethod.HttpMethod.PUT, path="update")
	 public Incident update(Incident editedIncident) {
	  return IncidentRepo.getInstance().update(editedIncident);
	 }

	 @ApiMethod(name = "remove", httpMethod = ApiMethod.HttpMethod.DELETE, path="remove")
	 public void remove(@Named("id") Long id) {
	  IncidentRepo.getInstance().remove(id);
	 }
}