package model;

import java.io.Serializable;

public class Technique implements Serializable, Comparable<Technique> {
	private String name;
	private double factor;
	private Technique next;
	private Technique before;

	public Technique(String name, double factor) {
		super();
		this.name = name;
		this.factor = factor;
		this.next = null;
		this.before = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public Technique getNext() {
		return next;
	}

	public void setNext(Technique next) {
		this.next = next;
	}

	public Technique getBefore() {
		return before;
	}

	public void setBefore(Technique before) {
		this.before = before;
	}

	public void insertarDespues(Technique t1) {
		t1.next = next;
		if (next != null)
			next.before = t1;
		t1.before = this;
		next = t1;

	}

	public void insertarAntes(Technique t1) {
		if (before != null) {
			before.next = t1;
			t1.before = before;
			t1.next = this;
			before = t1;
			if(t1.getNext()!= null) {
				next = t1.getNext();
				t1.getNext().setBefore(this);
			}
		}
	}

	@Override
	public int compareTo(Technique t1) {
		int i = 0;
		if (factor < t1.getFactor()) {
			i = -1;
		}
		if (factor > t1.getFactor()) {
			i = 1;
		}
		return i;
	}

	@Override
	public String toString() {
		return "Technique [name=" + name + ", factor=" + factor + "]";

	}

}
