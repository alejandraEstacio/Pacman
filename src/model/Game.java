package model;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

	private int level;
	private ArrayList<Pacman> pacmans;
	private int rebounds;

	
	public Game(int level) {
		this.rebounds = 0;
		this.level = 0;
		pacmans = new ArrayList<Pacman>();
		
		try {
			loadTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getRebounds() {
		return rebounds;
	}
	
	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ArrayList<Pacman> getPacmans() {
		return pacmans;
	}

	public void setPacmans(ArrayList<Pacman> pacmans) {
		this.pacmans = pacmans;
	}

	//pacman x pacman
	public boolean validateCollition() {
		boolean d = false;
		for (int i = 0; i < pacmans.size(); i++) {

			Pacman p1 = pacmans.get(i);

			for (int j = i+1; j < pacmans.size(); j++) {

				Pacman p2 = pacmans.get(j);

				double distance = giveDistance(i, j);
				//	double distance = Math.sqrt((pacmans.get(i).getPosX()-pacmans.get(j).getPosX())*(pacmans.get(i).getPosX()-pacmans.get(j).getPosX())+(pacmans.get(i).getPosY()-pacmans.get(j).getPosY())*(pacmans.get(i).getPosY()-pacmans.get(j).getPosY()));

				if(distance < (p1.getDiameter())+(p2.getDiameter())) {

					d = true;
					rebounds++;
					if(p1.getAdress() == Pacman.LEFT && p2.getAdress() == Pacman.RIGHT) {
						p1.setAdress(Pacman.RIGHT);
						p2.setAdress(Pacman.LEFT);

					} if(p1.getAdress() == Pacman.RIGHT && p2.getAdress() == Pacman.LEFT) {
						p1.setAdress(Pacman.LEFT);
						p2.setAdress(Pacman.RIGHT);

											
					}if(p1.getAdress() == Pacman.UP && p2.getAdress() == Pacman.DOWN) {
						p1.setAdress(Pacman.DOWN);
						p2.setAdress(Pacman.UP);

					}if(p1.getAdress() == Pacman.DOWN && p2.getAdress() == Pacman.UP) {
						p1.setAdress(Pacman.UP);
						p2.setAdress(Pacman.DOWN);
						
					}
				}
			}


		}

		return d;
	}

	public void addRebounds() {
		for (int i = 0; i < pacmans.size(); i++) {

			Pacman p1 = pacmans.get(i);
			if(p1.validateCollision()==true) {
				rebounds++;
			}
		}
	}
	public double giveDistance(int i, int j) {

		return Math.sqrt(((pacmans.get(i).getPosX()-pacmans.get(j).getPosX())*(pacmans.get(i).getPosX()-pacmans.get(j).getPosX()))+((pacmans.get(i).getPosY()-pacmans.get(j).getPosY())*(pacmans.get(i).getPosY()-pacmans.get(j).getPosY())));	
	}


	public void giveLevel() {


	}

	public void loadTxt() throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("./data/level.pac"));
		String line = in.readLine();
		
		while(line != null) {
			
			String[] arr = line.split(",");
			Pacman p = new Pacman(Integer.parseInt(arr[0].trim()),Integer.parseInt(arr[1].trim()), Integer.parseInt(arr[2].trim()), Integer.parseInt(arr[3].trim()), arr[4].trim());
			pacmans.add(p);
			
			line = in.readLine();
		
		}
	}
	
}
