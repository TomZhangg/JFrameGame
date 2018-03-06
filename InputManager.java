package tutorial13;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputManager implements KeyListener, MouseListener, MouseMotionListener{
	
	
	public static class KeyBoard{
		private int numKeys = 500;
		
		private boolean[] keyTyped = new boolean[numKeys];
		private boolean[] keyPressed = new boolean[numKeys];
		private boolean[] keyReleased = new boolean[numKeys];
		
		protected void toggleKeyTyped(int keyCode, boolean toggle){
			keyTyped[keyCode] = toggle;
			
		}
		protected void toggleKeyPressed(int keyCode, boolean toggle){
			keyPressed[keyCode] = toggle;
			
		}
		protected void toggleKeyReleased(int keyCode, boolean toggle){
			keyReleased[keyCode] = toggle;
		}
		
		public boolean isKeyTyped(int keyCode){
			return keyTyped[keyCode];
		}
		
		public boolean isKeyPressed(int keyCode){
			return keyPressed[keyCode];
		}
		
		public boolean isKeyReleased(int keyCode){
			boolean r = keyReleased[keyCode];
			keyReleased[keyCode] = false;
			return r;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static class Mouse{
		
		private int numButtons = 10;
		
		private boolean[] buttonClicked = new boolean[numButtons];
		private boolean[] buttonPressed = new boolean[numButtons];
		private boolean[] buttonReleased = new boolean[numButtons];
		
		private int x,y;
		
		private boolean inScreen;
		
		protected void toggleButtonClicked(int buttonCode, boolean toggle){
			buttonClicked[buttonCode] = toggle;
			
		}
		protected void toggleButtonPressed(int buttonCode, boolean toggle){
			buttonPressed[buttonCode] = toggle;
		}
		protected void toggleButtonReleased(int buttonCode, boolean toggle){
			buttonReleased[buttonCode] = toggle;
		}
		
		protected void updateCoordinates(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		protected void toggleInScreen(boolean toggle){
			inScreen = toggle;
		}
		
		public boolean isMouseClicked(int button){
			return buttonClicked[button];
		}
		
		public boolean isMousePressed(int button){
			return buttonPressed[button];
		}
		
		public boolean isMouseReleased(int button){
			boolean r = buttonReleased[button];
			buttonReleased[button] = false;
			return r;
		}
		
		
		public int getX(){
			return x;
		}
		
		public int getY(){
			return y;
		}
		

		
		public boolean isInScreen(){
			return inScreen;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private KeyBoard keyboard = new KeyBoard();
	private Mouse mouse = new Mouse();
	
	public InputManager(Component c){
		c.addKeyListener(this);
		c.addMouseListener(this);
		c.addMouseMotionListener(this);
	}
	
	public KeyBoard getKeyboard(){
		return keyboard;
	}
	
	public Mouse getMouse(){
		return mouse;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		keyboard.toggleKeyTyped(e.getKeyCode(), true);

	}
	@Override
	public void keyPressed(KeyEvent e) {
		keyboard.toggleKeyPressed(e.getKeyCode(), true);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keyboard.toggleKeyReleased(e.getKeyCode(), true);
		keyboard.toggleKeyTyped(e.getKeyCode(), false);
		keyboard.toggleKeyPressed(e.getKeyCode(), false);
	}
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mouse.toggleButtonClicked(e.getButton(), true);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		mouse.toggleButtonPressed(e.getButton(), true);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		mouse.toggleButtonReleased(e.getButton(), true);
		mouse.toggleButtonPressed(e.getButton(), true);
		mouse.toggleButtonClicked(e.getButton(), true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		mouse.toggleInScreen(true);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		mouse.toggleInScreen(false);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		mouse.updateCoordinates(e.getX(), e.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mouse.updateCoordinates(e.getX(), e.getY());
	}




	
	
	
	
	
}
