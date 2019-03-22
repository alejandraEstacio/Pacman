package model;

import java.io.Serializable;

public class Pacman implements Serializable{

	public static final String RIGHT = "der";
	public static final String LEFT = "izq";
	public static final String DOWN = "abajo";
	public static final String UP = "arriba";


	private int posX;
	private int posY;
	private int diameter;
	private double speed;
	private String address;
	
	
	
	public Pacman(int posX, int posY, int diameter, double speed, String address) {
		this.posX = posX;
		this.posY = posY;
		this.diameter = diameter;
		this.speed = speed;
		this.address = address;
		
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getDiameter() {
		return diameter;
	}


	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed= speed;
	}


	public String getAdress() {
		return address;
	}


	public void setAdress(String adress) {
		this.address = adress;
	}
	
	
	
	

	public void movePacman() {
		
		validateCollision();
		 
		if(address.equalsIgnoreCase(RIGHT)) {
			posX = (int)(posX+speed);
			
		}else if(address.equalsIgnoreCase(LEFT)) {
			posX = (int)(posX-speed);
			
		}else if(address.equalsIgnoreCase(DOWN)) {
			posY = (int)(posY+speed);
			
		}else {
			posY = (int)(posY-speed);
		}
	}
	
	public boolean validateCollision() {
		
		boolean validate = false;
		
		if(posX >= 700) {
			
			address = LEFT;
			validate = true;
			
		}
		if(posY >= 340) {
			
			address = UP;
			validate = true;
			
		}
		if(posY <= 0) {
			
			address = DOWN;
			validate = true;
			
		}
		if(posX <= 0) {
			
			address = RIGHT;
			validate = true;
			
		}
	return validate;
	}
	
	
}	