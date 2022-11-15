import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainview extends JFrame {
    private JPanel pnlin;
    private JPanel pnlTop;
    private JLabel lbl;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton EFTButton;
    private JButton btnBal;
    private JButton btnAccs;
    private JButton updateProfileButton;
    public JLabel lblBal;
    private JButton btnLogout;
    private JLabel lblico;

    public mainview(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlin);
        this.pack();
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setVisible(true);
                Login.frame2.setVisible(false);
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame2.setVisible(false);
                Login.frmWith.setVisible(true);
            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame2.setVisible(false);
                Login.frmDep.setVisible(true);
            }
        });
        EFTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame2.setVisible(false);
                Login.frmTran.setVisible(true);
            }
        });
        btnBal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame2.setVisible(false);
                Login.frmBal.setVisible(true);
            }
        });
    }
}
