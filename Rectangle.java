//
//David Ponder, dponder@student.unimelb.edu.au, 913036
//


public class Rectangle {
    int height, width;
	String sign;


//contains the settings for width and height of the shape
    private void settings(){
        settingWidth();
		settingHeight();
		settingSign();
    }

//sets width and checks if it is beyond the bounds of the page
	private void settingWidth(){
        System.out.println("width:");
        width = KinderKit.scanner.nextInt();
		if (width > DrawingCanvas.canvasWidth){
			System.out.println("Error! The width is too large (Current canvas size is "+DrawingCanvas.canvasWidth+"x"+DrawingCanvas.canvasHeight+"). Please try again.");
			settingWidth();	
		}
	}
//sets height and checks if it is beyond the bounds of the page
	private void settingHeight(){
        System.out.println("height:");
        height = KinderKit.scanner.nextInt();
		if (height > DrawingCanvas.canvasHeight){
			System.out.println("Error! The height is too large (Current canvas size is "+DrawingCanvas.canvasWidth+"x"+DrawingCanvas.canvasHeight+"). Please try again.");
			settingHeight();	
		}
	}
//sets the sign the rectangle will be drawn in
	private void settingSign(){
        System.out.println("Printing character:");
        sign = KinderKit.scanner.next();
		if (sign.length() > 1){
			System.out.println("Error! There must only be one character. Please try again.");
			settingSign();	
		}
	}

//starts the rectangle-drawing process
	public Rectangle start(Rectangle rectangle){
        rectangle.settings();
        return rectangle;

    }
}
