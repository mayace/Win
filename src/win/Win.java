package win;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Win extends JFrame{

    public Win(String title) throws HeadlessException {
        super(title);
        super.setContentPane(createContent());
    }

    @Override
    public void setContentPane(Container contentPane) {
		JPanel base = getBase();
		base.add(contentPane,BorderLayout.CENTER);
    }

	@Override
	public Container getContentPane() {
		return (Container) getBase().getComponent(0);
	}

	
    public void setStatusBar(Container statusBar){
        getBase().add(statusBar,BorderLayout.PAGE_END);
    }
    
    private Container createContent() {
        JPanel base=new JPanel(new BorderLayout());
		JPanel content=new JPanel();
		JPanel status=new JPanel();
		
		base.add(content,BorderLayout.CENTER);
		base.add(status,BorderLayout.PAGE_END);
		
        return base;
    }
    
	public static void main(String[] args) {
        Win win=new Win("Win");
		win.setContentPane(new JButton("ggg"));
		win.setStatusBar(new JButton("sdkfjsldkfj"));
		win.setSize(200, 100);
		System.out.println(win.getContentPane().getParent().getLayout());
		win.setVisible(true);
		
    }

	private JPanel getBase() {
		return (JPanel) super.getContentPane();
	}
}
