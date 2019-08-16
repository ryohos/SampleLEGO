import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

/**
 * LEGOのインテリジェントブロックにHello Worldと出すサンプルです。
 *
 * @author shinya
 * @version 0.1
 */
public class HelloWorld implements Executable {
	/**
	 * 実行します。
	 */
	public void execute() throws Exception
	{
		// LEGO のインテリジェントブロックにHello Worldという文字列を出す
        LCD.drawString("Hello World", 0, 4);

        // 5秒間(5000ms)待つ
        Delay.msDelay(5000);
	}
}
