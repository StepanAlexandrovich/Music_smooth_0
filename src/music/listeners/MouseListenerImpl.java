package music.listeners;

import music.Main;
import music.core.PS;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerImpl implements MouseListener {
    private Main main;

    public MouseListenerImpl(Main main) {
        this.main = main;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton)e.getSource();

        switch (button.getName()){
            case PS.CYCLE: main.startStop(); break;
            case PS.NEXT: main.nextSong(); break;
            case PS.EXIT: main.exit(); break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
