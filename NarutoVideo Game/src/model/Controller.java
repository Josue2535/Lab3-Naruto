package model;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class Controller {

	private ArrayList<Clan> clans;

	public Controller() {
		this.clans = new ArrayList<Clan>();
	}

	public ArrayList<Clan> getFristClan() {
		return clans;
	}

	public void setFristClan(ArrayList<Clan> clans) {
		this.clans = clans;
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
		}catch(Exception e) {
			
		}
	}
	
	public void ordeningClub() {
		int inicial;
        for( inicial = 0; inicial < clans.size( ); inicial++ )
        {
            int minorPosition = inicial;
            Clan minorClan = clans.get( inicial );

            for( int i = inicial + 1; i < clans.size( ); i++ )
            {
                Clan positionClan = clans.get( i );

                if( positionClan.compareTo( minorClan ) < 0 )
                {
                    minorClan = positionClan;
                    minorPosition = i;
                }
            }

            if( minorPosition != inicial )
            {
                Clan temp = clans.get( inicial );
                clans.set( inicial, minorClan );
                clans.set( minorPosition, temp );
            }

        }
	}

	
}

