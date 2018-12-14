package Classe;

import java.util.LinkedList;

public class Patio {
	
	private LinkedList<Containers> containersPatio;

	public Patio(LinkedList<Containers> containersPatio) {
		super();
		this.containersPatio = containersPatio;
	}

	public LinkedList<Containers> getContainersPatio() {
		return containersPatio;
	}

	public void setContainersPatio(LinkedList<Containers> containersPatio) {
		this.containersPatio = containersPatio;
	}

	
}
