/**
 * LEGO Mindstroms EV3 で使用できるサンプルソースコードです。
 *
 * @author shinya
 * @version 0.1
 */
public class SampleEV3 {

	public static void main(String[] args) throws Exception {

		//Executable obj = new HelloWorld();
		// IPアドレスはインテリジェントブロックの内容を確認してください。
		// Executable obj = new RemoteEv3Sensor("192.168.3.151");
		//Executable obj = new RemoteEv3Motor("192.168.3.151");
		Executable obj = new SimpleCar();

		obj.execute();
	}

}
