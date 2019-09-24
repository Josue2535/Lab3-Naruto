package model;

import java.io.Serializable;
import java.util.Comparator;

public class Clan implements Serializable, Comparator<Clan> {
	private String name;
	private Character frist;

	public Clan(String name) {
		super();
		this.name = name;
		this.frist = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getFrist() {
		return frist;
	}

	public void setFrist(Character frist) {
		this.frist = frist;
	}

	public void delateCharacter(String name) {
		if (frist != null) {
			if (frist.getName().equalsIgnoreCase(name)) {
				frist = frist.getNext();
			} else {
				Character t1 = frist;
				Character t2 = t1.getNext();
				boolean ce = false;
				while (!ce && t2 != null) {
					if (t2.getName().equalsIgnoreCase(name)) {
						t1.delateNext();
					}

				}
			}
		}
	}

	public void delateTechnique(String nameC, String nameT) {
		if (frist == null) {

		}
		if (frist.getName().equalsIgnoreCase(nameC)) {
			frist.delateTechnique(nameT);
		} else {
			boolean ce = false;
			Character t1 = frist.getNext();
			while (t1 != null && !ce) {
				if (t1.getName().equalsIgnoreCase(nameC)) {
					t1.delateTechnique(nameT);
					ce = true;
				} else {
					t1 = t1.getNext();
				}

			}
		}
	}

	public void ordeningCharacter() {
		if (frist == null) {

		} else {
			if (frist.getNext() == null) {

			} else {

				Character f = null;
				Character o = null;
				Character m = frist;

				boolean ce = false;
				while (!ce) {
					Character c1 = frist;
					while (c1 != null) {
						if (m.compareTo(c1) > 0) {
							m = c1;
						}
						c1 = c1.getNext();
					}
					delateCharacter(m.getName());
					if (f == null) {
						f = m;
						o = f;
					} else {
						if (f == m) {
							ce = true;
						} else {
							f.setNext(m);
							f = f.getNext();
						}
					}
				}

				frist = o;
			}
		}
	}

	public void addCharacter(Character c1) {
		if (frist == null) {
			frist = c1;
		} else {
			if ((findCharacter(c1.getName()).equalsIgnoreCase("the character was not found"))) {
				frist.addNext(c1);
				ordeningCharacter();
			}
		}
	}

	@Override
	public String toString() {
		return "Clan [name=" + name + ", frist=" + frist.getName() + "]";
	}

	public String findCharacter(String name) {
		String ms = "";
		Character t1 = frist;
		boolean ce = false;
		while (t1 != null && !ce) {
			if (t1.getName().equalsIgnoreCase(name)) {
				ms += t1.toString();
				ce = true;
			}
			t1 = t1.getNext();

		}
		if (ms.equals("")) {
			ms = "the character was not found";
		}
		return ms;
	}

	public String findTechnique(String name, String namT) {
		String ms = "";
		Character t1 = frist;
		boolean ce = false;
		while (t1 != null && !ce) {
			if (t1.getName().equalsIgnoreCase(name)) {
				ms += t1.findTechnique(namT);
				ce = true;
			}
			t1 = t1.getNext();

		}
		return ms;
	}

	
	public void ordeningAll() {
		ordeningCharacter();
		Character t1 = frist;
		while (t1 != null) {
			t1.ordeningFactor();
			t1 = t1.getNext();
		}
	}
	
	public void addTechnique(String nameC, Technique t) {
		Character t1 = frist;
		boolean ce = false;
		while (t1 != null && !ce) {
			if (t1.getName().equalsIgnoreCase(name)) {
				t1.addTechnique(t);
				ce = true;
			}
			t1 = t1.getNext();

		}
	}

	@Override
	public int compare(Clan o1, Clan o2) {
		int i = o1.getName().compareToIgnoreCase(o2.getName());
		if (i < 0) {
			i = -1;
		}
		if (i > 0) {
			i = 1;
		}
		return i;
	}
}
