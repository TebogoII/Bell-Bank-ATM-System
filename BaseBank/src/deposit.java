import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;

public class deposit extends JFrame{
    private JPanel pnlMain;
    private JPanel pnlTop;
    private JLabel lbl;
    JLabel lblBal;
    private JTextField tFDep;
    private JButton btnDep;
    private JButton btnBack;
    private JLabel lblMessage;
    public deposit(String title, int i) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        lblMessage.setVisible(false);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame2.setVisible(true);
                Login.frmDep.setVisible(false);
            }
        });
        btnDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMessage.setVisible(true);
                String am=tFDep.getText();
                double in;
                if (Objects.equals(am, ""))
                {
                    am="0";
                }
                try {
                    in = Double.parseDouble(am);
                } catch (NumberFormatException ex) {
                    throw new RuntimeException(ex);
                }
                double bal=Login.frame.a[i];
                if (in>=0) {
                    NumberFormat formatter = NumberFormat.getCurrencyInstance();
                    String suc=formatter.format(in);
                    lblMessage.setText(suc+" succesfully deposited");
                    lblMessage.setForeground(Color.green);
                    Login.frame.a[i]+=in;
                    bal=Login.frame.a[i];
                }
                else {
                    lblMessage.setText("Invalid Ammount!!!");
                    lblMessage.setForeground(Color.red);
                }
                Login.frame2.lblBal.setText(Login.frame.balCol(bal));
                Login.frmWith.lblBal.setText(Login.frame.balCol(bal));
                Login.frmDep.lblBal.setText(Login.frame.balCol(bal));
                Login.frmTran.lblBal.setText(Login.frame.balCol(bal));
                Login.frmBal.lblBal.setText(Login.frame.balCol(bal));
            }
        });
    }
}
