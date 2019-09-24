package ui;

import model.*;
import model.Character;

import java.io.IOException;
import java.util.*;

import exeptions.BadChoiseExeption;

public class Main {
	private Controller co;
	private Scanner reader;

	public static void main(String[] args) throws Exception {
		Main execute = new Main();
		execute.menu();
	}

	public Main() {
		reader = new Scanner(System.in);
	}

	public void menu() throws Exception {
		int userInput = 0;

		co = new Controller();
		co.read();
		co.ordeninAll();
		System.out.println("");
		System.out.println("");

		// WELCOME
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Welcome to the best lab in the world");
		System.out.println("enjoy your stay :3");
		System.out.println("-----------------------------------------------------------------");
		while (userInput != 4) {

			showControllerOp();

			System.out.println("------------------------------------------");
			System.out.print("| Type the number of your selection: ");
			try {
				userInput = reader.nextInt();
				reader.nextLine();
				System.out.println("--------------------------------------");

				switch (userInput) {

				case 1:
					accessClan();
					break;

				case 2:
					registerClan();
					break;

				case 3:
					updateClan();
					break;

				case 4:
					deleteClan();
					break;

				case 5:
					theGoodbye();
					co.write();
					break;

				default:
					System.out.println();
					System.out.println("Please type a number between 1 and 5");
					System.out.println();
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.print("ERROR: Invalid option");
				reader.nextLine();
				System.out.println();
			}

		}

	}

	public void showControllerOp() {

		System.out.println("--------------------------------------- \n");
		System.out.println("1. access a clan.");
		System.out.println("2. Register a new clan.");
		System.out.println("3. update clan.");
		System.out.println("4. Delete a clan.");
		System.out.println("5. CHAU ");
		System.out.println("----------------------------------------- \n");
	}

	public void showClanMenu() {
		System.out.println("--------------------------------------- \n");
		System.out.println("1. access a character.");
		System.out.println("2. Register a new Character.");
		System.out.println("3. update character.");
		System.out.println("4. Delete a character.");
		System.out.println("----------------------------------------- \n");
	}

	public void showCharacterMenu() {
		System.out.println("--------------------------------------- \n");
		System.out.println("1. show a Techniques.");
		System.out.println("2. Register a new technique.");
		System.out.println("3. update technique.");
		System.out.println("4. Delate a technique.");
		System.out.println("----------------------------------------- \n");
	}

	public void theGoodbye() {
		System.out.print("see you later");
		System.out.flush();
		System.out.println("");
		System.out.println("");
	}

	public void accessClan() {
		boolean ce = false;
		String name = null;
		String namec;
		String nameT;
		int mo = 0;
		while (!ce && mo != 2) {
			System.out.println("Enter clan name");
			name = reader.nextLine();
			System.out.println(co.findClan(name));
			if (!co.findClan(name).equalsIgnoreCase("clan was not found")) {
				ce = true;
			} else {
				mo++;
			}
		}
		if (mo != 2) {
			if (!co.findClan(name).equalsIgnoreCase("clan was not found")) {
				showClanMenu();
				System.out.println("Type the number of your selection:");
				int sel1 = 0;
				ce = false;
				while (!ce) {
					try {
						sel1 = reader.nextInt();
						reader.nextLine();
						if (sel1 > 4 || sel1 < 1) {
							throw new BadChoiseExeption("bad choise");
						} else {
							ce = true;
						}
					} catch (Exception e) {
						System.out.println("please choose a valid option");
					}

				}
				if (sel1 == 1) {
					System.out.println("Enter the name of Character");
					namec = reader.nextLine();
					System.out.println(co.findCharacter(name, namec));
					showCharacterMenu();
					ce = false;
					while (!ce) {
						try {
							sel1 = reader.nextInt();
							reader.nextLine();
							if (sel1 > 4 || sel1 < 1) {
								throw new BadChoiseExeption("bad choise");
							} else {
								ce = true;
							}
						} catch (Exception e) {
							System.out.println("please choose a valid option");
						}
					}
					System.out.println("Enter the name of technique");
					nameT = reader.nextLine();
					if (sel1 == 1) {

						System.out.println(co.findTechnique(name, namec, nameT));
					}
					if (sel1 == 2) {

						System.out.println("Enter the factor");
						System.out.println("twice to confirm");
						ce = false;
						double fac = 0.0;
						reader.nextLine();
						while (!ce) {
							try {
								fac = reader.nextDouble();
							} catch (Exception e) {
								System.out.println("please choose a valid option");
							}
							ce = true;

						}
						Technique t1 = new Technique(nameT, fac);
						co.addTechnique(name, namec, t1);
					}
					if (sel1 == 3) {
						System.out.println("Enter update the factor");
						co.deleteTechnique(name, namec, nameT);
						double fac = 0.0;
						while (!ce) {
							try {
								fac = reader.nextDouble();
								reader.nextLine();
								ce = true;
							} catch (Exception e) {
								System.out.println("please choose a valid option");
							}

						}
						Technique t1 = new Technique(nameT, fac);
						co.addTechnique(name, namec, t1);
					}
					if (sel1 == 4) {
						co.deleteTechnique(name, namec, nameT);
					}
				} else if (sel1 == 2) {
					System.out.println("Enter the name of Character");
					namec = reader.nextLine();
					System.out.println("Enter the power of character");
					double fac = 0.0;
					ce = false;
					while (!ce) {
						try {
							fac = reader.nextDouble();
							reader.nextLine();
							ce = true;
						} catch (Exception e) {
							System.out.println("please choose a valid option");
						}

					}
					System.out.println("Enter date of character");
					String date = reader.nextLine();
					Character c1 = new Character(fac, namec, date);
					co.addCharacter(name, c1);
				} else if (sel1 == 3) {
					System.out.println("Enter the name of Character");
					namec = reader.nextLine();
					System.out.println("Enter the power of character");
					double fac = 0.0;
					while (!ce) {
						try {
							fac = reader.nextDouble();
							reader.nextLine();
							ce = true;
						} catch (Exception e) {
							System.out.println("please choose a valid option");
						}

					}
					System.out.println("Enter date of character");
					String date = reader.nextLine();
					co.updateCharacter(name, namec, fac, date);
				} else if (sel1 == 4) {
					System.out.println("Enter the name of Character");
					namec = reader.nextLine();
					co.deleteCharacter(name, namec);
				}
			}
		}
	}

	public void registerClan() {

		boolean ce = false;
		int i = 0;
		while (!ce && i != 2) {
			System.out.println("Enter the name of clan");
			String name = reader.nextLine();
			if (co.findClan(name).equalsIgnoreCase("clan was not found")) {

				co.addClanS(name);
				ce = true;
			} else {
				System.out.println("the clan already exists");
				i++;
			}
		}
	}

	public void updateClan() {
		boolean ce = false;
		int i = 0;
		while (!ce && i != 2) {
			System.out.println("Enter the name of clan");
			String name = reader.nextLine();
			i++;
			if (!co.findClan(name).equalsIgnoreCase("clan was not found")) {
				System.out.println("Enter a new name of clan");
				String name1 = reader.nextLine();
				co.updateClan(name, name1);
				ce = true;
			} else {
				System.out.println("the clan was not found");

			}
		}
	}

	public void deleteClan() {
		System.out.println("Enter the name of clan");
		String name = reader.nextLine();

		if (!co.findClan(name).equalsIgnoreCase("clan was not found")) {
			co.deleteClan(name);
		} else {
			System.out.println("clan was not found");
		}
	}
}
