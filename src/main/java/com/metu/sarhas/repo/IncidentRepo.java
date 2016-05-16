package com.metu.sarhas.repo;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Collection;
import java.util.List;

import com.googlecode.objectify.Key;
import com.metu.sarhas.model.Incident;

public class IncidentRepo {

	private static IncidentRepo IncidentRepo = null;

	private IncidentRepo() {
	}

	public static synchronized IncidentRepo getInstance() {
		if (null == IncidentRepo) {
			IncidentRepo = new IncidentRepo();
		}
		return IncidentRepo;
	}

	public Collection<Incident> findIncidents() {
		List<Incident> todos = ofy().load().type(Incident.class).list();
		return todos;
	}

	public Incident create(Incident todo) {
		ofy().save().entity(todo).now();
		return todo;
	}

	public Incident update(Incident editedTodo) {
		if (editedTodo.getId() == null) {
			return null;
		}

		Incident todo = ofy().load().key(Key.create(Incident.class, editedTodo.getId())).now();
		todo.setCompleted(editedTodo.isCompleted());
		todo.setTitle(editedTodo.getTitle());
		ofy().save().entity(todo).now();

		return todo;
	}

	public void remove(Long id) {
		if (id == null) {
			return;
		}
		ofy().delete().type(Incident.class).id(id).now();
	}
}
