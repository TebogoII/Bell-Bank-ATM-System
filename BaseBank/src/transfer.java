import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class transfer extends JFrame{
    private JTextField tFrec;
    private JButton btnTran;
    private JPanel pnlTop;
    private JLabel lbl;
    JLabel lblBal;
    private JButton btnBack;
    private JLabel lblMessage;
    private JPanel pnlMain;
    private JTextField tFam;

    public transfer(String title, int i,String[] arrID) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        lblMessage.setVisible(false);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame2.setVisible(true);
                Login.frmTran.setVisible(false);
            }
        });
        btnTran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMessage.setVisible(true);
                int x=Login.found(arrID,tFrec.getText());
                String am=tFam.getText();
                Double bal=Login.frame.a[i];
                if (x!=-1)
                {
                    Double out = Double.parseDouble(am);
                    if (out<=bal)
                    {
                        Login.frame.a[x]+=out;
                        Login.frame.a[i]-=out;
                        bal-=out;
                        lblMessage.setForeground(Color.green);
                        NumberFormat formatter = NumberFormat.getCurrencyInstance();
                        String suc = formatter.format(out);
                        lblMessage.setText(suc+" transfer successfull");
                    }
                    else {
                        lblMessage.setForeground(Color.red);
                        lblMessage.setText("Not enough funds!!!");
                    }
                }
                else {
                    lblMessage.setForeground(Color.red);
                    lblMessage.setText("Account doesn't exist");
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
