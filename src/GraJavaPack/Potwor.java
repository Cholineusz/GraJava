package GraJavaPack;

public abstract class Potwor 
{
	String nazwa;
	float hp;
	int exp;
	float speed;
	float atak;
	float obrona;
	float obronam;
	
	Potwor(String nazwa, float hp, int exp, float speed, float atak, float obrona, float obronam)
	{
		this.nazwa=nazwa;
		this.hp=hp;
		this.exp=exp;
		this.speed=speed;
		this.atak=atak;
		this.obrona=obrona;
		this.obronam=obronam;
	}
}
