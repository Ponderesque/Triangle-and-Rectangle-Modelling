//
//David Ponder, dponder@student.unimelb.edu.au, 913036
//

import java.util.Scanner;

//the elements used in the KinderKit, including a static scanner so the DrawingCanvas doesn't need
//another scanner to work as some input is handled by it.
public class KinderKit {
	int height, width, choicecount;
	String sign;
	Triangle triangle;
	Rectangle rectangle;
	DrawingCanvas canvas;
	public static Scanner scanner;

	//constructor of KinderKit without give parameters
	public KinderKit(){
		height=10;
		width=10;
		sign=".";
	}
	
	//constructor of the KinderKit with give parameters
	public KinderKit(int newWidth, int newHeight, String newSign) {
		height=newHeight;
		width=newWidth;
		sign=newSign;
	}

//checks if your initial dimensions for the canvas are valid
	private void initialCheck(){
		if(height<=0||width<=0){
			System.out.println("Seems like the dimensions of the paper are infeasible. Try again.");
			System.exit(0);
		}
	}
	
	
	
//used for option 3, recreates a new canvas with the inputted parameters
	private DrawingCanvas update(DrawingCanvas myCanvas){
		System.out.print("Canvas width: ");
		width=scanner.nextInt();
		System.out.print("Canvas height: ");
		height=scanner.nextInt();
		System.out.print("Background character: ");
		sign=scanner.next();
		if(height<=0||width<=0){
			System.out.println("Seems like the dimensions of the paper are infeasible. Try again.");
			update(myCanvas);
		}
		myCanvas = new DrawingCanvas(width, height, sign);
		System.out.println("Drawing canvas has been updated!");
		System.out.println();
		header(); //back to the main menu
		return myCanvas;
	}

	//prints the initial phrase
	private void header() {
		
		System.out.println("Current drawing canvas settings:");
		System.out.println("- Width: "+width);
		System.out.println("- Height: "+height);
		System.out.println("- Background character: "+sign);
		System.out.println();
	}

//where you choose whcih option you want.	
	public void makeChoice(DrawingCanvas myCanvas) {
		
		//this is so multiple triangles are not initialised under the same name if the user creates a new
		//triangle or rectangle
		if (choicecount==0) {
			Triangle triangle = new Triangle();
			Rectangle rectangle = new Rectangle();
			choicecount+=1;
		}
		
		System.out.println("Please select an option. Type 4 to exit.");	
		System.out.println("1. Draw triangles\n"
						 + "2. Draw rectangles\n"
						 + "3. Update drawing canvas settings\n"
						 + "4. Exit");

		int choice = scanner.nextInt();
		switch(choice) {
		case(1):
			triangle = new Triangle(); //because of the first lines in the function, this won't create a namming error
			triangle = triangle.start(triangle); //at Triangle line 180
			myCanvas.drawTriangle(triangle);
			myCanvas.draw();
			myCanvas.nextChoice(triangle);
			makeChoice(myCanvas);
			break;
		case(2):
			rectangle =  new Rectangle();
			rectangle = rectangle.start(rectangle);
			myCanvas.drawRectangle(rectangle);
			myCanvas.draw();
			myCanvas.nextChoice(rectangle);
			makeChoice(myCanvas);
			//at Rectangle line 182
			break;
		case(3):
			myCanvas = update(myCanvas);
			makeChoice(myCanvas);
			break;
		case(4):
			scanner.close();
			System.out.println("Goodbye! We hope you had fun :)");
			break;
		default:
			System.out.println("Unsupported option. Please try again!");
			makeChoice(myCanvas);
		}
	}
	

   	
   	
   	
   	
   	
//boots up the KinderKit and begins the drawing process
	public static void main(String[] args) {
		
		//initialises the KinderKit with input parameters
		KinderKit myKit = new KinderKit(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
		scanner = new Scanner(System.in);
		DrawingCanvas myCanvas = new DrawingCanvas(myKit.width, myKit.height, myKit.sign);
		
		//canvas.canvasMaker()
		myKit.initialCheck();
		System.out.println("----DIGITAL KINDER KIT: LET'S PLAY & LEARN----");
		myKit.header();
		myKit.makeChoice(myCanvas);
		}	
		
	}

