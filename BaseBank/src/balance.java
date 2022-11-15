import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class balance extends JFrame{
    private JPanel pnlMain;
    private JButton btnBack;
    private JPanel pnlTop;
    private JLabel lbl;
    JLabel lblBal;

    public balance(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame2.setVisible(true);
                Login.frmBal.setVisible(false);
            }
        });
    }
}
