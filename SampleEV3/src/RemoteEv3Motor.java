import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lejos.hardware.Sound;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

public class RemoteEv3Motor implements Executable  {
	/**
	 * コンストラクタです。
	 *
	 * @param ipAddress IPアドレスです。
	 */
	public RemoteEv3Motor(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	/**
	 * 実行します。
	 */
	public void execute() throws Exception
	{
        RemoteEV3 ev3 = null;
        RMIRegulatedMotor m1 = null;
        RMIRegulatedMotor m2 = null;

        try {
            ev3 = new RemoteEV3(this.ipAddress);
            ev3.setDefault();
        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }

        System.out.println("RegulatedMotor");
        m1 = ev3.createRegulatedMotor("A",'L');
        m2 = ev3.createRegulatedMotor("B",'M');

        try {
	        Sound.beep();
	        System.out.println("MortorL");
	        // 標準速度で540度回転(1回転半)する
	        System.out.println(m1.getSpeed());
	        m1.rotate(540);
	        Sound.beep();
	        // 2倍のスピードで180度回転する
	        m1.setSpeed(m1.getSpeed()*2);
	        System.out.println(m1.getSpeed());
	        m1.rotate(180);
	        Sound.beep();
	        System.out.println("MortorM");
	        // 標準速度で240度回転する
	        System.out.println(m2.getSpeed());
	        m2.rotate(240);
        } finally {
        	m1.close();
        	m2.close();
        }
	}

	/**
	 * EV3接続用のIPアドレスです。
	 */
	private String ipAddress;
}
