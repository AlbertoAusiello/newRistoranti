package it.sysman.progettoristoranti.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import it.sysman.progettoristoranti.Service.ResturantServiceIMPL;

@Component
public class ListenerClass {

	@Autowired
	private ResturantServiceIMPL service;
	
	@EventListener(ContextRefreshedEvent.class)
	public void doAtStart() {
		service.fillDb();
	}
}
