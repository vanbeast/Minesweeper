package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import model.GameModel;

public class SmileView extends JComponent {

	private static final long serialVersionUID = 42L;
	
	private final int SMILE_SIZE = 26;
	private final String PICTURES_FOLDER = "pictures/smile/";
	private final HashMap<Integer,String> PICTURES_MAP;
	private GameModel model;
	
	public SmileView(GameModel model)
	{
		this.model = model;
		PICTURES_MAP = getPicturesMap();
		setSize(SMILE_SIZE, SMILE_SIZE);
	}
	
	private HashMap<Integer, String> getPicturesMap()
	{
		int[] keys = {0, 1, 2, 3, 4};
		String[] values = {"smile", "smile_pushed", "smile_dead",
				           "smile_cool", "smile_scared"};
		
		HashMap<Integer, String> result = new HashMap<Integer, String>();
		for (int i = 0; i < keys.length; i++)
		{
			result.put(keys[i], PICTURES_FOLDER + values[i] + ".gif");
		}
		return result;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		int key = model.getCurrentSmile();
		String path = PICTURES_MAP.get(key);
		Image img = new ImageIcon(path).getImage();
		g.drawImage(img, 0, 0, SMILE_SIZE, SMILE_SIZE, this);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return getSize();
	}
	
	public void reset()	{
		this.repaint();
	}
	
	public int getSmileSize() {
		return SMILE_SIZE;
	}
}