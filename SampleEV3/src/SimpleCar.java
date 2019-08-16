import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class SimpleCar implements Executable {

	/**
	 * 実行します。
	 */
	public void execute() throws Exception {

		// サーボモーター
		EV3LargeRegulatedMotor motorL = null;
		EV3LargeRegulatedMotor motorR = null;

		// 超音波センサー
		EV3UltrasonicSensor sensor = null;

		try {
			motorL = new EV3LargeRegulatedMotor(MotorPort.C);
			motorR = new EV3LargeRegulatedMotor(MotorPort.B);
			motorL.setSpeed(100);
			motorR.setSpeed(200);

			sensor = new EV3UltrasonicSensor(SensorPort.S3);

			SampleProvider mode = sensor.getDistanceMode();
			float[] sampleData = new float[mode.sampleSize()];

			sensor.enable();

			motorL.backward();
			motorR.backward();

			while(true) {
				mode.fetchSample(sampleData, 0);
				float distance = sampleData[0];

				// 30cmまで近づいたら処理を止める
				if (distance < 0.3F) {
					motorL.stop();
					motorR.stop();

					break;
				}
				Delay.msDelay(100);
			}
		} finally {
			motorL.close();
			motorR.close();
			sensor.close();
		}

	}
}
