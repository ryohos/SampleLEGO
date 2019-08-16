import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lejos.remote.ev3.RMISampleProvider;
import lejos.remote.ev3.RemoteEV3;

/**
 * リモート接続してセンサー情報を取得するサンプルです。
 * 取得したデータは標準出力に出力されます。
 *
 * @author shinya
 * @version 0.1
 */
public class RemoteEv3Sensor implements Executable  {
	/**
	 * コンストラクタです。
	 *
	 * @param ipAddress IPアドレスです。
	 */
	public RemoteEv3Sensor(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	/**
	 * 実行します。
	 */
	public void execute() throws Exception
	{
        RemoteEV3 ev3 = null;
        RMISampleProvider TouchSensor = null;
        RMISampleProvider UltraSonicSensor = null;
        RMISampleProvider ColorSensor = null;
        RMISampleProvider GyroSensor = null;

        try {
            ev3 = new RemoteEV3(this.ipAddress);
            ev3.setDefault();
        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }

        TouchSensor = ev3.createSampleProvider("S1", "lejos.hardware.sensor.EV3TouchSensor","Touch");
        UltraSonicSensor = ev3.createSampleProvider("S2", "lejos.hardware.sensor.EV3UltrasonicSensor","Distance");
        ColorSensor = ev3.createSampleProvider("S3", "lejos.hardware.sensor.EV3ColorSensor","RGB");
        GyroSensor = ev3.createSampleProvider("S4", "lejos.hardware.sensor.EV3GyroSensor","Angle");

        try{
        	System.out.println("TouchSensor");
            printData(TouchSensor.fetchSample());
            System.out.println("UltraSonicSensor");
            printData(UltraSonicSensor.fetchSample());
            System.out.println("ColorSensor");
            printData(ColorSensor.fetchSample());
            System.out.println("GyroSensor");
            printData(GyroSensor.fetchSample());
        } finally {
            TouchSensor.close();
            UltraSonicSensor.close();
            ColorSensor.close();
            GyroSensor.close();
        }
	}

	/**
	 * EV3接続用のIPアドレスです。
	 */
	private String ipAddress;

	/**
	 * データを標準出力します。
	 * @param sample サンプリングデータです。
	 */
    private static void printData(float[] sample) {
        for(float data: sample) {
        	System.out.println(data);
        }
    }
}
