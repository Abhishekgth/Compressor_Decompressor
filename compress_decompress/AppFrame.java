
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class AppFrame extends JFrame implements ActionListener {

    JButton comButton;
    JButton decomButton;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        comButton= new JButton("Select File to compress");
        comButton.setBounds(20,100,200,30);
        comButton.addActionListener(this);

        decomButton= new JButton("select file todecompress");
        decomButton.setBounds(250,100,200,30);
        decomButton.addActionListener(this);

        this.add(comButton);
        this.add(decomButton);
        this.setSize(600,300);
        this.getContentPane().setBackground(Color.cyan);
        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==comButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compress.method(file);

                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }
        }
        if(e.getSource()==decomButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompress.method(file);

                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }


        }

    }
}
