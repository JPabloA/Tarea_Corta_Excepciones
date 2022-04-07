import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Display implements ActionListener{
    JFrame ventana;

    ImageIcon unoIcon;
    ImageIcon dosIcon;
    ImageIcon tresIcon;
    ImageIcon inicioIcon;

    JLabel imagen;
    JPanel panelImagen;

    JButton primerbtn;
    JButton segundobtn;
    JButton tercerbtn;

    JPanel panelBotones;
    int contador = 1;

    public Display(){
        ventana = new JFrame("Tarea excepciones");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        agregarComponentes();
        ventana.pack();
        ventana.setVisible(true);
    }

    private void agregarComponentes(){
        unoIcon = new ImageIcon("Imagenes/Uno.jpg");
        dosIcon = new ImageIcon("Imagenes/dos.jpg");
        tresIcon = new ImageIcon("Imagenes/tres.jpg");
        inicioIcon = new ImageIcon("Imagenes/RFDS.jpg");

        imagen = new JLabel(inicioIcon);

        panelImagen = new JPanel();
        panelImagen.add(imagen,BorderLayout.CENTER);

        // Ventana tiene un ContentPane donde se agregan los componentes
        ventana.add(panelImagen, BorderLayout.CENTER);

        primerbtn = new JButton("Uno");
        primerbtn.addActionListener(this);
        segundobtn = new JButton("Dos");
        segundobtn.addActionListener(this);
        tercerbtn = new JButton("Tres");
        tercerbtn.addActionListener(this);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5,1));

        panelBotones.add(primerbtn);
        panelBotones.add(segundobtn);
        panelBotones.add(tercerbtn);

        ventana.add(panelBotones, BorderLayout.EAST);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        if (e.getSource().equals(primerbtn))
        {
            try{
                if (contador != 1){
                    imagen.setIcon(inicioIcon);
                    throw new IOException();
                }
                 else{
                    imagen.setIcon(unoIcon);
                    contador = 2;
                }
            }
            catch(IOException x){
                JOptionPane.showMessageDialog(ventana, "Incorrecto se presiono el boton 1 (Este no es el que seguia en la secuencia)");
            }  
        }

        if (e.getSource().equals(segundobtn)){
            try{
                if (contador !=2){
                    imagen.setIcon(inicioIcon);
                    contador = 1;
                    throw new IOException();
                }
                else{
                    imagen.setIcon(dosIcon);
                    contador = 3;
                }  
            }
            catch (IOException x) {
                JOptionPane.showMessageDialog(ventana, "Incorrecto se presiono el boton 2 (Este no es el que seguia en la secuencia)");
            }
        }
    
        if (e.getSource().equals(tercerbtn)){
            try{
                if (contador !=3){
                    imagen.setIcon(inicioIcon);
                    contador = 1;
                    throw new IOException();
                }
                else{
                    imagen.setIcon(tresIcon);
                    contador = 1;
                }  
            }
            catch (IOException x) {
                JOptionPane.showMessageDialog(ventana, "Incorrecto se presiono el boton 3 (Este no es el que seguia en la secuencia)");
        } 
    }
    }
}
