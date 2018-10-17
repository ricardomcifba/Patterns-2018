/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blok.gui;

import blok.simulator.Simulator;
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
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import blok.interfaces.ISkinFactory;

/**
 *
 * @author sandroandrade
 */
public class MainPanel extends javax.swing.JPanel implements MouseListener, KeyListener {

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
        setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);
        m_playerImage = "images/Players/player" + Math.abs((new Random()).nextInt()%9) + ".png";
        playWav("sounds/background.wav", -1);
    }

    final void playWav(final String wavFile, final int times) {
        (new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println(AudioSystem.getMixerInfo()[1].getName());
                Clip clip = AudioSystem.getClip();
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File(wavFile));
                clip.open(ais);
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
    
    public void setSimulator(Simulator simulator) {
        m_simulator = simulator;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Body toBeRemoved = null;
        for (Body body : m_bodyRect.keySet()) {
            java.awt.Rectangle rect = m_bodyRect.get(body);
            if (rect.contains(e.getPoint()) && m_state == State.RUNNING && rect != m_player) {
                m_simulator.removeBody(body);
                toBeRemoved = body;
                break;
            }
        }
        if (toBeRemoved != null)
            m_bodyRect.remove(toBeRemoved);
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
    
    public void bodiesUpdated(ArrayList<Body> bodies) {
        Dimension size = getSize();
        for (Body body : bodies) {
            Vec2 position = body.getPosition();
            if (body.getUserData() != null)
                // Player
                m_bodyRect.get(body).setLocation(size.width/2-28 + (int) position.x, size.height/2-28 - (int) position.y);
            else
                // Block
                m_bodyRect.get(body).setLocation(size.width/2-14 + (int) position.x, size.height/2-14 - (int) position.y);
        }

        repaint();
    }

    public void bodiesCreated(ArrayList<Body> bodies) {
        m_bodyRect.clear();
        Dimension size = getSize();
        for (Body body : bodies) {
            Vec2 position = body.getPosition();
            Rectangle rectangle = new Rectangle();
            if (body.getUserData() != null)
            {
                // Player
                rectangle.setRect(-28, -28, 56, 56);
                rectangle.setLocation(size.width/2-28 + (int) position.x, size.height/2-28 - (int) position.y);
                m_player = rectangle;
            }
            else
            {
                // Block
                rectangle.setRect(-14, -14, 28, 28);
                rectangle.setLocation(size.width/2-14 + (int) position.x, size.height/2-14 - (int) position.y);
            }
            m_bodyRect.put(body, rectangle);
        }
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Dimension size = getSize();
                
        
        g2d.drawImage(new ImageIcon("images/Background/background.png").getImage(), 0, 0, null);
        g2d.drawImage(new ImageIcon("images/Ground/ground.png").getImage(), size.width/2-450, size.height/2-10+260, null);

        for (Rectangle rect : m_bodyRect.values()) {
            if (rect != m_player) {
                // Block
                try {
                    TexturePaint texturePaint = new TexturePaint(ImageIO.read(new File("images/Brick/brick.png")), rect);
                    g2d.setPaint(texturePaint);
                } catch (IOException ex) {
                    Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                // Player
                try {
                    TexturePaint texturePaint = new TexturePaint(ImageIO.read(new File(m_playerImage)), rect);
                    g2d.setPaint(texturePaint);
                } catch (IOException ex) {
                    Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
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
                m_simulator.init();
                m_simulator.stop();
                break;
            case RUNNING:
                m_simulator.start();
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
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private Simulator m_simulator;
    private HashMap<Body, Rectangle> m_bodyRect = new HashMap<Body, Rectangle>();
    private Rectangle m_player;
    public enum State {INITIAL, RUNNING, YOUWON, YOULOST};
    private State m_state = State.INITIAL;
    private String m_playerImage;
    private ISkinFactory skin;
}
