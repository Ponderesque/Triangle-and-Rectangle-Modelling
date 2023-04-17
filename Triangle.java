//
//David Ponder, dponder@student.unimelb.edu.au, 913036
//


public class Triangle {
    int width;
    String sign;

//initialise the DrawingCanvas.canvas that triangle will use
    public Triangle(){
		width=1;
		sign=".";
    }

	public Triangle(int width, String sign){
		this.width=width;
		this.sign=sign;
	}


//sets width and checks if it is beyond the bounds of the page
	private int settingWidth(){
        System.out.println("Side length:");
        width = KinderKit.scanner.nextInt();
		if (width > DrawingCanvas.canvasWidth || width > DrawingCanvas.canvasHeight){
			System.out.println("Error! The side length is too long (Current canvas size is "+DrawingCanvas.canvasWidth+"x"+DrawingCanvas.canvasHeight+"). Please try again.");
			settingWidth();		
		}
		return width;
	}
//sets the character of the triangle
	private String settingSign(){
        System.out.println("Printing character:");
        sign = KinderKit.scanner.next();
		if (sign.length() > 1){
			System.out.println("Error! There must only be one character. Please try again.");
			settingSign();	
		}
		return sign;
	}

//starts creating the triangle
    public Triangle start(Triangle triangle){
    	//Triangle triangle = new Triangle();
        triangle.settingWidth();
        triangle.settingSign();
        return triangle;

    }
}


