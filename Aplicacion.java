import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class Aplicacion implements ActionListener{

    JFrame ventana;

    JPanel panelBotones;

    JButton botonUno;
    JButton botonDos;
    JButton botonTres;

    JDialog jDialog1;

    private int cont;

    

    public Aplicacion(){
        cont = 0;

        ventana = new JFrame("Tarea Corta #4");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarComponentes();
        ventana.setPreferredSize(new DimensionUIResource(500, 500));
        ventana.pack();
        ventana.setVisible(true);
    }

    private void agregarComponentes(){
        botonUno = new JButton("Boton Uno");
        botonUno.addActionListener(this);
        botonDos = new JButton("Boton Dos");
        botonDos.addActionListener(this);
        botonTres = new JButton("Boton Tres");
        botonTres.addActionListener(this);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(15,5));

        panelBotones.add(botonUno);
        panelBotones.add(botonDos);
        panelBotones.add(botonTres);

        ventana.add(panelBotones, BorderLayout.LINE_START);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
                if(cont == 0 && e.getSource().equals(botonUno)){
                    cont = 1;
                    System.out.println("Se presiono el boton Uno");
                }
            
                if ((cont == 1 || cont == 2) && e.getSource().equals(botonUno))
                    throw new IOException();

                if(cont == 1 && e.getSource().equals(botonDos)){
                    cont = 2;
                    System.out.println("Se presiono el boton Dos");
                }
            
                if ((cont == 0 || cont == 2) && e.getSource().equals(botonDos))
                    throw new IOException();

                if(cont == 2 && e.getSource().equals(botonTres)){
                    cont = 3;
                    System.out.println("Se presiono el boton Tres");
                }
            
                if ((cont == 1 || cont == 0) && e.getSource().equals(botonTres))
                    throw new IOException();
        }
        catch(IOException e1){
            jDialog1.setVisible(true);
            jDialog1.setSize(200, 200);
            jDialog1.setTitle("Error en la secuencia de botones");
        }

        finally{
            cont = 0;
            actionPerformed(e);
        }
    }

    
    
}