package org.order.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;

public final class ImageUtil {
	
	// ��֤���ַ���
	private static final char[] chars = { 
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
		'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	// �ַ�����
	private static final int SIZE = 4;
	// ����������
	private static final int LINES = 5;
	// ���
	private static final int WIDTH = 80;
	// �߶�
	private static final int HEIGHT = 38;
	// �����С
	private static final int FONT_SIZE = 25;

	/**
	 * ���������֤�뼰ͼƬ
	 * Object[0]:��֤���ַ��� String
	 * Object[1]:��֤��ͼƬ BufferedImage
	 */
	public static Object[] createImage() {
		StringBuffer sb = new StringBuffer();
	
		BufferedImage image = new BufferedImage(
			WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Graphics graphic = image.getGraphics();
		
		graphic.setColor(Color.LIGHT_GRAY);
		
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
	
		Random ran = new Random();
		for (int i = 0; i <SIZE; i++) {
			
			int n = ran.nextInt(chars.length);
			
			graphic.setColor(getRandomColor());
			
			graphic.setFont(new Font(
				null, Font.BOLD + Font.ITALIC, FONT_SIZE));
		
			graphic.drawString(
				chars[n] + "", i * WIDTH / SIZE, HEIGHT-(FONT_SIZE / 2));
			
			sb.append(chars[n]);
		}
		
		for (int i = 0; i < LINES; i++) {
			
			graphic.setColor(getRandomColor());
			
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),
					ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		
		return new Object[]{sb.toString(), image};
	}

	/**
	 * ���ȡɫ
	 */
	public static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), 
				ran.nextInt(256), ran.nextInt(256));
		return color;
	}
	
	public static void main(String[] args) throws IOException {
		Object[] objs = createImage();
		BufferedImage image = (BufferedImage) objs[1];
		OutputStream os = new FileOutputStream("x.jpg");
		ImageIO.write(image, "jpeg", os);
		os.close();
	}

}
