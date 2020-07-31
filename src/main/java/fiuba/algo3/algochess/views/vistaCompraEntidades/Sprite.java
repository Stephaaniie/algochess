package fiuba.algo3.Vista.EntidadesAComprar;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.LinkedList;
import java.util.List;
import java.io.File; 

public class Sprite {
	
    private int x;
    private int y;
    private int width;
    private int height;
    private int imageWidth;
    private int imageHeight;
    private int outWidth;
    private int outHeight;
    private BufferedImage image;
    private BufferedImage actualFrame;
    private List<List<BufferedImage>> frameList;

    public static final int DEFAULT_WIDTH = 32;
    public static final int DEFAULT_HEIGHT = 32;

    public Sprite(String filePath, int x, int y, int with, int height, int outWidth, int outHeight) {
        this.x = x;
        this.y = y;
        this.width = with;
        this.height = height;
        this.outWidth = outWidth;
        this.outHeight = outHeight;
        setImage(filePath);
        setFrameList();
    }

    public Sprite(String filePath, int x, int y, int with, int height) {
        this.x = x;
        this.y = y;
        this.width = with;
        this.height = height;
        this.outWidth = with;
        this.outHeight = height;
        setImage(filePath);
        setFrameList();
    }

    public Sprite(String filePath) {
        this.x = 0;
        this.y = 0;
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
        this.outWidth = DEFAULT_WIDTH;
        this.outHeight = DEFAULT_HEIGHT;
        setImage(filePath);
        setFrameList();
    }

    private void setImage(String filePath) {
        try {
            image = ImageIO.read(new File(filePath));
            imageWidth = image.getWidth() / width;
            imageHeight = image.getHeight() / height;
        } catch (Exception exception) {
            System.out.println("Error loading file: " + filePath + " - X");
            image = null;
        }
    }

    private void setFrameList() {
        frameList = new LinkedList<>();

        for (int y = 0; y < imageHeight; y++) {
            List<BufferedImage> frameSet = new LinkedList<>();
            for (int x = 0; x < imageWidth; x++) {
                frameSet.add(getSubImage(x, y));
            }
            frameList.add(frameSet);
        }
        setActualFrame(x, y);
    }

    private BufferedImage getSubImage(int x, int y) {
        return image.getSubimage(x * width, y * height, width, height);
    }

    public BufferedImage getFrame(int x, int y) {
        return frameList.get(y).get(x);
    }

    public List<BufferedImage> getFrameList(int index) {
        return frameList.get(index);
    }

    public BufferedImage getActualFrame() {
        if (outWidth != width || outHeight != height) {
            try {
                Image temp = actualFrame.getScaledInstance(outWidth, outHeight, Image.SCALE_SMOOTH);
                BufferedImage imgOut = new BufferedImage(outWidth, outHeight, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = imgOut.createGraphics();
                g2d.drawImage(temp, 0, 0, null);
                g2d.dispose();
                return imgOut;
            } catch(Exception e) {
                System.out.println("Failed to resize image.");
                return actualFrame;
            }
        } else {
            return actualFrame;
        }
    }

    public void setActualFrame(int x, int y) {
        actualFrame = getFrame(x, y);
    }

    public int getOutWidth() {
        return outWidth;
    }

    public int getOutHeight() {
        return outHeight;
    }

    public void setOutWidth(int outWidth) {
        this.outWidth = outWidth;
    }

    public void setOutHeight(int outHeight) {
        this.outHeight = outHeight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
	public BufferedImage getFrameActual() {
		return null;
	}

}
