
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class SudokuGUI extends JFrame{
    protected JTextField[][] matrizTablero= new JTextField[9][9];

    protected JButton comprobarBtn=new JButton("Comprobar");
    protected JButton resultadoBtn=new JButton("Rendirse");
    protected JButton nuevaPartidaBtn=new JButton("Nueva Partida");
    private JPanel tablero = new JPanel();
    private JPanel botones = new JPanel();
    Dimension tablDimension = new Dimension(50,50);
   
    SudokuGUI(){
        //Definir Layout
        tablero.setLayout(new GridLayout(9,9));
        botones.setSize(10,10);

        //Crear el tablero y cambiar propiedades
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrizTablero[i][j]= new JTextField();
                matrizTablero[i][j].setPreferredSize(tablDimension);
                matrizTablero[i][j].setFont(new Font("Cambria",Font.PLAIN,16));
                matrizTablero[i][j].setHorizontalAlignment(JTextField.CENTER);

                /*if(j==3 || j==6){
                matrizTablero[i][j].setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK));
                }
                if(i==2 || i==5){
                    matrizTablero[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK));
                    }*/
            }

        }
        
        
        //Añadir tablero y botones
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tablero.add(matrizTablero[i][j]);
            }
        }

        //Configurar Botones
        comprobarBtn.setFocusable(false);
        resultadoBtn.setFocusable(false);
        nuevaPartidaBtn.setFocusable(false);
        botones.add(comprobarBtn);
        botones.add(resultadoBtn);
        botones.add(nuevaPartidaBtn);

        //Propiedades de la ventana
        this.add(tablero,BorderLayout.CENTER);
        this.add(botones,BorderLayout.SOUTH);
        this.setTitle("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}