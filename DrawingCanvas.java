//
// David Ponder, dponder@student.unimelb.edu.au, 913036
//

//The parameters for the canvas
public class DrawingCanvas {
    public String background;
    static int canvasWidth, canvasHeight;
    public String[][] canvas;
    public int xpos=0, ypos=0;
        
//initialize canvas with no input
    public DrawingCanvas(){
        canvasWidth = 10;
        canvasHeight = 10;
        background = ".";
        canvas = new String[10][10];
        canvas = canvasMaker(canvasWidth, canvasHeight, background);
    }
//initialize canvas with input
    public DrawingCanvas(int width, int height, String background){
        canvasWidth = width;
        canvasHeight = height;
        this.background = background;
        canvas = new String[width][height];
        canvas = canvasMaker(canvasWidth, canvasHeight, background);
    }

//creates the canvas
    
	public String[][] canvasMaker(int width, int height, String sign) {
        String[][] array = new String[height][width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				array[i][j]=sign;
			}
		}
        canvas=array;
        return canvas;
	}
	

//draws up the canvas
    public void draw(){
        for (int i=0;i<canvas.length;i++){
            for(int j=0;j<canvas[0].length;j++){
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

//puts a triangle on the canvas
    public void drawTriangle(Triangle triangle){
        for (int i=0;i<triangle.width;i++){
            for(int j=0;j<triangle.width-i;j++){
                this.canvas[i][j]=triangle.sign;
            }
        }
    }
 //puts a rectangle on the canvas 
    public void drawRectangle(Rectangle rectangle){
        for(int i=0;i<rectangle.height;i++){
            for(int j=0;j<rectangle.width;j++){
                this.canvas[i][j]=rectangle.sign;
            }
        }
    }
    
  //wipes the canvas clean
    public void blank(){
		for(int i=0;i<canvas.length;i++) {
			for(int j=0;j<canvas[0].length;j++) {
				canvas[i][j]=background;
			};
		}
        xpos=0;
        ypos=0;      
    }
    
    
    
    
    
//===============TRIANGLE======================    
    
    

 //the menu for editing the triangle on the canvas   
    public void nextChoice(Triangle triangle) {
		System.out.println("Type Z/M for zooming/moving. Use other keys to quit the Zooming/Moving mode.");
		String op = KinderKit.scanner.next().toLowerCase();
		switch(op) {
		case("z"):
			draw(); //at DrawingCanvas line 43
			zoom(triangle);
			break;
		case("m"):
			draw(); //at DrawingCanvas line 43
			move(triangle);
			break;
		default:
			again(triangle);
			break;
		}
	}
 
 //the menu for zooming the triangle in and out
    private void zoom(Triangle triangle) {
		System.out.println("Type I/O to zoom in/out. Use other keys to go back to the Zooming/Moving menu.");
		String op = KinderKit.scanner.next().toLowerCase();
		switch(op) {
		case("i"):
			zoomIn(triangle);
			break;
		case("o"):
			zoomOut(triangle);
			break;
		default:
			draw(); //at DrawingCanvas line 43
			nextChoice(triangle);
			break;
		}
	}

 //zooms in the triangle by drawing the triangle 1 unit larger 
	private void zoomIn(Triangle triangle) {
		if(triangle.width+xpos>=canvas[0].length||triangle.width+ypos>=canvas.length){
			System.out.println("This triangle reaches its limit. You cannot make it bigger!");
			draw(); //at DrawingCanvas line 43
			zoom(triangle);
		}else{
			for (int i=0;i<=triangle.width;i++) {
				canvas[ypos+i][triangle.width+xpos-i]=triangle.sign;
			}
			
			triangle.width+=1;
			draw(); //at DrawingCanvas line 43
			zoom(triangle);
		}
	}
	//zoom out by blanking the outmost unit
	private void zoomOut(Triangle triangle) {
		if(triangle.width<=1){
			System.out.println("This triangle reaches its limit. You cannot make it smaller!");
			draw(); //at DrawingCanvas line 43
			zoom(triangle);
		}else{
			for (int i=0;i<triangle.width;i++){
				canvas[ypos+i][triangle.width+xpos-i-1]=background;
			}
			triangle.width-=1;
			draw(); //at DrawingCanvas line 43
			zoom(triangle);
		}
	}
  
//menu for moving the triangle	
	private void move(Triangle triangle) {
		System.out.println("Type A/S/W/Z to move left/right/up/down. Use other keys to go back to the Zooming/Moving menu.");
		String ans = KinderKit.scanner.next().toLowerCase();
		switch(ans){
			case("a"):
				left(triangle.width,"triangle"); //at DrawingCanvas line 111
				move(triangle);
				break;
			case("s"):
				right(triangle.width,"triangle"); //at DrawingCanvas line 92
				move(triangle);
				break;
			case("w"):
				up(triangle.width,"triangle"); //at DrawingCanvas line 54
				move(triangle);
				break;
			case("z"):
				down(triangle.width,"triangle"); //at DrawingCanvas line 73
				move(triangle);
				break;
			default:
				draw(); //at DrawingCanvas line 43
				nextChoice(triangle);
				break;
		}
	}

	
	
	
	
	
//=================RECTANGLE=========================	
	
	
	
	
	
	
//the menu for editing the rectangle on the canvas  	
	   public void nextChoice(Rectangle rectangle) {
			System.out.println("Type Z/M for zooming/moving. Use other keys to quit the Zooming/Moving mode.");
			String op = KinderKit.scanner.next().toLowerCase();
			switch(op) {
			case("z"):
				draw(); //at DrawingCanvas line 43
				zoom(rectangle);
				break;
			case("m"):
				draw(); //at DrawingCanvas line 43
				move(rectangle);
				break;
			default:
				again(rectangle);
				break;
			}
		}

//menu for zooming the rectangle in and out	 
	    private void zoom(Rectangle rectangle) {
			System.out.println("Type I/O to zoom in/out. Use other keys to go back to the Zooming/Moving menu.");
			String op = KinderKit.scanner.next().toLowerCase();
			switch(op) {
			case("i"):
				zoomIn(rectangle);
				break;
			case("o"):
				zoomOut(rectangle);
				break;
			default:
				draw(); //at DrawingCanvas line 43
				nextChoice(rectangle);
				break;
			}
		}
//zooms in the rectangle by adding a row at the bottom and adding units to the outer-right column	    
		private void zoomIn(Rectangle rectangle) {
			
			if(rectangle.height+ypos>=canvasHeight || rectangle.width+xpos>=canvasWidth){
				System.out.println("This rectangle reaches its limit. You cannot make it bigger!");
				draw(); //at DrawingCanvas line 43
				zoom(rectangle);
			}else{
				
				for (int i=0;i<=rectangle.height;i++){
					for (int j=0;j<=rectangle.width;j++){
						canvas[i+ypos][j+xpos]=rectangle.sign;
					}
				}
				rectangle.width+=1;
				rectangle.height+=1;
				draw(); //at DrawingCanvas line 43
				zoom(rectangle);
			}
		}

//zoom out by blanking the right-most column and bottom row
		private void zoomOut(Rectangle rectangle) {
			
			if(rectangle.width<=1||rectangle.height<=1){
				System.out.println("This rectangle reaches its limit. You cannot make it smaller!");
				draw(); //at DrawingCanvas line 43
				zoom(rectangle);
			}else{
	
				for (int i=0;i<rectangle.height;i++){
					canvas[i+ypos][rectangle.width-1+xpos]=background;
					}
				rectangle.height-=1;
				for (int j=0;j<rectangle.width;j++){
					canvas[rectangle.height+ypos][j+xpos]=background;
					}
				}

				rectangle.width-=1;
				draw(); //at DrawingCanvas line 43
				zoom(rectangle);
			}
		
	  
//menu for moving the rectangle	
		private void move(Rectangle rectangle) {
			System.out.println("Type A/S/W/Z to move left/right/up/down. Use other keys to go back to the Zooming/Moving menu.");
			String ans = KinderKit.scanner.next().toLowerCase();
			switch(ans){
				case("a"):
					left(rectangle.width,"rectangle"); //at DrawingCanvas line 111
					move(rectangle);
					break;
				case("s"):
					right(rectangle.width,"rectangle"); //at DrawingCanvas line 92
					move(rectangle);
					break;
				case("w"):
					up(rectangle.height,"rectangle"); //at DrawingCanvas line 54
					move(rectangle);
					break;
				case("z"):
					down(rectangle.height,"rectangle"); //at DrawingCanvas line 73
					move(rectangle);
					break;
				default:
					draw(); //at DrawingCanvas line 43
					nextChoice(rectangle);
					break;
			}
		}
	    


		
		

//FOR TRIANGLES and RECTANGLES
//each function moves the shape in the direction of the function name
    public void up(int width, String shape){
        if(ypos<=0){
            System.out.println("You cannot move this "+shape+" outside of the drawing canvas!");
            draw();
        }else{
			//making rows take the value of the row beneath it
            for(int i=1;i<canvas.length;i++){
                for(int j=0;j<canvas[0].length;j++){
                    canvas[i-1][j]=canvas[i][j];
                }
            }
            //Clears the only set of values that don't update with the given move
            for(int k=0;k<canvas[0].length;k++){
                canvas[canvas.length-1][k]=background;
            }
            ypos-=1;//updates the co-ord of the top-left corner of the shape
            draw();
         }
    }

    public void down(int width, String shape){
        if(width+ypos>=canvas.length){
            System.out.println("You cannot move this "+shape+" outside of the drawing canvas!");
            draw();
        }else{
			//making rows take the value of the row above it
            for(int i=canvas.length-1;i>0;i--){
                for(int j=0;j<canvas[0].length;j++){
                    canvas[i][j]=canvas[i-1][j];
                }
            }
            //Clears the only set of values that don't update with the given move
            for(int k=0;k<canvas[0].length;k++){
                canvas[0][k]=background;
            }   
            ypos+=1;//updates the co-ord of the top-left corner of the shape
            draw();
            } 
        }

    public void right(int width, String shape){
        if(width+xpos>=canvas[0].length){
            System.out.println("You cannot move this "+shape+" outside of the drawing canvas!");
            draw();
        }else{
			//making columns take the value of the column to it's left
            for(int i=0;i<canvas.length;i++){
                for(int j=canvas[0].length-1;j>0;j--){
                    canvas[i][j]=canvas[i][j-1];
                }
            }
            //Clears the only set of values that don't update with the given move
            for(int k=0;k<canvas.length;k++){
                canvas[k][0]=background;
            }
            xpos+=1;//updates the co-ord of the top-left corner of the shape
            draw();
        }
    }

    public void left(int width, String shape){
        if(xpos<=0){
            System.out.println("You cannot move this "+shape+" outside of the drawing canvas!");
            draw();
        }else{
			//making columns take the value of the column to it's right
            for(int i=0;i<canvas.length;i++){
                for(int j=1;j<canvas[0].length;j++){
                    canvas[i][j-1]=canvas[i][j];
                }
            }
            //Clears the only set of values that don't update with the given move
            for(int k=0;k<canvas.length;k++){
                canvas[k][canvas[0].length-1]=background;
            }
            xpos-=1; //updates the co-ord of the top-left corner of the shape
            draw();
        }

    }
  
    
//Asking if another triangle should be made
	private void again(Triangle triangle){
		System.out.println("Draw another triangle (Y/N)?");
		String ans = KinderKit.scanner.next().toLowerCase();
		switch(ans){
			case("y"): 
				blank();
				triangle=triangle.start(triangle);
				drawTriangle(triangle);
				draw(); //at DrawingCanvas line 43
				nextChoice(triangle);
				break;
			case("n"):
				blank();
				//KinderKit.makeChoice(); // at KinderKit line 62
				break;
			default:
				System.out.println("Unsupported option. Please try again!");
				again(triangle);
				break;
		}
	}

//Asking if another rectangle should be made
	private void again(Rectangle rectangle){
		System.out.println("Draw another rectangle (Y/N)?");
		String ans = KinderKit.scanner.next().toLowerCase();
		switch(ans){
			case("y"): 
				blank();
				rectangle=rectangle.start(rectangle);
				drawRectangle(rectangle);
				draw(); //at DrawingCanvas line 43
				nextChoice(rectangle);
				break;
			case("n"):
				blank();
				//KinderKit.makeChoice(); // at KinderKit line 62
				break;
			default:
				System.out.println("Unsupported option. Please try again!");
				again(rectangle);
				break;
		}
	}
}

