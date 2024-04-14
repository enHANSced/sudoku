
import java.util.Random;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class Sudoku extends SudokuGUI{

    static SudokuGUI interfaz=new SudokuGUI();
    static int a[][] = new int[9][9];
    static final Font fuente= new Font("Calibri",Font.BOLD,18);
    static final Color rojoCustom=new Color(255, 102, 102);

    public static void main(String[] args) {
        generarSudoku();
        prepararTablero(interfaz);

        //--------------------Listener de Botones------------------------------------
        interfaz.comprobarBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comprobar()) {
                    JOptionPane.showMessageDialog(interfaz, "Has ganado la partida", "FELICIDADES", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        interfaz.resultadoBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRespuesta(interfaz);
            }
        });

        /*interfaz.nuevaPartidaBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a.length; j++) {
                        interfaz.matrizTablero[i][j].setText("");
                        //interfaz.matrizTablero[i][j].setBackground(Color.WHITE);
                    }
                }
                main(args);
            }
        });*/

        //---------------------------------------------------------------------------------------

    }

    public static void generarSudoku() {
        int p = 1;
        Random r = new Random();
        int i1=r.nextInt(8);
        int firstval = i1;
        while (p == 1) {
            int x = firstval, v = 1;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if ((x + j + v) <= 9)
                        a[i][j] = j + x + v;
                    else
                        a[i][j] = j + x + v - 9;
                    if (a[i][j] == 10)
                        a[i][j] = 1;
                    System.out.print(a[i][j]+" ");
                }
                x += 3;
                if (x >= 9)
                    x = x - 9;
                System.out.println();
                if (i == 2) {
                    v = 2;
                    x = firstval;
                }
                if (i == 5) {
                    v = 3;
                    x = firstval;
                }
            }
            p=0;
        }
        
    }

    public static void prepararTablero(SudokuGUI UI) {
        double random;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                random=Math.random();

                if (random<0.5) {
                    UI.matrizTablero[i][j].setFont(fuente);
                    UI.matrizTablero[i][j].setText(String.valueOf(a[i][j]));
                    UI.matrizTablero[i][j].setEditable(false);
                } 
                
            }
            
       }
    }

    public static boolean comprobar() {
        boolean ganador=true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                
                //jugada=Integer.parseInt(interfaz.matrizTablero[i][j].getText());
                
                    if (!String.valueOf(a[i][j]).equals(interfaz.matrizTablero[i][j].getText())) {
                        ganador=false;
                        
                        if(!interfaz.matrizTablero[i][j].getText().isEmpty()){
                            //interfaz.matrizTablero[i][j].setBackground(rojoCustom);
                            interfaz.matrizTablero[i][j].setBackground(rojoCustom);
                            interfaz.matrizTablero[i][j].setFont(fuente);
                        } 
                    }
                    else{
                        //interfaz.matrizTablero[i][j].setForeground(Color.BLACK);
                        if(interfaz.matrizTablero[i][j].isEditable()){
                            interfaz.matrizTablero[i][j].setBackground(Color.GREEN);
                            interfaz.matrizTablero[i][j].setFont(fuente);
                        } 
                    }
            }
        }
        return ganador;
    }

    public static void mostrarRespuesta(SudokuGUI UI) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(interfaz.matrizTablero[i][j].isEditable()){
                    UI.matrizTablero[i][j].setFont(fuente);
                    UI.matrizTablero[i][j].setForeground(Color.BLUE);
                    interfaz.matrizTablero[i][j].setBackground(Color.LIGHT_GRAY);
                    UI.matrizTablero[i][j].setText(String.valueOf(a[i][j]));
                    UI.matrizTablero[i][j].setEditable(false);
                }
            }
            
       }
    }
        
}

