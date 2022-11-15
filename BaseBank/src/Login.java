import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

public class Login extends JFrame {
    private JPanel pnlMain;
    private JTextField tFid;
    private JPasswordField pFpass;
    private JLabel lblid;
    private JLabel lblMain;
    private JButton btnLogin;
    private JLabel lblOut;
    private JPanel pnlTop;
    private JLabel lbl;
    public static Login frame = new Login("Base Bank");
    public static mainview frame2 = new mainview("Base Bank ");
    public static withdraw frmWith = null;
    public static deposit frmDep = null;
    public static transfer frmTran = null;
    public static balance frmBal = null;
    public double[] a = new double[5];
    public Login(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);
        this.pack();
        lblOut.setVisible(false);
        String[] arrID=new String[5];
        arrID[0]="0103";
        arrID[1]="2851";
        arrID[2]="5708";
        arrID[3]="5157";
        arrID[4]="7089";
        String[] arrNames=new String[5];
        arrNames[0]="drzl";
        arrNames[1]="Saint Peter";
        arrNames[2]="Tebogo Thage II";
        arrNames[3]="lzrd";
        arrNames[4]="don";
        String[] arrPass=new String[5];
        arrPass[0]="drzl";
        arrPass[1]="Saint Peter";
        arrPass[2]="Tebogo Thage II";
        arrPass[3]="lzrd";
        arrPass[4]="don";
        int min = -10000;
        int max = 40000;
        //Generate random double value from 200 to 400
        System.out.println("Random value of type double between "+min+" to "+max+ ":");
        for (int j = 0; j < 5; j++) {
            a[j]=Math.random()*(max-min+1)+min;
        }
        btnLogin.addActionListener(new ActionListener() {
            int x=3;
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=tFid.getText();
                String pass=pFpass.getText();
                lblOut.setVisible(true);
                int i=found(arrID,id);
                //System.out.println(pass+i+arrPass[i]);
                if (i!=-1)
                {
                    if (Objects.equals(pass, arrPass[i]))
                    {
                        lblOut.setText("Welcome "+arrNames[i]);
                        lala();
                        //Main Menu
                        frame2.setSize(650, 560);
                        frame2.setLocationRelativeTo(null);
                        frame2.setVisible(true);
                        frame2.setResizable(false);

                        //Withdrawal
                        frmWith = new withdraw("Base Bank ",i);
                        frmWith.setSize(650, 250);
                        frmWith.setLocationRelativeTo(null);
                        frmWith.setResizable(false);
                        frmWith.lblBal.setText(balCol(a[i]));
                        frame2.lblBal.setText(balCol(a[i]));

                        //Deposit
                        frmDep = new deposit("Base Bank ",i);
                        frmDep.setSize(650, 250);
                        frmDep.setLocationRelativeTo(null);
                        frmDep.setResizable(false);
                        frmDep.lblBal.setText(balCol(a[i]));

                        //Transfer
                        frmTran = new transfer("Base Bank ",i,arrID);
                        frmTran.setSize(650, 250);
                        frmTran.setLocationRelativeTo(null);
                        frmTran.setResizable(false);
                        frmTran.lblBal.setText(balCol(a[i]));

                        //Balance
                        frmBal = new balance("Base Bank ");
                        frmBal.setSize(650, 220);
                        frmBal.setLocationRelativeTo(null);
                        frmBal.setResizable(false);
                        frmBal.lblBal.setText(balCol(a[i]));

                        //Hide login
                        frame.setVisible(false);
                    }
                    else
                    {
                        x--;
                        lblOut.setText("Wrong Password, "+x+" attempts left");
                        lblOut.setForeground(Color.red);
                        if (x<=0)
                        {
                            lblOut.setText("Account Blocked");
                        }
                    }
                }
                else
                {
                    lblOut.setText("The ID You entered isn't registered yet");
                    lblOut.setForeground(Color.red);
                }
            }
        });
    }

    public void lala(){
        if (lblOut.getForeground()==Color.green)
        {
            lblOut.setForeground(Color.black);
        }
        else
        {
            lblOut.setForeground(Color.green);
        }
    }

    public void logout(){
        lblOut.setText("You have heen Logged Out");
    }

    public static void main(String[] args) {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600, 300);
    }
    public static int found(String[] arrID, String id)
    {
        boolean f=false;
        int i=-1;
        for (String s : arrID) {
            i++;
            if (id.equals(s)) {
                f = true;
                break;
            }
        }
        if (!f)
        {
            i=-1;
        }
        return i;
    }
    public String balCol(double a)
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String bal=formatter.format(a);
        if (a<=0)
        {
            return ("<html><font color='black'>Balance </font> <font color='red'>"+bal+"</font></html>");
        }
        else {
            return ("<html><font color='black'>Balance </font> <font color='green'>"+bal+"</font></html>");
        }
    }
}