package tutorial13;

import java.awt.Canvas;

import javax.swing.JFrame;

public abstract class Application implements Runnable{
	
	private RenderManager renderManager;
	private InputManager inputManager;
	
	private boolean running = false;
	
	public abstract void addRenderables();
	public abstract void update();
	
	public Application(String title, int width, int height){
		
		Canvas screen = new Canvas();
		screen.setSize(width, height);
		screen.setVisible(true);
		
		JFrame frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(screen);
		
		renderManager = new RenderManager(screen);
		inputManager = new InputManager(screen);
		
		addRenderables();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double ups = 60;
		double frameTime = 1000.0/ups;
		
		long timeAtLastUpdate = System.currentTimeMillis();
		
		
		while(running){
			if(System.currentTimeMillis() - timeAtLastUpdate >= frameTime){
				//updates
				renderManager.update();
				timeAtLastUpdate = System.currentTimeMillis();
			}
		}
		
	}
	
	public void start(){
		if(!running){
			running = true;
			new Thread(this).start();
		}
		
	}
	
	public RenderManager getRenderManager(){
		return renderManager;
	}
	
	public InputManager getInputManager(){
		return inputManager;
	}
}
