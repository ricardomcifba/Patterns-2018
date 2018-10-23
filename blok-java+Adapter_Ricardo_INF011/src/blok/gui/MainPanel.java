/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blok.gui;

import blok.engine.JBox2D;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import FactoryDarkSkin.DarkSkin;
import blok.interfaces.*;
import java.awt.geom.Point2D;

public class MainPanel extends javax.swing.JPanel implements MouseListener, KeyListener {

    /**
     * Creates new form MainPanel
     */
    public static MainPanel instance;
    
    protected MainPanel() {
    	
    	skin = new DarkSkin();
    	initComponents(skin);
        setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);
        m_playerImage = "images/Players/player" + Math.abs((new Random()).nextInt()%9) + ".png";
        playWav("sounds/background.wav", -1);
        
    }
    
    public static MainPanel getInstance(){
        if(instance ==null)
            instance = new MainPanel();
        return instance;
    }

    final void playWav(final String wavFile, final int times) {
        (new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println(AudioSystem.getMixerInfo()[1].getName());
                Clip clip = AudioSystem.getClip();
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File(wavFile));
               // clip.open(ais);
                clip.loop(times);
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }})).start();
    }
    
    public void ISimulator(ISimulator simulator) {
        m_jbox2d = simulator;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point2D toBeRemoved = null;
        for (Point2D point2d : m_p2dRect.keySet()) {
            java.awt.Rectangle rect = m_p2dRect.get(point2d);
            if (rect.contains(e.getPoint()) && m_state == State.RUNNING && rect != m_player) {
                m_jbox2d.removeBody(point2d);
                toBeRemoved = point2d;
                break;
            }
        }
        if (toBeRemoved != null)
            m_p2dRect.remove(toBeRemoved);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(m_state) {
            case INITIAL:
                setState(State.RUNNING);
                break;
            case YOUWON:
            case YOULOST:
                setState(State.INITIAL);
                break;
        }
    }
    
    public void bodiesUpdated(ArrayList<Point2D> bodies) {//Está com algum erro
        int i = 0;                                        //Quando utilizo no metodo run()
        Dimension size = getSize();                       //o jogo não apaga os blocos
        for (Point2D point2d : bodies) {            
            if (bodies.size() - 1 == i)//Substituindo o getUserData();
                // Player
                m_p2dRect.get(point2d).setLocation(size.width/2-28 + (int) point2d.getX(), size.height/2-28 - (int) point2d.getY());
            else
                // Block
                m_p2dRect.get(point2d).setLocation(size.width/2-14 + (int) point2d.getX(), size.height/2-14 - (int) point2d.getY());
            i++;
        }

        repaint();
    }

    public void bodiesCreated(ArrayList<Point2D> bodies) {
        int i = 0;
        m_p2dRect.clear();
        Dimension size = getSize();
        for (Point2D point2d : bodies) {
            Rectangle rectangle = new Rectangle();
            if (bodies.size() - 1 == i)
            {
                // Player
                rectangle.setRect(-28, -28, 56, 56);
                rectangle.setLocation(size.width/2-28 + (int) point2d.getX(), size.height/2-28 - (int) point2d.getY());
                m_player = rectangle;
            }
            else
            {
                // Block
                rectangle.setRect(-14, -14, 28, 28);
                rectangle.setLocation(size.width/2-14 + (int) point2d.getX(), size.height/2-14 - (int) point2d.getY());
            }
            m_p2dRect.put(point2d, rectangle);
            i++;
        }
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {//Está lentíssimo para repintar e estourando erro
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Dimension size = getSize();
        
        
        g2d.drawImage(new ImageIcon( skin.createBack().getPathName() ).getImage(), 0, 0, null);
        g2d.drawImage(new ImageIcon("images/Ground/ground.png").getImage(), size.width/2-450, size.height/2-10+260, null);

        for (Rectangle rect : m_p2dRect.values()) {
            if (rect != m_player) {
                // Block
                try {
                    TexturePaint texturePaint = new TexturePaint(ImageIO.read(new File( skin.createBlock().getPathName() )), rect);
                    g2d.setPaint(texturePaint);
                } catch (IOException ex) {
                    Logger.getLogger(JBox2D.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                // Player
                try {
                    TexturePaint texturePaint = new TexturePaint(ImageIO.read(new File(m_playerImage)), rect);
                    g2d.setPaint(texturePaint);
                } catch (IOException ex) {
                    Logger.getLogger(JBox2D.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            g2d.fill(rect);
        }

        int x;
        FontMetrics fm = null;
        
        
        if (m_state != State.RUNNING)
        {
            g2d.setPaint(Color.black);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRect(size.width/2-250, size.height/2-200-50, 500, 100);
            g2d.setPaint(new Color(0xDF, 0xC1, 0x01));
            g2d.fillRect(size.width/2-250, size.height/2-200-50, 500, 100);

            g2d.setPaint(Color.black);
            g2d.setFont(new Font("Times", Font.BOLD, 18));
            fm = g2d.getFontMetrics();
        }
        if (m_state == State.INITIAL)
        {
        	
            x = (int) fm.stringWidth("Remove all the blocks but do not")/2;
            g2d.drawString("Remove all the blocks but do not", size.width/2-x, size.height/2-200-10-5);

            x = fm.stringWidth("let this guy hit the ground, okay ?")/2;
            g2d.drawString("let this guy hit the ground, okay ?", size.width/2-x, size.height/2-200+10-5);
        }
        if (m_state == State.YOUWON)
        {
            x = (int) fm.stringWidth("Congratulations ! You won !")/2;
            g2d.drawString("Congratulations ! You won !", size.width/2-x, size.height/2-200);
        }
        if (m_state == State.YOULOST)
        {
            x = (int) fm.stringWidth("I'm sorry ! You lost !")/2;
            g2d.drawString("I'm sorry ! You lost !", size.width/2-x, size.height/2-200);
        }
        if (m_state != State.RUNNING)
        {
            g2d.setFont(new Font("Times", Font.BOLD, 10));
            fm = g2d.getFontMetrics();
            x = fm.stringWidth("Press any key to start")/2;
            g2d.drawString("Press any key to start", size.width/2-x, size.height/2-200+30);
        }
    }

    public void setState(State state) {
        m_state = state;
        switch(m_state) {
            case INITIAL:
                m_playerImage = "images/Players/player" + Math.abs((new Random()).nextInt()%9) + ".png";
                m_jbox2d.init();
                m_jbox2d.stop();
                break;
            case RUNNING:
                m_jbox2d.start();
                break;
        }
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(ISkinFactory skin) {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private ISimulator m_jbox2d;
    private JBox2D j_body = null;
    private HashMap<Point2D, Rectangle> m_p2dRect = new HashMap<Point2D, Rectangle>();
    private Rectangle m_player;
    public enum State {INITIAL, RUNNING, YOUWON, YOULOST};
    private State m_state = State.INITIAL;
    private String m_playerImage;
    private ISkinFactory skin;
}
