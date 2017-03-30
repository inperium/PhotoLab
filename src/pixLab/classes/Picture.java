package pixLab.classes;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	public Object decode;

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	public void mirrorArms() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int height = pixels.length;
		int width = pixels[0].length - 1;

		for (int col = width; col >= 0; col--) {
			for (int row = height / 2 - 1; row >= 0; row--) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[height - row - 1][col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;

		for (int row = pixels.length - 1; row >= 0; row--) {
			for (int col = width / 2 - 1; col >= 0; col--) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - col - 1];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBottomToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int height = pixels.length;
		int width = pixels[0].length - 1;

		for (int col = width; col >= 0; col--) {
			for (int row = height / 2 - 1; row >= 0; row--) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[height - row - 1][col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorGull() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;

		for (int row = pixels.length - 1; row >= 0; row--) {
			for (int col = width / 2 - 1; col >= 0; col--) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - col - 1];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 21;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture swan = new Picture("swan.jpg");
		Picture temple = new Picture("temple.jpg");
		this.copy(swan, 5, 0);
		this.copy(temple, 140, 0);
		this.copy(swan, 240, 0);
		Picture flowerNoBlue = new Picture(temple);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(swan, 400, 0);
		this.copy(temple, 500, 0);
		this.mirrorHorizontalBottomToTop();
		this.write("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	/**
	 * Jr. Edge Detection
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgyPhoto(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = pixels.length - 1; row > 0; row--) {
			for (int col = pixels[0].length - 1; col > 0; col--) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col - 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.RED);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void superEdgyPhoto(int edgeDist, int randomChange) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = pixels.length - 1; row > 0; row--) {
			for (int col = pixels[0].length - 1; col > 0; col--) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col - 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist) {
					int colorChange = (int) (Math.random() * randomChange);
					int totalRed = colorChange + pixels[row][col].getRed();
					int totalGreen = colorChange + pixels[row][col].getGreen();
					int totalBlue = colorChange + pixels[row][col].getBlue();
					;
					leftPixel.setColor(new Color((totalRed > 255 ? 255 : totalRed),
							(totalGreen > 255 ? 255 : totalGreen), (totalBlue > 255 ? 255 : totalBlue)));
				}
			}
		}
	}

	public void smallRandom() {
		Pixel[][] currentPicture = this.getPixels2D();
		for (Pixel[] row : currentPicture) {
			for (Pixel currentPixel : row) {
				int redChange = (int) (Math.random() * 15);
				int finalRed = (redChange + currentPixel.getRed());
				currentPixel.setColor(
						new Color((finalRed > 255 ? 255 : finalRed), currentPixel.getBlue(), currentPixel.getBlue()));
			}

		}
	}

	public void valentineMeme() {
		Picture wifi = new Picture("wifi.jpg");
		String memeFirst = "IS YOUR NAME WI-FI?";
		addMessage(memeFirst, 350, 50);
		String memeSecond = "BECAUSE I'M FEELING A CONNECTION";
		addMessage(memeSecond, 150, 600);
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	public void glitch(Picture thePicture, int glitchAmount) {

		// Copies Random Parts of the image to other parts
		this.glitchCopy(glitchAmount);
		Pixel[][] currentPicture = this.getPixels2D();
		// Randomizes pixels based on the glitch amount specified
		for (Pixel[] row : currentPicture) {
			for (Pixel currentPixel : row) {
				// Red
				int redChange = (int) (glitchAmount / 10);
				int finalRed = ((redChange * (((int) (Math.random()) * 3) - 1)) + currentPixel.getRed());
				// Green
				int greenChange = (int) (glitchAmount / 10);
				int finalGreen = ((greenChange * (((int) (Math.random()) * 3) - 1)) + currentPixel.getGreen());
				// Blue
				int blueChange = (int) (glitchAmount / 10);
				int finalBlue = ((blueChange * (((int) (Math.random()) * 3) - 1)) + currentPixel.getBlue());
				// Final Color
				currentPixel.setColor(new Color(((finalRed > 255 || finalRed < 0) ? 120 : finalRed),
						((finalGreen > 255 || finalGreen < 0) ? 120 : finalGreen),
						((finalBlue > 255 || finalBlue < 0) ? 120 : finalBlue)));
			}
		}
	}

	public void glitchCopy(int amount) {
		int glitch = amount;
		Pixel[][] pixels = this.getPixels2D();
		int width = this.getWidth();
		int height = this.getHeight();
		for (int index = 0; index < glitch; index++) {
			int startWidth = ((int) (Math.random() * 100000) % width);
			int endWidth = ((int) (Math.random() * 100000) % (width - startWidth));
			int startHeight = ((int) (Math.random() * 100000) % height);
			int endHeight = ((int) (Math.random() * 100000) % (height - startHeight));
			int randomNumber = ((int) (Math.random() * 4)) + 1;
			System.out.println(randomNumber);
			for (int positionWidth = startWidth; positionWidth < endWidth; positionWidth++) {
				for (int positionHeight = startHeight; positionHeight < endHeight; positionHeight++) {
					if (randomNumber == 3) {
						System.out.println("1");
						pixels[positionHeight][positionWidth]
								.setColor(new Color(pixels[positionHeight][positionWidth].getRed(),
										pixels[positionHeight][positionWidth].getGreen(), 0));
					} else if (randomNumber == 2) {
						System.out.println("2");
						pixels[positionHeight][positionWidth]
								.setColor(new Color(0, pixels[positionHeight][positionWidth].getGreen(),
										pixels[positionHeight][positionWidth].getBlue()));
					} else {
						System.out.println("3");
						pixels[positionHeight][positionWidth]
								.setColor(new Color(pixels[positionHeight][positionWidth].getRed(), 0,
										pixels[positionHeight][positionWidth].getBlue()));
					}
				}
			}
		}
	}

	public void encode(Picture hiddenPicture) {

		Pixel[][] currentPicture = this.getPixels2D();
		Pixel[][] hiddenData = hiddenPicture.getPixels2D();

		Pixel hiddenPixel = null;
		Pixel currentPixel = null;

		for (int row = 0; row < currentPicture.length; row++) {
			for (int col = 0; col < currentPicture[0].length; col++) {
				hiddenPixel = hiddenData[row][col];
				currentPixel = currentPicture[row][col];

				if (hiddenPixel.getRed() == 255 && hiddenPixel.getGreen() == 255 && hiddenPixel.getBlue() == 255) {
					int currentRed = currentPixel.getRed();
					if (currentRed % 2 == 0) {
						currentPixel.setRed(currentRed - 1);
					}
				} else {
					int currentRed = currentPixel.getRed();
					if (currentRed % 2 != 0) {
						currentPixel.setRed(currentRed + 1);
					}
				}
			}
		}

	}

	public void decode() {
		Pixel[][] decoded = this.getPixels2D();
		Pixel currentPixel = null;

		for (int row = 0; row < decoded.length; row++) {
			for (int col = 0; col < decoded[0].length; col++) {
				currentPixel = decoded[row][col];
				int currentRed = currentPixel.getRed();
				if (currentRed % 2 == 0) {
					currentPixel.setColor(new Color(255, 0, 0));
				}
			}
		}
		this.explore();
	}

	public void chromaKey(Color greenscreenColor, Picture source, int diviation) {
		//Get the pixel information needed
		Pixel[][] sourcePixels = source.getPixels2D();
		Pixel[][] pixels = this.getPixels2D();

		//Loop through the picture
		for (int row = 0; row < sourcePixels.length; row++) {
			for (int col = 0; col < sourcePixels[0].length; col++) {
				//Get the inforation from the position we're at
				Pixel pixel = sourcePixels[row][col];
				int red = pixel.getRed();
				int green = pixel.getGreen();
				int blue = pixel.getBlue();
				
				//Check if color plus or minus the given amount is close enough to the user-specified color, and if so lets the background show through
				if(!(red < greenscreenColor.getRed() + diviation && red > greenscreenColor.getRed() - diviation &&
						green < greenscreenColor.getGreen() + diviation && green > greenscreenColor.getGreen() - diviation &&
						blue < greenscreenColor.getBlue() + diviation && blue > greenscreenColor.getBlue() - diviation)){
					pixels[row][col].setColor(pixel.getColor());
				}
			}
		}
	}

} 

// this } is the end of class Picture, put all new methods before this
