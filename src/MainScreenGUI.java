import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class MainScreenGUI extends JFrame implements ActionListener, ChangeListener{

	Music music = new Music();
    JLabel myLabel = new JLabel();
    JLabel label2 = new JLabel();
    private int number = 0;
    private JSlider slider = new JSlider();
    
    public MainScreenGUI(){
    
    	music.fillPlaylist();
    	music.removeType();
    }
    public void create()
    {
        // Create JFrame
        JFrame myFrame = new JFrame("MP3 Test"); 
        
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create Panel
        JPanel myContent = new JPanel(); 
        myContent.setLayout(null);
        myContent.setPreferredSize(new Dimension(600, 200));
        myFrame.setContentPane(myContent);
        
        // Adding buttons
        JButton backward = new JButton("<<");
        backward.setBounds(25, 125, 50, 50);
        myContent.add(backward);
        backward.addActionListener(this);
        
        
        JButton pause = new JButton("Play/Pause");
        pause.setBounds(100, 125, 100, 50);
        myContent.add(pause);
        
        
        JButton forward = new JButton(">>");
        forward.setBounds(225, 125, 50, 50);
        myContent.add(forward);  
        forward.addActionListener(this);
        
        // Adding textDisplay
        myLabel.setBackground(Color.white);
        myLabel.setOpaque(true);
        myLabel.setBounds( 25, 50, 300, 25);
        myLabel.setText(music.getSong(number));
        myContent.add(myLabel);
        
        slider.setBounds(400, 50, 100, 30);
        slider.addChangeListener(this);
        myContent.add(slider);
        
        label2.setBackground(Color.white);
        label2.setOpaque(true);
        label2.setBounds( 510, 50, 30, 25);
        label2.setText("" + slider.getValue() + "%");
        myContent.add(label2);
        
        
        // Pack and display
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("<<")){
           if(number == 0){
               int temp = music.playlist.size();
               temp--;
               number = temp;
                myLabel.setText(music.getSong(temp));
           }else{
                number--;
                myLabel.setText(music.getSong(number));  
               
           }
            
       }
       if(e.getActionCommand().equals(">>")){
           int temp = music.playlist.size();
               temp--;
       
            if(number == temp){
                myLabel.setText(music.getSong(0));
                number = 0;
           }else{
                number++;
                myLabel.setText(music.getSong(number));
       }
       }
    }
	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println();
		String x = "" + slider.getValue() + "%";
		
		label2.setText(x);
	}   
    	
	

	
	
}
