import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;

public class withdraw extends JFrame{
    private JPanel pnlTop;
    private JLabel lbl;
    public JLabel lblBal;
    private JButton btnWith;
    private JTextField tFwith;
    private JButton btnBack;
    private JPanel pnlMain;
    private JLabel lblMessage;

    public withdraw(String title, int i) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        lblMessage.setVisible(false);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame2.setVisible(true);
                Login.frmWith.setVisible(false);
            }
        });
        btnWith.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMessage.setVisible(true);
                String am=tFwith.getText();
                double out;
                if (Objects.equals(am, ""))
                {
                    am="0";
                }
                try {
                    out = Double.parseDouble(am);
                } catch (NumberFormatException ex) {
                    throw new RuntimeException(ex);
                }
                double bal=Login.frame.a[i];
                if (out>=0) {
                    if (bal < out) {
                        lblMessage.setText("Not enough funds!!!");
                        lblMessage.setForeground(Color.red);
                    } else {
                        NumberFormat formatter = NumberFormat.getCurrencyInstance();
                        String suc = formatter.format(out);
                        lblMessage.setText(suc + " succesfully withdrawn");
                        lblMessage.setForeground(Color.green);
                        Login.frame.a[i] -= out;
                        bal = Login.frame.a[i];
                    }
                }
                else
                {
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
