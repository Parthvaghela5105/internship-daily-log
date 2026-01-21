//Program to create an interface Playable with a method play() that takes no arguments and returns void. 
//Create three classes Football, Volleyball, and Basketball that implement the Playable interface and override 
//the play() method to play the respective sports.


interface Playable{
	void play();
}

class Football implements Playable{
	public void play(){
		System.out.println("Playing football");
	}
}
class Volleyball implements Playable{
	public void play(){
		System.out.println("Playing VolleyBall");
	}
}
class Basketball implements Playable{
	public void play(){
		System.out.println("Playing Basketball");
	}
}

class Sport{
	public static void main(String[] args){
		Football fb = new Football();
		fb.play();
		
		Volleyball vb = new Volleyball();
		vb.play();
		
		Basketball bb = new Basketball();
		bb.play();
	}
}