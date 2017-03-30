package pixLab.classes;

import java.awt.Color;
import java.io.IOException;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Isaac Bowen
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	public static void testSmallRandom() {
		Picture swan = new Picture("swan.jpg");
		swan.explore();
		swan.smallRandom();
		swan.explore();
	}

	public static void testMirrorVerticalRightToLeft() {
		Picture swan = new Picture("swan.jpg");
		swan.explore();
		swan.mirrorVerticalRightToLeft();
		swan.explore();
	}

	private static void testmirrorHorizontalBottomToTop() {
		Picture swan = new Picture("swan.jpg");
		swan.explore();
		swan.mirrorHorizontalBottomToTop();
		swan.explore();

	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(25);
		swan.explore();
	}

	private static void testEdgyPhotoDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.edgyPhoto(25);
		swan.explore();
	}

	private static void testSuperEdgyPhotoDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.superEdgyPhoto(10, 100);
		swan.explore();
	}

	private static void testMirrorGull() {
		Picture swan = new Picture("swan.jpg");
		swan.explore();
		swan.mirrorGull();
		swan.explore();
	}

	private static void testMirrorArms() {
		Picture swan = new Picture("snowman.jpg");
		swan.explore();
		swan.mirrorArms();
		swan.explore();
	}

	private static void testCopy(int startRow, int endrow) {
		Picture swan = new Picture("snowman.jpg");
		swan.explore();
		swan.copy(swan, startRow, endrow);
		swan.explore();
	}

	private static void fiveImageFilter() {
		Picture femaleLionAndHall = new Picture("femaleLionAndHall.jpg");
		femaleLionAndHall.superEdgyPhoto(80, 100);
		femaleLionAndHall.mirrorVerticalRightToLeft();
		femaleLionAndHall.smallRandom();
		femaleLionAndHall.mirrorHorizontalBottomToTop();
		femaleLionAndHall.mirrorTemple();
		femaleLionAndHall.explore();
	}

	private static void valentineMeme() {
	  Picture wifi = new Picture("wifi.jpg");
	  wifi.valentineMeme();
	  wifi.explore();
	  try {
		wifi.writeOrFail("IsaacsMeme.jpg");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	private static void glitchFilter(String image, int glitchAmount) {
		Picture theImage = new Picture(image);
		theImage.explore();
		theImage.glitch(theImage, glitchAmount);
		theImage.explore();
	}
	
	public static void testSteganography()
	{
		Picture source = new Picture("encode.png");
		source.explore();
		Picture hidden= new Picture("hidden.png");
		source.encode(hidden);
		source.explore();
		hidden.explore();
		source.decode();
	}
	
	public static void testChromakey()
	{
		Picture source = new Picture("blue-mark.jpg");
		source.explore();
		Picture greenScreen = new Picture("kitten2.jpg");
		source.chromaKey(new Color(255, 255, 255), greenScreen, 150);
		source.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		// testZeroBlue();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		// testMirrorVertical();
		// testMirrorVerticalRightToLeft();
		// testmirrorHorizontalBottomToTop();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		// testCollage();
		// testCopy(100, 100);
		// testEdgeDetection();
		// testEdgyPhotoDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testSuperEdgyPhotoDetection();
		// testSmallRandom();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
		// fiveImageFilter();
		// valentineMeme();
		//glitchFilter("snowman.jpg", 90);
		testChromakey();
	}
}