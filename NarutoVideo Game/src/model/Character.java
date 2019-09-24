package model;

import java.io.Serializable;

public class Character implements Serializable, Comparable<Character> {
	private double power;
	private String name;
	private String date;
	private Technique frisTechnique;
	private Character next;

	public Character(double power, String name, String date) {
		super();
		this.power = power;
		this.name = name;
		this.date = date;
		this.frisTechnique = null;
		this.next = null;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Technique getFirsTechnique() {
		return frisTechnique;
	}

	public void setFirsTechnique(Technique firsTechnique) {
		this.frisTechnique = firsTechnique;
	}

	public Character getNext() {
		return next;
	}

	public void setNext(Character next) {
		this.next = next;
	}

	// add next
	public void addNext(Character e1) {
		e1.setNext(next);
		next = e1;

	}

	@Override
	public String toString() {
		return "Character [power=" + power + ", name=" + name + ", date=" + date + ", frisTechnique=" + frisTechnique
				+ ", next=" + next + "]";
	}

	@Override
	public int compareTo(Character c1) {
		int i = name.compareToIgnoreCase(c1.getName());
		if (i < 0) {
			i = -1;
		}
		if (i > 0) {
			i = 1;
		}
		return i;
	}

	// ordenar technique por factor
	public void ordeningFactor() {

		boolean ce2 = false;
		for (int i = sizeTechnique() + 1; i > 0 && !ce2; i--) {
			if (frisTechnique != null) {
				Technique t1 = frisTechnique;
				Technique t2 = frisTechnique.getNext();
				if (t2 == null) {
					ce2 = true;
				} else {
					if (t1.compareTo(t2) > 0) {
						t1.insertarAntes(t2);
						t2.insertarDespues(t1);
					}
					t1 = t1.getNext();
					t2 = t1.getNext();
					for (int j = 0; j < i && t2 != null; j++) {

						if (t1.compareTo(t2) > 0) {
							t1.insertarAntes(t2);
							t2.insertarDespues(t1);
						}
						t1 = t1.getNext();
						t2 = t1.getNext();
					}
				}
			}
		}
	}

	public int sizeTechnique() {
		int i = 0;
		if (frisTechnique != null) {
			i = 1;
			Technique tem = frisTechnique.getNext();
			while (tem != null) {
				tem = tem.getNext();
				i++;

			}
		}
		return i;
	}

	// add Technique
	public void addTechnique(Technique t1) {
		if (frisTechnique == null) {
			frisTechnique = t1;
		} else {
			if (findTechnique(t1.getName()).equalsIgnoreCase("the technique was not found")) {
				frisTechnique.insertarAntes(t1);
				ordeningFactor();
			}
		}
	}

	// find technique
	public String findTechnique(String name1) {
		String ms = "";
		if (frisTechnique != null) {
			if (frisTechnique.getName().equalsIgnoreCase(name1)) {
				ms += frisTechnique.toString();
			} else {
				Technique t1 = frisTechnique.getNext();
				boolean ce = false;
				while (t1 != null && !ce) {
					if (t1.getName().equalsIgnoreCase(name1)) {
						ms += t1.toString();
						ce = true;
					}
					t1 = t1.getNext();

				}
			}
		}
		if (ms.equals("")) {
			ms = "the technique was not found";
		}
		return ms;
	}

	public void delateNext() {
		next = next.getNext();
	}

	public void delateTechnique(String name1) {
		if (frisTechnique != null) {

			Technique t1 = frisTechnique;
			Technique t2 = t1.getNext();
			if (t1.getName().equalsIgnoreCase(name1)) {
				t1 = t2;
			} else {
				boolean ce = false;
				while (!ce && t2 != null) {
					if (t2.getName().equalsIgnoreCase(name1)) {
						t1.setNext(t2.getNext());
						if (t2.getNext() != null)
							t2.getNext().setBefore(t1);

						ce = true;

					}
					t1 = t1.getNext();
					t2 = t1.getNext();

				}
			}
		}
	}

}
