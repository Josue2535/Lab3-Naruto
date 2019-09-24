package model;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.print.attribute.Size2DSyntax;

public class Controller {

	private ArrayList<Clan> clans;

	public Controller() {
		this.clans = new ArrayList<Clan>();
	}

	public ArrayList<Clan> getFristClan() {
		return clans;
	}

	
	public void read() throws Exception {

		File archive = new File("./reader/reader.game");
		if (archive.exists()) {
			try {
				FileInputStream fis = new FileInputStream(archive);
				ObjectInputStream ois = new ObjectInputStream(fis);

				ArrayList<Clan> clansObjec = (ArrayList<Clan>) ois.readObject();
				clans = clansObjec;

				ois.close();
				fis.close();

			} catch (Exception e) {

			}
		}
	}

	public void write() {
		File archive = new File("./reader/reader.game");
		try {
			FileOutputStream fos = new FileOutputStream(archive);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(clans);

			fos.close();
			oos.close();
		} catch (Exception e) {

		}
	}

	public void ordeningClub() {
		int inicial;
		for (inicial = 0; inicial < clans.size(); inicial++) {
			int minorPosition = inicial;
			Clan minorClan = clans.get(inicial);

			for (int i = inicial + 1; i < clans.size(); i++) {
				Clan positionClan = clans.get(i);

				if (positionClan.compare(positionClan, minorClan) < 0) {
					minorClan = positionClan;
					minorPosition = i;
				}
			}

			if (minorPosition != inicial) {
				Clan temp = clans.get(inicial);
				clans.set(inicial, minorClan);
				clans.set(minorPosition, temp);
			}

		}
	}

	public String findClan(String name) {
		String ms = "";
		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(name)) {
				ms += clans.get(i).toString();
				i = clans.size();
			}
		}
		if (ms.equals("")) {
			ms = "clan was not found";
		}
		return ms;
	}

	public void addClanS(String name) {
		if (findClan(name).equals("clan was not found")) {
			Clan c = new Clan(name);
			clans.add(c);
			ordeningClub();
		}
	}

	public void ordeninAll() {
		ordeningClub();
		for (int i = 0; i < clans.size(); i++) {
			clans.get(i).ordeningAll();

		}

	}

	public String findCharacter(String nacl, String name) {
		String ms = "";
		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(nacl)) {
				ms = clans.get(i).findCharacter(name);
			}
		}
		if (ms.equals("")) {
			ms = "clan was not found";
		}
		return ms;
	}

	public String findTechnique(String ncl, String naC, String nameT) {
		String ms = "";
		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(ncl)) {
				ms += clans.get(i).findTechnique(naC, nameT);
			}
		}
		if (ms.equals("")) {
			ms = "clan was not found";
		}
		return ms;
	}

	public void deleteTechnique(String nacl, String namC, String nameT) {
		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(nacl)) {
				clans.get(i).delateTechnique(namC, nameT);
				;
			}
		}
	}

	public void deleteCharacter(String nacl, String namC) {
		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(nacl)) {
				clans.get(i).delateCharacter(namC);
			}
		}
	}

	public void deleteClan(String name) {

		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(name)) {
				clans.remove(i);
				i = clans.size();
			}
		}

	}

	public void addTechnique(String nacl, String nam, Technique t1) {
			for (int i = 0; i < clans.size(); i++) {
				if (clans.get(i).getName().equalsIgnoreCase(nacl)) {
					clans.get(i).addTechnique(nam, t1);
				}
			}
		
	}

	public void addCharacter(String nacl, Character t1) {
		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(nacl)) {
				clans.get(i).addCharacter(t1);
			}
		}
	}
	
	public void updateClan(String name, String name1) {
		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(name)) {
				clans.get(i).setName(name1);
				i = clans.size();
			}
		}
	}
	
	public void updateCharacter(String nameC, String name, double power, String date) {
		for (int i = 0; i < clans.size(); i++) {
			if (clans.get(i).getName().equalsIgnoreCase(nameC)) {
				clans.get(i).updatecharacter(name, power, date);;
				i = clans.size();
			}
		}
	}
}
